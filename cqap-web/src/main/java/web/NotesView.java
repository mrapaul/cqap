package web;


import com.peirs.datamodel.ticket.*;
import com.vaadin.shared.ui.label.*;
import com.vaadin.ui.*;
import org.jetbrains.annotations.*;

import java.util.*;

import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.sort;
import static web.ComponentFactory.*;

public final class NotesView extends Panel
{
    @NotNull private final NotesListener listener;
    @NotNull private final TextField note;
    @NotNull private final Button addButton;
    @NotNull private final Panel notesList;
    @NotNull private final VerticalLayout notesContent;

    public NotesView(@NotNull NotesListener listener)
    {
        this.listener = listener;
        note = createFormTextField("Enter Note");
        addButton = createFormButton("Add Note");
        notesList = new Panel();
        notesContent = new VerticalLayout();
        notesContent.setMargin(true);
        notesContent.setSpacing(true);
        notesList.setContent(notesContent);
        notesList.setImmediate(true);
        notesContent.setImmediate(true);

        initLayout();
        initButtonActions();
    }

    private void initLayout()
    {
        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        setSizeFull();
        layout.setMargin(true);
        layout.setSpacing(true);
        note.setWidth("100%");
        HorizontalLayout horizontal = fullWidthHorizontalLayout(note, addButton);
        horizontal.setMargin(true);
        horizontal.setSpacing(true);
        horizontal.setComponentAlignment(note, Alignment.MIDDLE_LEFT);
        horizontal.setComponentAlignment(addButton, Alignment.MIDDLE_RIGHT);
        layout.addComponent(horizontal);
        layout.addComponent(notesList);
        notesList.setSizeFull();
        layout.setExpandRatio(notesList, 1);
        setContent(layout);
    }

    private void initButtonActions()
    {
        addButton.addClickListener(new Button.ClickListener()
        {
            @Override public void buttonClick(Button.ClickEvent event)
            {
                String noteValue = note.getValue().trim();
                if (!noteValue.isEmpty())
                {
                    listener.addNote(noteValue);
                }
                note.setValue("");
            }
        });
    }

    public void displayNotes(@NotNull List<InternalNote> notes)
    {
        Collections.sort(notes, new Comparator<InternalNote>()
        {
            @Override public int compare(InternalNote o1, InternalNote o2)
            {
                return o2.getDate().compareTo(o1.getDate());
            }
        });
        notesContent.removeAllComponents();
        for (InternalNote note : notes)
        {
            String
                    cause =
                    "<b>" +
                            note.getUser().getName() +
                            " </b><b> on " +
                            note.getDate() +
                            "</b><b>:</b><br/>" +
                            note.getNote() +
                            "<br/>";
            notesContent.addComponent(new Label(cause, ContentMode.HTML));
        }
    }
}
