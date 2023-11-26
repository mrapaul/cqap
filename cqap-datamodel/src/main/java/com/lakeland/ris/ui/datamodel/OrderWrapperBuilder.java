package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import com.peirs.datamodel.dicom.*;
import java.util.*;

public class OrderWrapperBuilder
{
    @NotNull private DetailedOrder order;
    @NotNull private Collection<OrderNote> notes;
    @NotNull private Collection<OrderTag> tags;
    @NotNull private Collection<OrderAuditEntry> auditEntries;
    @NotNull private Collection<Attachment> attachments;
    @NotNull private Collection<DicomStudy> relatedOrders;
    @NotNull private Collection<OrderChange> changes;
    @NotNull private Collection<DetailedOrder> priors;

    public OrderWrapperBuilder(@NotNull DetailedOrder order,
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
    public OrderWrapperBuilder setOrder(@NotNull DetailedOrder order)
    {
        this.order = order;

        return self();
    }

    @NotNull
    public OrderWrapperBuilder setNotes(@NotNull Collection<OrderNote> notes)
    {
        this.notes = notes;

        return self();
    }

    @NotNull
    public OrderWrapperBuilder setTags(@NotNull Collection<OrderTag> tags)
    {
        this.tags = tags;

        return self();
    }

    @NotNull
    public OrderWrapperBuilder setAuditEntries(@NotNull Collection<OrderAuditEntry> auditEntries)
    {
        this.auditEntries = auditEntries;

        return self();
    }

    @NotNull
    public OrderWrapperBuilder setAttachments(@NotNull Collection<Attachment> attachments)
    {
        this.attachments = attachments;

        return self();
    }

    @NotNull
    public OrderWrapperBuilder setRelatedOrders(@NotNull Collection<DicomStudy> relatedOrders)
    {
        this.relatedOrders = relatedOrders;

        return self();
    }

    @NotNull
    public OrderWrapperBuilder setChanges(@NotNull Collection<OrderChange> changes)
    {
        this.changes = changes;

        return self();
    }

    @NotNull
    public OrderWrapperBuilder setPriors(@NotNull Collection<DetailedOrder> priors)
    {
        this.priors = priors;

        return self();
    }

    @NotNull
    protected DetailedOrder getOrder()
    {
        return order;
    }

    @NotNull
    protected Collection<OrderNote> getNotes()
    {
        return notes;
    }

    @NotNull
    protected Collection<OrderTag> getTags()
    {
        return tags;
    }

    @NotNull
    protected Collection<OrderAuditEntry> getAuditEntries()
    {
        return auditEntries;
    }

    @NotNull
    protected Collection<Attachment> getAttachments()
    {
        return attachments;
    }

    @NotNull
    protected Collection<DicomStudy> getRelatedOrders()
    {
        return relatedOrders;
    }

    @NotNull
    protected Collection<OrderChange> getChanges()
    {
        return changes;
    }

    @NotNull
    protected Collection<DetailedOrder> getPriors()
    {
        return priors;
    }

    @NotNull
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


    @NotNull
    protected OrderWrapperBuilder self()
    {
        return this;
    }
}