package com.capstone.fx.utils;

import javafx.scene.control.*;

public final class FieldValidation
{
    private static final String ERROR_CSS_STYLE = "error";

    private FieldValidation()
    {
        // empty
    }

    public static boolean checkTextField(TextField aTextField)
    {
        boolean myValid = false;
        if (aTextField.getText() == null || aTextField.getText().trim().isEmpty())
        {
            aTextField.getStyleClass().add(ERROR_CSS_STYLE);
        }
        else
        {
            aTextField.getStyleClass().remove(ERROR_CSS_STYLE);
            myValid = true;
        }

        return myValid;
    }

    public static boolean checkTextArea(TextArea aTextField)
    {
        boolean myValid = false;
        if (aTextField.getText() == null || aTextField.getText().trim().isEmpty())
        {
            aTextField.getStyleClass().add(ERROR_CSS_STYLE);
        }
        else
        {
            aTextField.getStyleClass().remove(ERROR_CSS_STYLE);
            myValid = true;
        }

        return myValid;
    }

    public static <T> boolean checkComboBox(ComboBox<T> aComboBox)
    {
        boolean myValid = false;
        if (aComboBox.getSelectionModel().getSelectedItem() == null)
        {
            aComboBox.getStyleClass().add(ERROR_CSS_STYLE);
        }
        else
        {
            aComboBox.getStyleClass().remove(ERROR_CSS_STYLE);
            myValid = true;
        }

        return myValid;
    }
}
