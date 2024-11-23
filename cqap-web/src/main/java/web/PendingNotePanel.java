package web;

import com.vaadin.ui.*;


import static web.ComponentFactory.*;

class PendingNotePanel extends Window
{
    private final PRTicketView ticketListener;
    private final TextField noteField;
    private final Button okButton;
    private final Button cancelButton;

    PendingNotePanel(PRTicketView ticketListener)
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