package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class AdministrationSnapshotRequest extends TimedMessage implements HL7Visitable
{
    public static final byte TYPE = 11;
    @NotNull private String userId;

    public AdministrationSnapshotRequest()
    {
        // empty
    }

    @JsonCreator
    public AdministrationSnapshotRequest(@NotNull Date timestamp,
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
        return "AdministrationSnapshotRequest(" +
            super.toString() +
            " userId: " + getUserId() + ")";
    }

    @NotNull
    public AdministrationSnapshotRequestBuilder toBuilder()
    {
        return new AdministrationSnapshotRequestBuilder(getTimestamp(),
                                                        getUserId());
    }
}