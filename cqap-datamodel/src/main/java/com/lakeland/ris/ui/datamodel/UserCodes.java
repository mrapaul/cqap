package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class UserCodes
{
    private Collection<String> codes;

    public UserCodes()
    {
        // empty
    }

    @JsonCreator
    public UserCodes(Collection<String> codes)
    {
        super();

        this.codes = codes;
    }


    public Collection<String> getCodes()
    {
        return codes;
    }
    public void setCodes(Collection<String> codes)
    {
        this.codes = codes;
    }


    public String toString()
    {
        return "UserCodes(" +
            " codes: " + getCodes() + ")";
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

          final UserCodes myObject = (UserCodes) aObject;

          return Objects.equals(getCodes(), myObject.getCodes());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(
                            getCodes());
    }


    public UserCodesBuilder toBuilder()
    {
        return new UserCodesBuilder(getCodes());
    }
}