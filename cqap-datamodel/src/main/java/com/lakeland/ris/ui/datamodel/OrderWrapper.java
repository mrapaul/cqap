package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;
import com.peirs.datamodel.dicom.*;
import java.util.*;

public class OrderWrapper
{
    private DetailedOrder order;
    private Collection<OrderNote> notes;
    private Collection<OrderTag> tags;
    private Collection<OrderAuditEntry> auditEntries;
    private Collection<Attachment> attachments;
    private Collection<DicomStudy> relatedOrders;
    private Collection<OrderChange> changes;
    private Collection<DetailedOrder> priors;

    public OrderWrapper()
    {
        // empty
    }

    @JsonCreator
    public OrderWrapper(DetailedOrder order,
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

    
    public DetailedOrder getOrder()
    {
        return order;
    }

    
    public Collection<OrderNote> getNotes()
    {
        return notes;
    }

    
    public Collection<OrderTag> getTags()
    {
        return tags;
    }

    
    public Collection<OrderAuditEntry> getAuditEntries()
    {
        return auditEntries;
    }

    
    public Collection<Attachment> getAttachments()
    {
        return attachments;
    }

    
    public Collection<DicomStudy> getRelatedOrders()
    {
        return relatedOrders;
    }

    
    public Collection<OrderChange> getChanges()
    {
        return changes;
    }

    
    public Collection<DetailedOrder> getPriors()
    {
        return priors;
    }
    public void setOrder(DetailedOrder order)
    {
        this.order = order;
    }

    public void setNotes(Collection<OrderNote> notes)
    {
        this.notes = notes;
    }

    public void setTags(Collection<OrderTag> tags)
    {
        this.tags = tags;
    }

    public void setAuditEntries(Collection<OrderAuditEntry> auditEntries)
    {
        this.auditEntries = auditEntries;
    }

    public void setAttachments(Collection<Attachment> attachments)
    {
        this.attachments = attachments;
    }

    public void setRelatedOrders(Collection<DicomStudy> relatedOrders)
    {
        this.relatedOrders = relatedOrders;
    }

    public void setChanges(Collection<OrderChange> changes)
    {
        this.changes = changes;
    }

    public void setPriors(Collection<DetailedOrder> priors)
    {
        this.priors = priors;
    }

    
    public String toString()
    {
        return "OrderWrapper(" +
            " order: " + getOrder() +
            " notes: " + getNotes() +
            " tags: " + getTags() +
            " auditEntries: " + getAuditEntries() +
            " attachments: " + getAttachments() +
            " relatedOrders: " + getRelatedOrders() +
            " changes: " + getChanges() +
            " priors: " + getPriors() + ")";
    }

    
    public OrderWrapperBuilder toBuilder()
    {
        return new OrderWrapperBuilder(getOrder(),
                                       getNotes(),
                                       getTags(),
                                       getAuditEntries(),
                                       getAttachments(),
                                       getRelatedOrders(),
                                       getChanges(),
                                       getPriors());
    }
}