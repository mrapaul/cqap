package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;


public class RadiologistSnapshotRequest extends TimedMessage implements HL7Visitable
{
    public static final byte TYPE = 13;
    private String userId;

    public RadiologistSnapshotRequest()
    {
        // empty
    }

    @JsonCreator
    public RadiologistSnapshotRequest(Date timestamp,
                                      String userId)
    {
        super(timestamp);

        this.userId = userId;
    }


    public String getUserId()
    {
        return userId;
    }
    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public void accept(HL7Visitor aVisitor)
    {
        aVisitor.visit(this);
    }


    public String toString()
    {
        return "RadiologistSnapshotRequest(" +
            super.toString() +
            " userId: " + getUserId() + ")";
    }


    public RadiologistSnapshotRequestBuilder toBuilder()
    {
        return new RadiologistSnapshotRequestBuilder(getTimestamp(),
                                                     getUserId());
    }
}