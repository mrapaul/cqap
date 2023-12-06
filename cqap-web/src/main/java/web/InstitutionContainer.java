package web;

import com.peirs.datamodel.*;
import com.vaadin.data.util.*;

public class InstitutionContainer extends BeanContainer<String, Institution>
{
    public InstitutionContainer() throws IllegalArgumentException
    {
        super(Institution.class);

        setBeanIdResolver(new BeanIdResolver<String, Institution>()
        {
            @Override public String getIdForBean(Institution bean)
            {
                return bean.getId();
            }
        });
    }

    @Override public BeanItem<Institution> addItemAt(int index)
    {
        Institution institution = createEmptyInstitution();
        return super.addItemAt(index,
                institution.getId(),
                institution);
    }

    private Institution createEmptyInstitution()
    {
        Institution institution = new Institution();
        institution.setId("unassigned");
        institution.setAlias("newinstitution");
        institution.setName("newinstitution");
        institution.setOutgoingReportConfiguration(new HL7OutgoingConfiguration("localhost", 12345));

        return institution;
    }
}
