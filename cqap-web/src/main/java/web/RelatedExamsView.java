package web;

import com.peirs.datamodel.dicom.*;
import com.vaadin.data.util.*;
import com.vaadin.shared.ui.label.*;
import com.vaadin.ui.*;
import org.jetbrains.annotations.*;

import java.text.*;
import java.util.*;

public final class RelatedExamsView extends Panel
{
    @NotNull private final BeanContainer<String, DicomStudy> orderContainer;
    @NotNull private final Table table;
    @NotNull private final DateFormat studyDateFormat;
    @NotNull private final DateFormat studyDateDisplayFormat;
//    @Nullable private DetailedOrderView.DetailedOrderListener listener;

    public RelatedExamsView()
    {
        orderContainer = new BeanContainer<>(DicomStudy.class);
        studyDateFormat = new SimpleDateFormat("yyyyMMdd");
        studyDateDisplayFormat = new SimpleDateFormat("MMM dd yyyy");
        orderContainer.setBeanIdResolver(new AbstractBeanContainer.BeanIdResolver<String, DicomStudy>()
        {
            @Override public String getIdForBean(DicomStudy bean)
            {
                return bean.getId();
            }
        });
        this.table = new Table();

        initLayout();
    }

    private void initLayout()
    {
        setSizeFull();
        table.setSizeFull();
        table.addStyleName("plain");
        table.setImmediate(true);
        VerticalLayout layout = new VerticalLayout(table);
        layout.setSizeFull();
        layout.setExpandRatio(table, 1);
        setContent(layout);
    }

    public void display(@NotNull Collection<DicomStudy> relatedOrders)
    {
        orderContainer.removeAllContainerFilters();
        orderContainer.removeAllItems();
        orderContainer.addAll(relatedOrders);
        orderContainer.sort(new Object[]{"studyDate"}, new boolean[]{false});
        table.removeGeneratedColumn("Images");
        table.setContainerDataSource(orderContainer);
        table.addGeneratedColumn("Images", new Table.ColumnGenerator()
        {
            @Override public Object generateCell(Table source, Object itemId, Object columnId)
            {
                DicomStudy study = ((BeanContainer<String, DicomStudy>) source
                        .getContainerDataSource())
                        .getItem(itemId)
                        .getBean();

                Label label = new Label("Date : " + getStudyDate(study) +
                        "\n" +
                        "Accession: " + study.getAccessionNumber() +
                        "\n" +
                        study.getStudyDescription(), ContentMode.PREFORMATTED);
                label.setId(study.getStudyId());
                label.addStyleName("related-study-label");

                return label;
            }
        });
        table.setVisibleColumns("Images");
        table.setColumnHeaderMode(Table.ColumnHeaderMode.HIDDEN);
    }

    private String getStudyDate(DicomStudy study)
    {
        String studyDateStr = study.getStudyDate();
        String date = studyDateStr;
        if (studyDateStr != null && !studyDateStr.isEmpty() && studyDateStr.length() == 8)
        {
            try
            {
                Date studyDate = studyDateFormat.parse(studyDateStr);
                date = studyDateDisplayFormat.format(studyDate);
            }
            catch (ParseException e)
            {
                // no catch
            }
        }
        return date;
    }

    @Nullable
//    public DetailedOrderView.DetailedOrderListener getListener()
//    {
//        return listener;
//    }
//
//    public void setListener(@NotNull DetailedOrderView.DetailedOrderListener listener)
//    {
//        this.listener = listener;
//    }

    public void dispose()
    {
        orderContainer.removeAllItems();
        table.removeAllItems();
    }
}
