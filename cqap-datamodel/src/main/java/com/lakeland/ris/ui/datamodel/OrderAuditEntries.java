package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrderAuditEntries
{
    @NotNull private Collection<OrderAuditEntry> entries;

    public OrderAuditEntries()
    {
        // empty
    }

    @JsonCreator
    public OrderAuditEntries(@NotNull Collection<OrderAuditEntry> entries)
    {
        super();

        this.entries = entries;
    }

    @NotNull
    public Collection<OrderAuditEntry> getEntries()
    {
        return entries;
    }
    public void setEntries(@NotNull Collection<OrderAuditEntry> entries)
    {
        this.entries = entries;
    }

    @NotNull
    public String toString()
    {
        return "OrderAuditEntries(" +
            " entries: " + getEntries() + ")";
    }

    @NotNull
    public OrderAuditEntriesBuilder toBuilder()
    {
        return new OrderAuditEntriesBuilder(getEntries());
    }
}