package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrderAuditEntries
{
    private Collection<OrderAuditEntry> entries;

    public OrderAuditEntries()
    {
        // empty
    }

    @JsonCreator
    public OrderAuditEntries(Collection<OrderAuditEntry> entries)
    {
        super();

        this.entries = entries;
    }


    public Collection<OrderAuditEntry> getEntries()
    {
        return entries;
    }
    public void setEntries(Collection<OrderAuditEntry> entries)
    {
        this.entries = entries;
    }


    public String toString()
    {
        return "OrderAuditEntries(" +
            " entries: " + getEntries() + ")";
    }


    public OrderAuditEntriesBuilder toBuilder()
    {
        return new OrderAuditEntriesBuilder(getEntries());
    }
}