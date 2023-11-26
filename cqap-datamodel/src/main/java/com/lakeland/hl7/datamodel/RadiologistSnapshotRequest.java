package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class RadiologistSnapshotRequest extends TimedMessage implements HL7Visitable
{
    public static final byte TYPE = 13;
    @NotNull private String userId;

    public RadiologistSnapshotRequest()
    {
        // empty
    }

    @JsonCreator
    public RadiologistSnapshotRequest(@NotNull Date timestamp,
                                      @NotNull String userId)
    {
        super(timestamp);

        this.userId = userId;
    }

    @NotNull
    public String getUserId()
    {
        return userId;
    }
    public void setUserId(@NotNull String userId)
    {
        this.userId = userId;
    }

    public void accept(@NotNull HL7Visitor aVisitor)
    {
        aVisitor.visit(this);
    }

    @NotNull
    public String toString()
    {
        return "RadiologistSnapshotRequest(" +
            super.toString() +
            " userId: " + getUserId() + ")";
    }

    @NotNull
    public RadiologistSnapshotRequestBuilder toBuilder()
    {
        return new RadiologistSnapshotRequestBuilder(getTimestamp(),
                                                     getUserId());
    }
}