package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrderNotes
{
    @NotNull private Collection<OrderNote> notes;

    public OrderNotes()
    {
        // empty
    }

    @JsonCreator
    public OrderNotes(@NotNull Collection<OrderNote> notes)
    {
        super();

        this.notes = notes;
    }

    @NotNull
    public Collection<OrderNote> getNotes()
    {
        return notes;
    }
    public void setNotes(@NotNull Collection<OrderNote> notes)
    {
        this.notes = notes;
    }

    @NotNull
    public String toString()
    {
        return "OrderNotes(" +
            " notes: " + getNotes() + ")";
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

          final OrderNotes myObject = (OrderNotes) aObject;

          return Objects.equals(getNotes(), myObject.getNotes());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(
                            getNotes());
    }

    @NotNull
    public OrderNotesBuilder toBuilder()
    {
        return new OrderNotesBuilder(getNotes());
    }
}