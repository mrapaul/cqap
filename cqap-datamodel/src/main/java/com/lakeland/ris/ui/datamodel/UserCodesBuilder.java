package com.lakeland.ris.ui.datamodel;


import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class UserCodesBuilder
{
    private Collection<String> codes;

    public UserCodesBuilder(Collection<String> codes)
    {
        super();

        this.codes = codes;
    }



    public UserCodesBuilder setCodes(Collection<String> codes)
    {
        this.codes = codes;

        return self();
    }


    protected Collection<String> getCodes()
    {
        return codes;
    }


    public UserCodes build()
    {
        return new UserCodes(getCodes());
    }



    protected UserCodesBuilder self()
    {
        return this;
    }
}