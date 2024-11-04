package com.capstone.fx.components;

import com.peirs.datamodel.attachments.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.util.*;

public class AttachmentsCellFactory implements Callback<ListView<Attachment>, ListCell<Attachment>>
{
    private final ListView<Attachment> theListView;

    public AttachmentsCellFactory(ListView<Attachment> aListView)
    {
        theListView = aListView;
    }

    @Override public ListCell<Attachment> call(ListView<Attachment> aInternalNoteListView)
    {
        return new ListCell<Attachment>()
        {
            @Override
            public void updateItem(Attachment aItem, boolean aEmpty)
            {
                super.updateItem(aItem, aEmpty);
                if (!isEmpty())
                {
                    Text myText = new Text(aItem.getUploadDate() + " : " + aItem.getFilename());
                    myText.setWrappingWidth(theListView.getWidth());
                    setGraphic(myText);
                }
            }
        };
    }
}
