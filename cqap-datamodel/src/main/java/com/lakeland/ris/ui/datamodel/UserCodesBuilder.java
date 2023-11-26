package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class UserCodesBuilder
{
    @NotNull private Collection<String> codes;

    public UserCodesBuilder(@NotNull Collection<String> codes)
    {
        super();

        this.codes = codes;
    }


    @NotNull
    public UserCodesBuilder setCodes(@NotNull Collection<String> codes)
    {
        this.codes = codes;

        return self();
    }

    @NotNull
    protected Collection<String> getCodes()
    {
        return codes;
    }

    @NotNull
    public UserCodes build()
    {
        return new UserCodes(getCodes());
    }


    @NotNull
    protected UserCodesBuilder self()
    {
        return this;
    }
}