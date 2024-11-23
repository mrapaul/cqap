package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrderAuditEntriesBuilder
{
    private Collection<OrderAuditEntry> entries;

    public OrderAuditEntriesBuilder(Collection<OrderAuditEntry> entries)
    {
        super();

        this.entries = entries;
    }



    public OrderAuditEntriesBuilder setEntries(Collection<OrderAuditEntry> entries)
    {
        this.entries = entries;

        return self();
    }


    protected Collection<OrderAuditEntry> getEntries()
    {
        return entries;
    }


    public OrderAuditEntries build()
    {
        return new OrderAuditEntries(getEntries());
    }



    protected OrderAuditEntriesBuilder self()
    {
        return this;
    }
}