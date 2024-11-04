package com.capstone.fx.components;

import com.peirs.datamodel.ticket.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.util.*;

public class InternalNotesCellFactory implements Callback<ListView<InternalNote>, ListCell<InternalNote>>
{
    private final ListView<InternalNote> theListView;

    public InternalNotesCellFactory(ListView<InternalNote> aListView)
    {
        theListView = aListView;
    }

    @Override public ListCell<InternalNote> call(ListView<InternalNote> aInternalNoteListView)
    {
        return new ListCell<InternalNote>()
        {
            @Override
            public void updateItem(InternalNote aItem, boolean aEmpty)
            {
                super.updateItem(aItem, aEmpty);
                if (aItem != null && !isEmpty())
                {
                    Text myText = new Text("[" +
                            aItem.getDate() +
                            " : " +
                            (aItem.getUser() != null ? aItem.getUser().getName() : "Unknown User") +
                            "] " +
                            aItem.getNote());
                    myText.setWrappingWidth(theListView.getWidth());
                    setGraphic(myText);
                }
            }
        };
    }
}
