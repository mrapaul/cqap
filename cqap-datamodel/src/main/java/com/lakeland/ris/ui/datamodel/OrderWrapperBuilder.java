package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;
import com.peirs.datamodel.dicom.*;
import java.util.*;

public class OrderWrapperBuilder
{
    private DetailedOrder order;
    private Collection<OrderNote> notes;
    private Collection<OrderTag> tags;
    private Collection<OrderAuditEntry> auditEntries;
    private Collection<Attachment> attachments;
    private Collection<DicomStudy> relatedOrders;
    private Collection<OrderChange> changes;
    private Collection<DetailedOrder> priors;

    public OrderWrapperBuilder(DetailedOrder order,
                               Collection<OrderNote> notes,
                               Collection<OrderTag> tags,
                               Collection<OrderAuditEntry> auditEntries,
                               Collection<Attachment> attachments,
                               Collection<DicomStudy> relatedOrders,
                               Collection<OrderChange> changes,
                               Collection<DetailedOrder> priors)
    {
        super();

        this.order = order;
        this.notes = notes;
        this.tags = tags;
        this.auditEntries = auditEntries;
        this.attachments = attachments;
        this.relatedOrders = relatedOrders;
        this.changes = changes;
        this.priors = priors;
    }


    
    public OrderWrapperBuilder setOrder(DetailedOrder order)
    {
        this.order = order;

        return self();
    }

    
    public OrderWrapperBuilder setNotes(Collection<OrderNote> notes)
    {
        this.notes = notes;

        return self();
    }

    
    public OrderWrapperBuilder setTags(Collection<OrderTag> tags)
    {
        this.tags = tags;

        return self();
    }

    
    public OrderWrapperBuilder setAuditEntries(Collection<OrderAuditEntry> auditEntries)
    {
        this.auditEntries = auditEntries;

        return self();
    }

    
    public OrderWrapperBuilder setAttachments(Collection<Attachment> attachments)
    {
        this.attachments = attachments;

        return self();
    }

    
    public OrderWrapperBuilder setRelatedOrders(Collection<DicomStudy> relatedOrders)
    {
        this.relatedOrders = relatedOrders;

        return self();
    }

    
    public OrderWrapperBuilder setChanges(Collection<OrderChange> changes)
    {
        this.changes = changes;

        return self();
    }

    
    public OrderWrapperBuilder setPriors(Collection<DetailedOrder> priors)
    {
        this.priors = priors;

        return self();
    }

    
    protected DetailedOrder getOrder()
    {
        return order;
    }

    
    protected Collection<OrderNote> getNotes()
    {
        return notes;
    }

    
    protected Collection<OrderTag> getTags()
    {
        return tags;
    }

    
    protected Collection<OrderAuditEntry> getAuditEntries()
    {
        return auditEntries;
    }

    
    protected Collection<Attachment> getAttachments()
    {
        return attachments;
    }

    
    protected Collection<DicomStudy> getRelatedOrders()
    {
        return relatedOrders;
    }

    
    protected Collection<OrderChange> getChanges()
    {
        return changes;
    }

    
    protected Collection<DetailedOrder> getPriors()
    {
        return priors;
    }

    
    public OrderWrapper build()
    {
        return new OrderWrapper(getOrder(),
                                getNotes(),
                                getTags(),
                                getAuditEntries(),
                                getAttachments(),
                                getRelatedOrders(),
                                getChanges(),
                                getPriors());
    }


    
    protected OrderWrapperBuilder self()
    {
        return this;
    }
}