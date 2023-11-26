package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import com.peirs.datamodel.dicom.*;
import java.util.*;

public class OrderWrapper
{
    @NotNull private DetailedOrder order;
    @NotNull private Collection<OrderNote> notes;
    @NotNull private Collection<OrderTag> tags;
    @NotNull private Collection<OrderAuditEntry> auditEntries;
    @NotNull private Collection<Attachment> attachments;
    @NotNull private Collection<DicomStudy> relatedOrders;
    @NotNull private Collection<OrderChange> changes;
    @NotNull private Collection<DetailedOrder> priors;

    public OrderWrapper()
    {
        // empty
    }

    @JsonCreator
    public OrderWrapper(@NotNull DetailedOrder order,
                        @NotNull Collection<OrderNote> notes,
                        @NotNull Collection<OrderTag> tags,
                        @NotNull Collection<OrderAuditEntry> auditEntries,
                        @NotNull Collection<Attachment> attachments,
                        @NotNull Collection<DicomStudy> relatedOrders,
                        @NotNull Collection<OrderChange> changes,
                        @NotNull Collection<DetailedOrder> priors)
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

    @NotNull
    public DetailedOrder getOrder()
    {
        return order;
    }

    @NotNull
    public Collection<OrderNote> getNotes()
    {
        return notes;
    }

    @NotNull
    public Collection<OrderTag> getTags()
    {
        return tags;
    }

    @NotNull
    public Collection<OrderAuditEntry> getAuditEntries()
    {
        return auditEntries;
    }

    @NotNull
    public Collection<Attachment> getAttachments()
    {
        return attachments;
    }

    @NotNull
    public Collection<DicomStudy> getRelatedOrders()
    {
        return relatedOrders;
    }

    @NotNull
    public Collection<OrderChange> getChanges()
    {
        return changes;
    }

    @NotNull
    public Collection<DetailedOrder> getPriors()
    {
        return priors;
    }
    public void setOrder(@NotNull DetailedOrder order)
    {
        this.order = order;
    }

    public void setNotes(@NotNull Collection<OrderNote> notes)
    {
        this.notes = notes;
    }

    public void setTags(@NotNull Collection<OrderTag> tags)
    {
        this.tags = tags;
    }

    public void setAuditEntries(@NotNull Collection<OrderAuditEntry> auditEntries)
    {
        this.auditEntries = auditEntries;
    }

    public void setAttachments(@NotNull Collection<Attachment> attachments)
    {
        this.attachments = attachments;
    }

    public void setRelatedOrders(@NotNull Collection<DicomStudy> relatedOrders)
    {
        this.relatedOrders = relatedOrders;
    }

    public void setChanges(@NotNull Collection<OrderChange> changes)
    {
        this.changes = changes;
    }

    public void setPriors(@NotNull Collection<DetailedOrder> priors)
    {
        this.priors = priors;
    }

    @NotNull
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

    @NotNull
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