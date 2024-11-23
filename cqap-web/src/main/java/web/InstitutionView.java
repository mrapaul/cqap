package web;

import com.peirs.datamodel.*;
import com.vaadin.data.*;
import com.vaadin.navigator.*;

import org.tepi.filtertable.*;

public interface InstitutionView extends View
{
    void editNewInstitution(String newItemId);

    void setListener(InstitutionViewListener listener);

    void setContainers(Container institutionContainer,
                       Container userContainer,
                       Container countriesContainer,
                       Container timezonesContainer);

    interface InstitutionViewListener
    {
        void viewEntered();

        void createOrUpdate(Institution institution);

        void delete(Institution institution);

        void addInstitution();

        void countrySelected(Country country);
    }
}
