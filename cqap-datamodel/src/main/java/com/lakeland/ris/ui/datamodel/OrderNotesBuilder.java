package com.lakeland.ris.ui.datamodel;


import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrderNotesBuilder
{
    private Collection<OrderNote> notes;

    public OrderNotesBuilder(Collection<OrderNote> notes)
    {
        super();

        this.notes = notes;
    }



    public OrderNotesBuilder setNotes(Collection<OrderNote> notes)
    {
        this.notes = notes;

        return self();
    }


    protected Collection<OrderNote> getNotes()
    {
        return notes;
    }


    public OrderNotes build()
    {
        return new OrderNotes(getNotes());
    }



    protected OrderNotesBuilder self()
    {
        return this;
    }
}