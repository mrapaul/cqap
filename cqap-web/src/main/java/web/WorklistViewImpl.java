package web;

import com.peirs.datamodel.*;
import com.peirs.datamodel.attachments.*;
import com.peirs.datamodel.dicom.*;
import com.peirs.datamodel.ticket.*;
import com.vaadin.data.*;
import com.vaadin.data.util.*;
import com.vaadin.event.*;
import com.vaadin.navigator.*;
import com.vaadin.server.*;
import com.vaadin.ui.*;

import org.tepi.filtertable.*;

import java.util.*;

public class WorklistViewImpl extends CssLayout implements WorklistView
{
    private final User user;
    private final FilterTable searchResultsTable;
    private final Button refreshButton;
    private final TabSheet tabSheet;
    private final Label totalsLabel;
     private WorklistView.Listener listener;

    public WorklistViewImpl(User user)
    {
        this.user = user;
        searchResultsTable = new FilterTable();
        refreshButton = new Button();
        tabSheet = new TabSheet();
        totalsLabel = new Label();
        initLayout();
        initListeners();
    }

    private void initLayout()
    {
        setSizeFull();

        refreshButton.setIcon(FontAwesome.REFRESH);
        refreshButton.addStyleName("fq");
        Label pageLabel = new Label("Open Tickets");
        pageLabel.addStyleName("h1");
        Label label2 = new Label("Total Tickets : ");
        label2.addStyleName("h2");
        totalsLabel.addStyleName("h2");
        HorizontalLayout enclosure = new HorizontalLayout(label2, totalsLabel);
        totalsLabel.setImmediate(true);

        HorizontalLayout topLayout = new HorizontalLayout(pageLabel, enclosure, refreshButton);
        topLayout.setWidth("100%");
        topLayout.setMargin(true);
        topLayout.setComponentAlignment(enclosure, Alignment.BOTTOM_CENTER);
        topLayout.setComponentAlignment(refreshButton, Alignment.BOTTOM_RIGHT);

        searchResultsTable.addStyleName("plain");
        searchResultsTable.setSizeFull();
        CssLayout mainLayout = new CssLayout(topLayout, searchResultsTable);
        mainLayout.setSizeFull();

        tabSheet.setSizeFull();
        tabSheet.addTab(mainLayout, "Tickets");
        addComponent(tabSheet);
    }

    private void initListeners()
    {
        refreshButton.addClickListener(new Button.ClickListener()
        {
            @Override public void buttonClick(Button.ClickEvent event)
            {
                if (listener != null)
                {
                    listener.query();
                }
            }
        });
        searchResultsTable.addItemClickListener(new ItemClickEvent.ItemClickListener()
        {
            @Override public void itemClick(ItemClickEvent event)
            {
                Object itemId = event.getItemId();
                if (itemId != null && listener != null)
                {
                    Item item = searchResultsTable.getContainerDataSource().getItem(itemId);
                    if (item != null)
                    {
                        listener.ticketSelected(((BeanItem<TicketQueryResult>) item).getBean());
                    }
                }
            }
        });
        searchResultsTable.addItemSetChangeListener(new Container.ItemSetChangeListener()
        {
            @Override public void containerItemSetChange(Container.ItemSetChangeEvent event)
            {
                totalsLabel.setValue(String.valueOf(searchResultsTable.size()));
            }
        });

    }

    @Override public void enter(ViewChangeListener.ViewChangeEvent event)
    {
        // empty
    }

    @Override public void setListener(WorklistView.Listener listener)
    {
        this.listener = listener;
    }

    @Override public void setContainers(Container queryResults)
    {
        searchResultsTable.setFilterBarVisible(true);
        searchResultsTable.setContainerDataSource(queryResults);
        searchResultsTable.setVisibleColumns("submittedDate",
                "viewId",
                "type",
                "priority",
                "status",
                "category",
                "studyDate",
                "patientName",
                "institution",
                "accessionNumber",
                "modality",
                "studyDescription",
                "ERP");
        searchResultsTable.setColumnHeader("submittedDate", "Submitted Date");
        searchResultsTable.setColumnHeader("viewId", "Ticket #");
        searchResultsTable.setColumnHeader("type", "Type");
        searchResultsTable.setColumnHeader("priority", "Priority");
        searchResultsTable.setColumnHeader("status", "Status");
        searchResultsTable.setColumnHeader("category", "Confirmed Category");
        searchResultsTable.setColumnHeader("studyDate", "Exam Date");
        searchResultsTable.setColumnHeader("patientName", "Patient Name");
        searchResultsTable.setColumnHeader("institution", "Institution");
        searchResultsTable.setColumnHeader("accessionNumber", "Accession");
        searchResultsTable.setColumnHeader("modality", "Modality");
        searchResultsTable.setColumnHeader("studyDescription", "Exam Description");
        searchResultsTable.setCellStyleGenerator(new CustomTable.CellStyleGenerator()
        {

            @Override public String getStyle(CustomTable source, Object itemId, Object propertyId)
            {
                Item item = source.getItem(itemId);
                if (item != null)
                {
                    if (propertyId != null && propertyId.equals("priority"))
                    {
                        TicketPriority priority = (TicketPriority) item.getItemProperty("priority").getValue();
                        if (priority != null)
                        {
                            return priority.name().toLowerCase();
                        }
                    }
                }

                return null;
            }

        });
    }

    @Override public void displayTicket(ProfessionalTicket ticket,
                                        Collection<DicomStudy> relatedExams,
                                        Container institutions,
                                        Collection<Attachment> attachments)
    {
        if (listener != null)
        {
            String caption = ticket.getViewId();
            if (!isAlreadyDisplayed(tabSheet, caption))
            {
                PRTicketView
                        view =
                        new PRTicketView(user, tabSheet, institutions, listener, ticket, relatedExams, attachments);
                TabSheet.Tab tab = tabSheet.addTab(view, caption);
                tab.setClosable(true);
                tabSheet.setSelectedTab(tab);
            }
        }
    }

    public boolean isAlreadyDisplayed(TabSheet container, String caption)
    {
        int componentCount = container.getComponentCount();
        for (int i = 0; i < componentCount; i++)
        {
            TabSheet.Tab tab = container.getTab(i);
            if (tab.getCaption().equals(caption))
            {
                container.setSelectedTab(tab);

                return true;
            }
        }

        return false;
    }
}
