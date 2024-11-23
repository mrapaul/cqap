package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;


public class AdministrationSnapshotRequest extends TimedMessage implements HL7Visitable
{
    public static final byte TYPE = 11;
    private String userId;

    public AdministrationSnapshotRequest()
    {
        // empty
    }

    @JsonCreator
    public AdministrationSnapshotRequest(Date timestamp,
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
        return "AdministrationSnapshotRequest(" +
            super.toString() +
            " userId: " + getUserId() + ")";
    }

    
    public AdministrationSnapshotRequestBuilder toBuilder()
    {
        return new AdministrationSnapshotRequestBuilder(getTimestamp(),
                                                        getUserId());
    }
}