package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrderTags
{
    private Collection<OrderTag> tags;

    public OrderTags()
    {
        // empty
    }

    @JsonCreator
    public OrderTags(Collection<OrderTag> tags)
    {
        super();

        this.tags = tags;
    }

    
    public Collection<OrderTag> getTags()
    {
        return tags;
    }
    public void setTags(Collection<OrderTag> tags)
    {
        this.tags = tags;
    }

    
    public String toString()
    {
        return "OrderTags(" +
            " tags: " + getTags() + ")";
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

          final OrderTags myObject = (OrderTags) aObject;

          return Objects.equals(getTags(), myObject.getTags());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(
                            getTags());
    }

    
    public OrderTagsBuilder toBuilder()
    {
        return new OrderTagsBuilder(getTags());
    }
}