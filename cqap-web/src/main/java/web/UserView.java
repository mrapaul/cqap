package web;

import com.peirs.datamodel.*;
import com.vaadin.data.*;
import com.vaadin.navigator.*;


public interface UserView extends View
{
    void editNewUser(String newItemId);

    void setListener(UserViewListener listener);

    void setContainers(Container userContainer,
                       Container institutionContainer,
                       Container primaryCPTCodesContainer,
                       Container secondaryCPTCodesContainer,
                       Container countriesContainer,
                       Container timezonesContainer);

    interface UserViewListener
    {
        void viewEntered();

        void createOrUpdate(User user);

        void delete(User user);

        void addUser();

        void countrySelected(Country country);
    }
}
