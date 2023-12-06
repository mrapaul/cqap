package web;

import com.cqap.client.*;
import com.cqap.util.*;
import com.google.common.collect.*;
import com.lakeland.ris.ui.datamodel.*;
import com.peirs.datamodel.*;
import com.peirs.datamodel.dicom.*;
import com.peirs.datamodel.hl7.*;
import com.peirs.datamodel.ticket.*;
import com.peirs.dicom.*;
import com.vaadin.data.*;
import com.vaadin.data.util.*;
import com.vaadin.data.util.filter.*;
import com.vaadin.ui.*;
import org.jetbrains.annotations.*;

import java.io.*;
import java.util.*;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

public class NewTicketModel
{
    @NotNull private final ClientRestService clientService;
    @NotNull private final User user;
    @NotNull private final EntityCache cache;
    @NotNull private final UI ui;
    @NotNull private final BeanContainer<String, DicomStudyQueryResult> results;
    @NotNull private final BeanContainer<String, Group> groups;
    @NotNull private final BeanContainer<String, Institution> institutions;
    @NotNull private final BeanContainer<String, ExternalDicomStudy> externalImages;
    @NotNull private final BeanContainer<String, DicomStudyQueryResult> internalImages;
    @NotNull private final PACSContainer pacsContainer;
    @NotNull private final IndexedContainer pirs;
    @NotNull private final IndexedContainer sts;

    public NewTicketModel(@NotNull ClientRestService clientService,
                          @NotNull User user,
                          @NotNull EntityCache cache,
                          @NotNull UI ui)
    {
        this.clientService = clientService;
        this.user = user;
        this.ui = ui;
        this.cache = cache;
        results = new BeanContainer<>(DicomStudyQueryResult.class);
        groups = new BeanContainer<>(Group.class);
        institutions = new BeanContainer<>(Institution.class);
        this.externalImages = new BeanContainer<>(ExternalDicomStudy.class);
        this.internalImages = new BeanContainer<>(DicomStudyQueryResult.class);
        this.pacsContainer = new PACSContainer();
        pirs = new IndexedContainer();
        sts = new IndexedContainer();
        results.setBeanIdResolver(new AbstractBeanContainer.BeanIdResolver<String, DicomStudyQueryResult>()
        {
            @Override public String getIdForBean(DicomStudyQueryResult aTicketQueryResult)
            {
                return aTicketQueryResult.getStudy().getId();
            }
        });
        results.addNestedContainerBean("study");
        groups.setBeanIdResolver(new AbstractBeanContainer.BeanIdResolver<String, Group>()
        {
            @Override public String getIdForBean(Group aGroup)
            {
                return aGroup.getName();
            }
        });
        institutions.setBeanIdResolver(new AbstractBeanContainer.BeanIdResolver<String, Institution>()
        {
            @Override public String getIdForBean(Institution aInstitution)
            {
                return aInstitution.getName();
            }
        });
        this.externalImages.setBeanIdResolver(new AbstractBeanContainer.BeanIdResolver<String, ExternalDicomStudy>()
        {
            @Override public String getIdForBean(ExternalDicomStudy bean)
            {
                return bean.getStudyInstanceUID();
            }
        });
        this.internalImages.setBeanIdResolver(new AbstractBeanContainer.BeanIdResolver<String, DicomStudyQueryResult>()
        {
            @Override public String getIdForBean(DicomStudyQueryResult bean)
            {
                return bean.getStudy().getId();
            }
        });
        this.pacsContainer.setBeanIdResolver(new AbstractBeanContainer.BeanIdResolver<String, PACS>()
        {
            @Override public String getIdForBean(PACS bean)
            {
                return bean.getId();
            }
        });

        groups.addAll(this.cache.getGroups());
        institutions.addAll(this.cache.getInstitutions());

        for (String pir : this.cache.getPirs())
        {
            pirs.addItem(pir);
        }

        for (String st : this.cache.getSts())
        {
            sts.addItem(st);
        }
    }

    public void search(DicomStudyQuery query)
    {
        final List<DicomStudyQueryResult> tickets = clientService.findDicomStudies(query);

        Notification.show("Found " + tickets.size() + " dicom studies", Notification.Type.TRAY_NOTIFICATION);

        ui.access(new Runnable()
        {
            @Override public void run()
            {
                results.removeAllContainerFilters();
                results.removeAllItems();
                results.addAll(tickets);
            }
        });
    }

    public void reset()
    {
        ui.access(new Runnable()
        {
            @Override public void run()
            {
                results.removeAllContainerFilters();
                results.removeAllItems();
            }
        });
    }

    public String createTickets(Set<DicomStudyQueryResult> images,
                                Set<TicketType> types,
                                TicketPriority priority,
                                Boolean submittedVariance)
    {

        List<CreateTicketRequest> requests = Lists.newArrayList();
        for (DicomStudyQueryResult image : images)
        {
            requests.add(new CreateTicketRequest(image.getStudy().getId(),
                    priority,
                    Lists.newArrayList(types),
                    submittedVariance,
                    image.getTickets(),
                    image.getTicketTypes()));
        }
        return clientService.createProfessionalTickets(new CreateTicketRequests(requests, user));
    }

