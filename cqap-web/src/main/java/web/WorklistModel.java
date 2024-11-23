package web;

import ch.lambdaj.function.convert.*;
import com.cqap.client.*;
import com.cqap.util.*;
import com.google.common.collect.*;
import com.peirs.datamodel.*;
import com.peirs.datamodel.attachments.*;
import com.peirs.datamodel.dicom.*;
import com.peirs.datamodel.ticket.*;
import com.vaadin.data.*;
import com.vaadin.data.util.*;
import com.vaadin.ui.*;


import java.io.*;
import java.util.*;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

public class WorklistModel
{
    private final User user;
    private final ClientRestService clientService;
    private final EntityCache cache;
    private final UI ui;
    private final BeanContainer<String, TicketQueryResult> results;
    private final BeanContainer<String, Institution> institutions;
    private final Converter<ProfessionalTicket, TicketQueryResult> ticketToQueryResultConverter;

    public WorklistModel(User user,
                         ClientRestService clientService,
                         EntityCache cache,
                         UI ui)
    {
        this.user = user;
        this.clientService = clientService;
        this.cache = cache;
        this.ui = ui;
        results = new BeanContainer<String, TicketQueryResult>(TicketQueryResult.class);
        results.setBeanIdResolver(new AbstractBeanContainer.BeanIdResolver<String, TicketQueryResult>()
        {
            @Override public String getIdForBean(TicketQueryResult aTicketQueryResult)
            {
                return aTicketQueryResult.getTicketId();
            }
        });
        institutions = new BeanContainer<String, Institution>(Institution.class);
        institutions.setBeanIdResolver(new AbstractBeanContainer.BeanIdResolver<String, Institution>()
        {
            @Override public String getIdForBean(Institution aInstitution)
            {
                return aInstitution.getName();
            }
        });
        institutions.addAll(this.cache.getInstitutions());
        ticketToQueryResultConverter = new TicketQueryResultConverter();

        search();
    }

    public void search()
    {
        EnumSet<TicketStatus> elements = EnumSet.complementOf(EnumSet.of(
                TicketStatus.COMPLETED,
                TicketStatus.TECH_COMPLETED));
        List<String> statuses = Lists.newArrayList();
        for (TicketStatus status : elements)
        {
            statuses.add(status.name());
        }
        TicketQuery query = new TicketQueryBuilder().setTicketStatuses(statuses).setUser(user).build();
        final List<TicketQueryResult> tickets = clientService.findProfessionalTickets(query);

        Notification.show("Found " + tickets.size() + " tickets", Notification.Type.TRAY_NOTIFICATION);

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

    public Container getResultsContainer()
    {
        return results;
    }

    public ProfessionalTicket getTicket(TicketQueryResult queryResult)
    {
        return clientService.findProfessionalTicket(queryResult);
    }

    public Collection<DicomStudy> getRelatedStudies(DicomStudy study)
    {
        return clientService.findRelatedExams(study);
    }

    public Collection<Attachment> getAttachments(ProfessionalTicket ticket)
    {
        return clientService.getTicketAttachments(ticket);
    }

    public Container getInstitutions()
    {
        return institutions;
    }

    public void saveTicket(ProfessionalTicket ticket)
    {
        clientService.createOrUpdateDicomStudy(ticket.getStudy());
        updateTicketInList(clientService.createOrUpdateProfessionalTicket(ticket, user));
    }

    private void findUpdatedTicketAndUpdateWorklist(final ProfessionalTicket ticket)
    {
        ProfessionalTicket updatedTicket = clientService.findProfessionalTicket(ticket.getId());
        if (updatedTicket.getStatus() != TicketStatus.TECH_COMPLETED &&
                updatedTicket.getStatus() != TicketStatus.COMPLETED)
        {
            updateTicketInList(updatedTicket);
        }
        else
        {
            removeTicketFromList(updatedTicket);
        }
    }

    private void updateTicketInList(ProfessionalTicket ticket)
    {
        final TicketQueryResult queryResult = ticketToQueryResultConverter.convert(ticket);
        UI.getCurrent().access(new Runnable()
        {
            @Override public void run()
            {
                results.removeItem(queryResult.getTicketId());
                results.addItem(queryResult.getTicketId(), queryResult);
            }
        });
    }

    private void removeTicketFromList(final ProfessionalTicket ticket)
    {
        UI.getCurrent().access(new Runnable()
        {
            @Override public void run()
            {
                results.removeItem(ticket.getViewId());
            }
        });
    }

    public void uploadFile(ProfessionalTicket ticket, File file)
    {
        clientService.addTicketAttachment(ticket, file);
    }

    public InputStream openAttachment(Attachment attachment) throws IOException
    {
        return clientService.getTicketAttachment(attachment);
    }

    public void deleteTicket(ProfessionalTicket ticket)
    {
        clientService.deleteProfessionalTicket(ticket, user);
        removeTicketFromList(ticket);
    }

    public String complete(ProfessionalTicket ticket)
    {
        String complete = TicketTransitions.complete(clientService, ticket, user);
        if (complete == null)
        {
            findUpdatedTicketAndUpdateWorklist(ticket);
        }
        return complete;
    }

    public String pending(ProfessionalTicket ticket)
    {
        String pending = TicketTransitions.pending(clientService, ticket, user);
        if (pending == null)
        {
            findUpdatedTicketAndUpdateWorklist(ticket);
        }
        return pending;
    }

    public String completeTechReview(ProfessionalTicket ticket)
    {
        return TicketTransitions.techERPReviewCompletedAndPRTicketRequest(clientService, ticket, user);
    }

    public List<TicketQueryResult> getTicket(String ticketId)
    {
        TicketQuery myQuery = new TicketQueryBuilder().setTicketId(ticketId).build();
        return clientService.findProfessionalTickets(myQuery);
    }

    public ProfessionalTicket createCorrespondingTicket(ProfessionalTicket ticket)
    {
        return clientService.createCorrespondingTicket(ticket, user);
    }

    public void deleteAttachment(Attachment attachment)
    {
        clientService.deleteTicketAttachment(attachment);
    }

    public String uploadPatientReport(DicomStudy study, File report)
    {
        String reportText = clientService.addDicomStudyPatientReport(study, report);

        if (isNotEmpty(reportText))
        {
            study.setPatientReport(reportText);
            clientService.createOrUpdateDicomStudy(study);
        }

        return reportText;
    }

    public void resendReports(ProfessionalTicket ticket,
                              String addresses,
                              boolean erpReport,
                              boolean erpSiteCallReport,
                              boolean cmoReport,
                              boolean cmoSiteCallReport,
                              boolean techReport)
    {
        clientService.resendReports(new ResendReportRequest(ticket,
                addresses,
                erpReport,
                erpSiteCallReport,
                cmoReport,
                cmoSiteCallReport,
                techReport,
                user));
    }
}
