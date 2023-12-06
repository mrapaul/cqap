package web;

import com.peirs.datamodel.*;
import com.vaadin.data.util.*;

public class PACSContainer extends BeanContainer<String, PACS>
{
    public PACSContainer() throws IllegalArgumentException
    {
        super(PACS.class);

        setBeanIdResolver(new BeanIdResolver<String, PACS>()
        {
            @Override public String getIdForBean(PACS bean)
            {
                return bean.getId();
            }
        });
    }

    @Override public BeanItem<PACS> addItemAt(int index)
    {
        PACS pacs = createEmptyPACS();
        return super.addItemAt(index,
                pacs.getId(),
                pacs);
    }

    private PACS createEmptyPACS()
    {
        PACS pacs = new PACS();
        pacs.setId("unassigned");

        return pacs;
    }
}

