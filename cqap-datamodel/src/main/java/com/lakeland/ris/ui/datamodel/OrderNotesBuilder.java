package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrderNotesBuilder
{
    @NotNull private Collection<OrderNote> notes;

    public OrderNotesBuilder(@NotNull Collection<OrderNote> notes)
    {
        super();

        this.notes = notes;
    }


    @NotNull
    public OrderNotesBuilder setNotes(@NotNull Collection<OrderNote> notes)
    {
        this.notes = notes;

        return self();
    }

    @NotNull
    protected Collection<OrderNote> getNotes()
    {
        return notes;
    }

    @NotNull
    public OrderNotes build()
    {
        return new OrderNotes(getNotes());
    }


    @NotNull
    protected OrderNotesBuilder self()
    {
        return this;
    }
}