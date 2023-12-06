package web;

import com.peirs.datamodel.*;
import com.vaadin.data.*;
import com.vaadin.navigator.*;
import org.jetbrains.annotations.*;

public interface UserView extends View
{
    void editNewUser(@NotNull String newItemId);

    void setListener(@NotNull UserViewListener listener);

    void setContainers(@NotNull Container userContainer,
                       @NotNull Container institutionContainer,
                       @NotNull Container primaryCPTCodesContainer,
                       @NotNull Container secondaryCPTCodesContainer,
                       @NotNull Container countriesContainer,
                       @NotNull Container timezonesContainer);

    interface UserViewListener
    {
        void viewEntered();

        void createOrUpdate(@NotNull User user);

        void delete(@NotNull User user);

        void addUser();

        void countrySelected(@NotNull Country country);
    }
}
