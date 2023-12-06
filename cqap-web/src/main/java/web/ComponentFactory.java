package web;


import com.vaadin.ui.*;
import org.vaadin.maddon.layouts.*;

import java.util.*;

public class ComponentFactory
{
    public static FormLayout createColumn(Component... components)
    {
        FormLayout layout = new FormLayout(components);
        layout.setMargin(true);

        return layout;
    }

    public static HorizontalLayout createRow(Component... components)
    {
        return new MHorizontalLayout(components).withSpacing(true);
    }

    public static TextField createFormTextField(String caption)
    {
        TextField textField = new TextField(caption);
        textField.setWidth("100%");
        textField.addStyleName("formtextfield");
        return textField;
    }

    public static ComboBox createFormComboBoxField(String caption)
    {
        ComboBox field = new ComboBox(caption);
        field.setWidth("100%");
        field.addStyleName("formtextfield");
        return field;
    }

    public static ComboBox createFormComboBoxField(String caption, Collection<?> items)
    {
        ComboBox field = new ComboBox(caption, items);
        field.setWidth("100%");
        field.addStyleName("formtextfield");
        return field;
    }

    public static Label createFormLabel(String caption)
    {
        Label label = new Label(caption);
        label.addStyleName("formtextfield");

        return label;
    }

    public static DateField createFormDateField(String caption)
    {
        DateField field = new DateField(caption);
        field.setWidth("100%");
        field.addStyleName("formtextfield");

        return field;
    }

    public static CheckBox createFormCheckBox(String caption)
    {
        CheckBox field = new CheckBox(caption);
        field.addStyleName("formtextfield");

        return field;
    }

    public static Button createFormButton(String caption)
    {
        Button button = new Button(caption);
        button.addStyleName("form");

        return button;
    }

    public static VerticalLayout fullWidthVerticalLayout(Component... components)
    {
        VerticalLayout layout = new VerticalLayout(components);
        layout.setWidth("100%");

        return layout;
    }

    public static HorizontalLayout fullWidthHorizontalLayout(Component... components)
    {
        HorizontalLayout layout = new HorizontalLayout(components);
        layout.setWidth("100%");

        return layout;
    }

    public static TextArea createFormTextArea(String caption)
    {
        TextArea textArea = new TextArea(caption);
        textArea.setWordwrap(true);
        textArea.addStyleName("formtextfield");
        textArea.setWidth("100%");

        return textArea;
    }

    public static Table createFormTable()
    {
        Table table = new Table();
        table.addStyleName("formtextfield");

        return table;
    }
}