    public DicomStudy getStudy(DicomStudyQueryResult image)
    {
        DicomStudy study = clientService.findDicomStudy(image.getStudy().getId());
        if (study.getStudyInstitution() == null)
        {
            Institution
                    myInstitution =
                    InstitutionFinder.findInstitution(study.getInstitutions(), Lists.<HL7>newArrayList(),
                            cache.getInstitutions());
            study.setStudyInstitution(myInstitution);
        }
        return study;
    }

    @NotNull
    public Container getResultsContainer()
    {
        return results;
    }

    @NotNull
    public Container getGroups()
    {
        return groups;
    }

    @NotNull
    public Container getInstitutions()
    {
        return institutions;
    }

    @NotNull
    public Container getPirs()
    {
        return pirs;
    }

    @NotNull
    public Container getSts()
    {
        return sts;
    }

    @NotNull
    public Container getExternalImagesContainer()
    {
        return externalImages;
    }

    @NotNull
    public Container getPACSContainer()
    {
        return pacsContainer;
    }

    @NotNull public Container getInternalImagesContainer()
    {
        return internalImages;
    }

    public String uploadFile(@NotNull File file)
    {
        Collection<DicomImage> images = Lists.newArrayList();
        StringBuilder myReportBuilder = new StringBuilder("Upload report : ").append("\n\n");
        try
        {
            DicomParser parser = new DicomParser();
            DicomImage image = parser.parse(file);
            if (image != null)
            {
                myReportBuilder.append("Patient mame : ")
                        .append(image.getPatientName())
                        .append("\n")
                        .append(" StudyInstanceUID : ")
                        .append(image.getSeriesInstanceUID())
                        .append("\n")
                        .append(" Tags : ")
                        .append(image.getTags().size())
                        .append("\n\n");
                images.add(image);
            }
            else
            {
                myReportBuilder.append("File could not be parsed").append("\n");
            }

            List<DicomStudy> dicomStudies = toStudies(images);
            for (DicomStudy myDicomStudy : dicomStudies)
            {
                if (myDicomStudy.getTags() != null && !myDicomStudy.getTags().isEmpty())
                {

                    myReportBuilder.append("Created study with StudyInstanceUID : ")
                            .append(myDicomStudy.getStudyInstanceUID())
                            .append(" with ")
                            .append(myDicomStudy.getImageCount())
                            .append(" images")
                            .append("\n");
                    List<DicomStudy> myStudies =
                            clientService.findDicomStudiesByStudyInstanceUID(myDicomStudy.getStudyInstanceUID());
                    if (!myStudies.isEmpty())
                    {
                        updateExistingStudy(clientService, myDicomStudy, myStudies);
                    }
                    else
                    {
                        clientService.createOrUpdateDicomStudy(myDicomStudy);
                    }
                }
                else
                {
                    myReportBuilder.append("Study with StudyInstanceUID :")
                            .append(myDicomStudy.getStudyInstanceUID())
                            .append(" contains no tags and was not persisted")
                            .append("\n");
                }
            }

        }
        catch (Exception e)
        {
            myReportBuilder.append(e.getMessage()).append("\n");
            Notification.show("Error uploading studies " + e.getMessage(), Notification.Type.ERROR_MESSAGE);
        }

        return myReportBuilder.toString();
    }

    private void updateExistingStudy(@NotNull ClientRestService clientRestService,
                                     @NotNull DicomStudy aStudy,
                                     @NotNull List<DicomStudy> aStudies)
    {
        for (DicomStudy myStudy : aStudies)
        {
            if (aStudy.getTags().size() != myStudy.getTags().size())
            {
                myStudy.setTags(getUniqueTags(aStudy, myStudy));
            }
            Set<String> mySeriesInstanceUIDs = aStudy.getSeriesInstanceUIDs();
            if (!myStudy.getSeriesInstanceUIDs().containsAll(mySeriesInstanceUIDs))
            {
                myStudy.setSeriesInstanceUIDs(Sets.symmetricDifference(mySeriesInstanceUIDs,
                        myStudy.getSeriesInstanceUIDs()));
                myStudy.setImageCount(myStudy.getImageCount() + aStudy.getImageCount());
            }
            clientRestService.createOrUpdateDicomStudy(myStudy);
        }
    }

    private Sets.SetView<DicomTag> getUniqueTags(@NotNull DicomStudy aExistingStudy, @NotNull DicomStudy myStudy)
    {
        return Sets.symmetricDifference(Sets.newHashSet(aExistingStudy.getTags()), Sets.newHashSet(myStudy.getTags()));
    }

