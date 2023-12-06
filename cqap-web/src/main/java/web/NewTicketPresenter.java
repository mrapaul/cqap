package web;

import com.lakeland.ris.ui.datamodel.*;
import com.peirs.datamodel.*;
import com.peirs.datamodel.dicom.*;
import com.peirs.datamodel.ticket.*;
import org.jetbrains.annotations.*;

import java.io.*;
import java.util.*;

public class NewTicketPresenter implements NewTicketView.Listener
{
    private final NewTicketModel model;
    private final NewTicketView view;

    public NewTicketPresenter(NewTicketModel model, NewTicketView view)
    {
        this.model = model;
        this.view = view;

        view.setListener(this);
        view.setContainers(model.getResultsContainer(),
                model.getGroups(),
                model.getInstitutions(),
                model.getPirs(),
                model.getSts(),
                model.getPACSContainer(),
                model.getExternalImagesContainer(),
                model.getInternalImagesContainer());
    }

    @Override public void query(DicomStudyQuery query)
    {
        model.search(query);
    }

    @Override public void reset()
    {
        model.reset();
    }

    @Override public void createTickets(Set<DicomStudyQueryResult> images,
                                        Set<TicketType> types,
                                        TicketPriority priority,
                                        Boolean submittedVariance)
    {
        String result = model.createTickets(images, types, priority, submittedVariance);
        view.displayCreateResult(result);
    }

    @Override public void editStudy(DicomStudyQueryResult image)
    {
        displayStudy(model.getStudy(image));
    }

    private void displayStudy(DicomStudy study)
    {
        Collection<DicomStudy> relatedExams = model.getRelatedStudies(study);
        view.displayStudy(study, relatedExams, this);
    }

    @Override public String uploadFile(File file)
    {
        return model.uploadFile(file);
    }

    @Override public String uploadPatientReport(@NotNull DicomStudy study, @NotNull File report)
    {
        return model.uploadPatientReport(study, report);
    }

    @Override public void saveStudy(DicomStudy study)
    {
        model.saveStudy(study);
    }

    @Override public void refreshExternalImages(PACS pacs, Date studyDate)
    {
        model.refreshExternalImages(pacs, studyDate);
    }

    @Override public void importImage(PACS pacs, ExternalDicomStudy externalDicomStudy)
    {
        List<DicomStudy> dicomStudies = model.importImage(pacs, externalDicomStudy);
        for (DicomStudy dicomStudy : dicomStudies)
        {
            displayStudy(dicomStudy);
        }
    }

    @Override public void searchForInternalImagesForExternalImage(ExternalDicomStudy externalDicomStudy)
    {
        model.searchForInternalStudies(externalDicomStudy);
    }

    @Override public void newPACSSelected()
    {
        model.newPACSSelected();
    }

    @Override public void savePACS(@NotNull PACS pacs)
    {
        model.savePACS(pacs);
    }

    @Override public void deletePACS(@NotNull PACS pacs)
    {
        model.deletePACS(pacs);
    }

    @Override public void addPACS()
    {
        if (model.addPACS())
        {
            view.editNewPACS("unassigned");
        }
    }

    @Override public void refreshPACS()
    {
        model.refreshPACS();
    }

    @Override public void filter(String text)
    {
        model.filterExternalImages(text);
    }
}
