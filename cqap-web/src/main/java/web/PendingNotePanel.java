package web;

import com.vaadin.ui.*;
import org.jetbrains.annotations.*;

import static web.ComponentFactory.*;

class PendingNotePanel extends Window
{
    @NotNull private final PRTicketView ticketListener;
    @NotNull private final TextField noteField;
    @NotNull private final Button okButton;
    @NotNull private final Button cancelButton;

    PendingNotePanel(@NotNull PRTicketView ticketListener)
    {
        this.ticketListener = ticketListener;
        noteField = createFormTextField("");
        okButton = createFormButton("Ok");
        cancelButton = createFormButton("Cancel");

        initLayout();
        initListeners();
    }

    private void initLayout()
    {
        setCaption("Enter pending note");
        setSizeUndefined();
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.addStyleName("sidebar");
        verticalLayout.setMargin(true);
        verticalLayout.setSpacing(true);
        HorizontalLayout buttons = new HorizontalLayout(cancelButton, okButton);
        buttons.setMargin(true);
        buttons.setSpacing(true);
        verticalLayout.addComponent(noteField);
        verticalLayout.addComponent(buttons);
        setContent(verticalLayout);
        setModal(true);
    }

    private void initListeners()
    {
        cancelButton.addClickListener(new Button.ClickListener()
        {
            @Override public void buttonClick(Button.ClickEvent event)
            {
                close();
            }
        });
        okButton.addClickListener(new Button.ClickListener()
        {
            @Override public void buttonClick(Button.ClickEvent event)
            {

                String note = noteField.getValue();
                if (!note.isEmpty())
                {
                    ticketListener.addNote("Pending reason : " + note);
                    ticketListener.pendingNoteEntered();
                    close();
                }
                else
                {
                    Notification.show("Please enter a note");
                }
            }
        });
    }
}