package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.Date;


public class HL7Message implements HL7Visitable
{
    public static final byte TYPE = 1;
     private String id;
     private String viewId;
    private Date received;
    private String type;
    private String version;
    private String rawMessage;

    public HL7Message()
    {
        // empty
    }

    @JsonCreator
    public HL7Message( String id,
                       String viewId,
                      Date received,
                      String type,
                      String version,
                      String rawMessage)
    {
        super();

        this.id = id;
        this.viewId = viewId;
        this.received = received;
        this.type = type;
        this.version = version;
        this.rawMessage = rawMessage;
    }

    
    public String getId()
    {
        return id;
    }

    
    public String getViewId()
    {
        return viewId;
    }


    public Date getReceived()
    {
        return received;
    }


    public String getType()
    {
        return type;
    }


    public String getVersion()
    {
        return version;
    }


    public String getRawMessage()
    {
        return rawMessage;
    }
    public void setId( String id)
    {
        this.id = id;
    }

    public void setViewId( String viewId)
    {
        this.viewId = viewId;
    }

    public void setReceived(Date received)
    {
        this.received = received;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setVersion(String version)
    {
        this.version = version;
    }

    public void setRawMessage(String rawMessage)
    {
        this.rawMessage = rawMessage;
    }

    public void accept(HL7Visitor aVisitor)
    {
        aVisitor.visit(this);
    }


    public String toString()
    {
        return "HL7Message(" +
            " id: " + getId() +
            " viewId: " + getViewId() +
            " received: " + getReceived() +
            " type: " + getType() +
            " version: " + getVersion() +
            " rawMessage: " + getRawMessage() + ")";
    }


    @Override
    public boolean equals( Object aObject)
    {
          if (this == aObject)
          {
              return true;
          }

          if (aObject == null || getClass() != aObject.getClass())
          {
              return false;
          }

          final HL7Message myObject = (HL7Message) aObject;

          return Objects.equals(getId(), myObject.getId()) && 
                 Objects.equals(getViewId(), myObject.getViewId()) && 
                 Objects.equals(getReceived(), myObject.getReceived()) && 
                 Objects.equals(getType(), myObject.getType()) && 
                 Objects.equals(getVersion(), myObject.getVersion()) && 
                 Objects.equals(getRawMessage(), myObject.getRawMessage());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(
                            getId(),
                            getViewId(),
                            getReceived(),
                            getType(),
                            getVersion(),
                            getRawMessage());
    }


    public HL7MessageBuilder toBuilder()
    {
        return new HL7MessageBuilder(getReceived(),
                                     getType(),
                                     getVersion(),
                                     getRawMessage()).setId(getId())
                                                      .setViewId(getViewId())



    ;
    }
}