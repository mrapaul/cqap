package web;

import com.vaadin.ui.*;

public class HL7MessagesView
{
    private final Table messagesTable;
    private final TextArea messageContent;

    public HL7MessagesView()
    {
        messagesTable = new Table();
        messageContent = new TextArea();
    }
}
