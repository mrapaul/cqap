package web;

import ch.lambdaj.function.convert.*;
import com.cqap.client.*;
import com.cqap.util.*;
import com.peirs.datamodel.*;
import com.peirs.datamodel.attachments.*;
import com.peirs.datamodel.dicom.*;
import com.peirs.datamodel.ticket.*;
import com.vaadin.data.*;
import com.vaadin.data.util.*;
import com.vaadin.ui.*;


import java.io.*;
import java.util.*;

public class ArchiveModel
{
    private final User user;
    private final ClientRestService clientService;
    private final UI ui;
    private final BeanContainer<String, TicketQueryResult> results;
    private final BeanContainer<String, Group> groups;
    private final BeanContainer<String, Institution> institutions;
    private final IndexedContainer pirs;
    private final Converter<ProfessionalTicket, TicketQueryResult> ticketToQueryResultConverter;

    public ArchiveModel(User user,
                        ClientRestService clientService,
                        EntityCache cache,
                        UI ui)
    {
        this.user = user;
        this.clientService = clientService;
        this.ui = ui;
        results = new BeanContainer<String, TicketQueryResult>(TicketQueryResult.class);
        groups = new BeanContainer<String, Group>(Group.class);
        institutions = new BeanContainer<String, Institution>(Institution.class);
        pirs = new IndexedContainer();
        results.setBeanIdResolver(new AbstractBeanContainer.BeanIdResolver<String, TicketQueryResult>()
        {
            @Override public String getIdForBean(TicketQueryResult aTicketQueryResult)
            {
                return aTicketQueryResult.getTicketId();
            }
        });
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
        groups.addAll(cache.getGroups());
        institutions.addAll(cache.getInstitutions());
        for (String pir : cache.getPirs())
        {
            pirs.addItem(pir);
        }
        ticketToQueryResultConverter = new TicketQueryResultConverter();
    }

    public void search(TicketQuery query)
    {
        query.setUser(user);
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

    public Container getGroups()
    {
        return groups;
    }

    public Container getInstitutions()
    {
        return institutions;
    }

    public Container getPirs()
    {
        return pirs;
    }

    public ProfessionalTicket getTicket(TicketQueryResult queryResult)
    {
        return clientService.findProfessionalTicket(queryResult);
    }

    public List<TicketQueryResult> getTicket(String ticketId)
    {
        TicketQuery myQuery = new TicketQueryBuilder().setTicketId(ticketId).build();
        return clientService.findProfessionalTickets(myQuery);
    }

    public Collection<DicomStudy> getRelatedStudies(DicomStudy study)
    {
        return clientService.findRelatedExams(study);
    }

    public Collection<Attachment> getAttachments(ProfessionalTicket ticket)
    {
        return clientService.getTicketAttachments(ticket);
    }

    public void saveTicket(ProfessionalTicket ticket)
    {
        clientService.createOrUpdateDicomStudy(ticket.getStudy());
        ProfessionalTicket updateProfessionalTicket = clientService.createOrUpdateProfessionalTicket(ticket, user);
        final TicketQueryResult queryResult = ticketToQueryResultConverter.convert(updateProfessionalTicket);
        UI.getCurrent().access(new Runnable()
        {
            @Override public void run()
            {
                results.addItem(queryResult.getTicketId(), queryResult);
            }
        });
    }

    public void deleteTicket(ProfessionalTicket ticket)
    {
        clientService.deleteProfessionalTicket(ticket, user);
    }

    public void uploadFile(ProfessionalTicket ticket, File file)
    {
        clientService.addTicketAttachment(ticket, file);
    }

    public InputStream openAttachment(Attachment attachment) throws IOException
    {
        return clientService.getTicketAttachment(attachment);
    }

    public void deleteAttachment(Attachment attachment)
    {
        clientService.deleteTicketAttachment(attachment);
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
