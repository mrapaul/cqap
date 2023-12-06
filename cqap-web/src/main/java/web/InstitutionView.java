package web;

import com.peirs.datamodel.*;
import com.vaadin.data.*;
import com.vaadin.navigator.*;
import org.jetbrains.annotations.*;
import org.tepi.filtertable.*;

public interface InstitutionView extends View
{
    void editNewInstitution(@NotNull String newItemId);

    void setListener(@NotNull InstitutionViewListener listener);

    void setContainers(@NotNull Container institutionContainer,
                       @NotNull Container userContainer,
                       @NotNull Container countriesContainer,
                       @NotNull Container timezonesContainer);

    interface InstitutionViewListener
    {
        void viewEntered();

        void createOrUpdate(@NotNull Institution institution);

        void delete(@NotNull Institution institution);

        void addInstitution();

        void countrySelected(@NotNull Country country);
    }
}
