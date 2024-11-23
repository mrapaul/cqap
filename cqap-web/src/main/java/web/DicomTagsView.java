package web;

import com.peirs.datamodel.dicom.*;
import com.vaadin.data.util.*;
import com.vaadin.ui.*;

import org.tepi.filtertable.*;

public class DicomTagsView extends VerticalLayout
{
    private final FilterTable tagsTable;
    private final BeanContainer<String, DicomTag> tagsContainer;

    public DicomTagsView()
    {
        tagsTable = new FilterTable();
        tagsContainer = new BeanContainer<String, DicomTag>(DicomTag.class);
        tagsContainer.setBeanIdResolver(new AbstractBeanContainer.BeanIdResolver<String, DicomTag>()
        {
            @Override public String getIdForBean(DicomTag bean)
            {
                return bean.getDicomTagName();
            }
        });

        initLayout();
    }

    private void initLayout()
    {
        setSizeFull();
        addComponent(tagsTable);
        setExpandRatio(tagsTable, 1f);
    }

    public void setDetails(DicomStudy study)
    {
        tagsContainer.removeAllContainerFilters();
        tagsContainer.removeAllItems();
        tagsContainer.addAll(study.getTags());
        tagsTable.setContainerDataSource(tagsContainer);
        tagsTable.setVisibleColumns("dicomTagName", "value");
        tagsTable.setColumnHeader("dicomTagName", "Dicom Tag");
        tagsTable.setColumnHeader("value", "Value");
        tagsTable.setSortEnabled(true);
        tagsTable.setSortAscending(true);
        tagsTable.setFilterBarVisible(true);
        tagsTable.setSizeFull();
        tagsTable.addStyleName("plain");
        tagsTable.sort(new Object[]{"dicomTagName"}, new boolean[]{true});
    }
}
