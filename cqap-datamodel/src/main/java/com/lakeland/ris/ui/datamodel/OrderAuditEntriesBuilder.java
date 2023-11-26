package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrderAuditEntriesBuilder
{
    @NotNull private Collection<OrderAuditEntry> entries;

    public OrderAuditEntriesBuilder(@NotNull Collection<OrderAuditEntry> entries)
    {
        super();

        this.entries = entries;
    }


    @NotNull
    public OrderAuditEntriesBuilder setEntries(@NotNull Collection<OrderAuditEntry> entries)
    {
        this.entries = entries;

        return self();
    }

    @NotNull
    protected Collection<OrderAuditEntry> getEntries()
    {
        return entries;
    }

    @NotNull
    public OrderAuditEntries build()
    {
        return new OrderAuditEntries(getEntries());
    }


    @NotNull
    protected OrderAuditEntriesBuilder self()
    {
        return this;
    }
}