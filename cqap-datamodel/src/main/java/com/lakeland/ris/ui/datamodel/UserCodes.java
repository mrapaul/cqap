package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class UserCodes
{
    @NotNull private Collection<String> codes;

    public UserCodes()
    {
        // empty
    }

    @JsonCreator
    public UserCodes(@NotNull Collection<String> codes)
    {
        super();

        this.codes = codes;
    }

    @NotNull
    public Collection<String> getCodes()
    {
        return codes;
    }
    public void setCodes(@NotNull Collection<String> codes)
    {
        this.codes = codes;
    }

    @NotNull
    public String toString()
    {
        return "UserCodes(" +
            " codes: " + getCodes() + ")";
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

          final UserCodes myObject = (UserCodes) aObject;

          return Objects.equals(getCodes(), myObject.getCodes());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(
                            getCodes());
    }

    @NotNull
    public UserCodesBuilder toBuilder()
    {
        return new UserCodesBuilder(getCodes());
    }
}