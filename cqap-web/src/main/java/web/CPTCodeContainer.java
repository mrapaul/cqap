package web;

import com.peirs.datamodel.hl7.*;
import com.vaadin.data.util.*;

public class CPTCodeContainer extends BeanContainer<String, CPTCode>
{
    public CPTCodeContainer() throws IllegalArgumentException
    {
        super(CPTCode.class);

        setBeanIdResolver(new BeanIdResolver<String, CPTCode>()
        {
            @Override public String getIdForBean(CPTCode bean)
            {
                return bean.getId();
            }
        });
    }
}
