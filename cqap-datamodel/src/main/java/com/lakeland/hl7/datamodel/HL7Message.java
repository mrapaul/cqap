package com.lakeland.hl7.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.Date;


public class HL7Message implements HL7Visitable
{
    public static final byte TYPE = 1;
    @Nullable private String id;
    @Nullable private String viewId;
    @NotNull private Date received;
    @NotNull private String type;
    @NotNull private String version;
    @NotNull private String rawMessage;

    public HL7Message()
    {
        // empty
    }

    @JsonCreator
    public HL7Message(@Nullable String id,
                      @Nullable String viewId,
                      @NotNull Date received,
                      @NotNull String type,
                      @NotNull String version,
                      @NotNull String rawMessage)
    {
        super();

        this.id = id;
        this.viewId = viewId;
        this.received = received;
        this.type = type;
        this.version = version;
        this.rawMessage = rawMessage;
    }

    @Nullable
    public String getId()
    {
        return id;
    }

    @Nullable
    public String getViewId()
    {
        return viewId;
    }

    @NotNull
    public Date getReceived()
    {
        return received;
    }

    @NotNull
    public String getType()
    {
        return type;
    }

    @NotNull
    public String getVersion()
    {
        return version;
    }

    @NotNull
    public String getRawMessage()
    {
        return rawMessage;
    }
    public void setId(@Nullable String id)
    {
        this.id = id;
    }

    public void setViewId(@Nullable String viewId)
    {
        this.viewId = viewId;
    }

    public void setReceived(@NotNull Date received)
    {
        this.received = received;
    }

    public void setType(@NotNull String type)
    {
        this.type = type;
    }

    public void setVersion(@NotNull String version)
    {
        this.version = version;
    }

    public void setRawMessage(@NotNull String rawMessage)
    {
        this.rawMessage = rawMessage;
    }

    public void accept(@NotNull HL7Visitor aVisitor)
    {
        aVisitor.visit(this);
    }

    @NotNull
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
    public boolean equals(@Nullable Object aObject)
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

    @NotNull
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