    private List<DicomStudy> toStudies(@NotNull Collection<DicomImage> aImages)
    {
        List<DicomStudy> myStudies = Lists.newArrayList();
        Multimap<String, DicomImage> myImages = HashMultimap.create();

        for (DicomImage myImage : aImages)
        {
            String myStudyInstanceUID = myImage.getStudyInstanceUID();
            if (myImage.getTags().size() > 1 && myStudyInstanceUID != null)
            {
                myImages.put(myStudyInstanceUID, myImage);
            }
        }

        for (String myStudyId : myImages.keySet())
        {
            DicomStudy myStudy = new DicomStudy();
            myStudy.setImages(myImages.get(myStudyId));
            myStudies.add(myStudy);
        }

        return myStudies;
    }

    public String uploadPatientReport(@NotNull DicomStudy study, @NotNull File report)
    {
        String reportText = clientService.addDicomStudyPatientReport(study, report);

        if (isNotEmpty(reportText))
        {
            study.setPatientReport(reportText);
            clientService.createOrUpdateDicomStudy(study);
        }

        return reportText;
    }

    public Collection<DicomStudy> getRelatedStudies(@NotNull DicomStudy study)
    {
        return clientService.findRelatedExams(study);
    }

    public void saveStudy(@NotNull DicomStudy study)
    {
        DicomStudy updateDicomStudy = clientService.createOrUpdateDicomStudy(study);
        DicomStudyQuery query = new DicomStudyQueryBuilder().setStudyInstanceUID(updateDicomStudy.getStudyInstanceUID())
                .build();
        final List<DicomStudyQueryResult> dicomStudies = clientService.findDicomStudies(query);
        ui.access(new Runnable()
        {
            @Override public void run()
            {
                results.addAll(dicomStudies);
            }
        });
    }

    public void refreshExternalImages(@NotNull PACS pacs, @NotNull Date studyDate)
    {
        final
        Collection<ExternalDicomStudy>
                images =
                clientService.getExternalImages(new ExternalDicomStudyRequest(studyDate, pacs));
        ui.access(new Runnable()
        {
            @Override public void run()
            {
                internalImages.removeAllContainerFilters();
                internalImages.removeAllItems();
                externalImages.removeAllContainerFilters();
                externalImages.removeAllItems();
                externalImages.addAll(images);
            }
        });
    }

    public void searchForInternalStudies(@NotNull ExternalDicomStudy externalDicomStudy)
    {
        final List<DicomStudyQueryResult> studies = Lists.newArrayList();
        DicomStudyQuery query = new DicomStudyQueryBuilder().setAccessionNumber(externalDicomStudy.getAccessionNumber())
                .build();
        studies.addAll(clientService.findDicomStudies(query));
        ui.access(new Runnable()
        {
            @Override public void run()
            {
                internalImages.removeAllContainerFilters();
                internalImages.removeAllItems();
                internalImages.addAll(studies);
            }
        });
    }

    public List<DicomStudy> importImage(@NotNull PACS pacs, @Nullable ExternalDicomStudy externalDicomStudy)
    {
        return clientService.importImage(pacs, externalDicomStudy);
    }

    public void newPACSSelected()
    {
        ui.access(new Runnable()
        {
            @Override public void run()
            {
                internalImages.removeAllContainerFilters();
                internalImages.removeAllItems();
                externalImages.removeAllContainerFilters();
                externalImages.removeAllItems();
            }
        });
    }

    public void savePACS(PACS pacs)
    {
        clientService.createOrUpdatePACS(pacs);
        refreshPACS();
    }

    public void deletePACS(PACS pacs)
    {
        clientService.deletePACS(pacs);
        refreshPACS();
    }

    public void refreshPACS()
    {
        final List<PACS> pacses = clientService.findAllPACS();
        ui.access(new Runnable()
        {
            @Override public void run()
            {
                pacsContainer.removeAllItems();
                pacsContainer.removeAllContainerFilters();
                pacsContainer.addAll(pacses);
            }
        });
    }

    public boolean addPACS()
    {
        pacsContainer.removeAllContainerFilters();
        if (!pacsContainer.containsId("unassigned"))
        {
            BeanItem<PACS> pacs = pacsContainer.addItemAt(0);
            pacs.getBean().setId("unassigned");

            return true;
        }
        else
        {
            Notification.show("Please finish creating the last PACS location before creating another one");
        }

        return false;
    }

    public void filterExternalImages(String text)
    {
        externalImages.removeAllContainerFilters();
        if (text.trim().isEmpty())
        {
            return;
        }

        Container.Filter[] filtersToAdd = new Container.Filter[2];
        int i = 0;
        for (String propertyName : Lists.newArrayList("accessionNumber", "patientName"))
        {
            filtersToAdd[i++] = new Or(new SimpleStringFilter(propertyName, text, true, false));
        }
        Container.Filter f = new Or(filtersToAdd);
        externalImages.addContainerFilter(f);
    }
}
