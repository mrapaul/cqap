package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class ModalityOrderCountBuilder
{
    @NotNull private String modality;
    private int count;

    public ModalityOrderCountBuilder(@NotNull String modality)
    {
        super();

        this.modality = modality;
    }


    @NotNull
    public ModalityOrderCountBuilder setModality(@NotNull String modality)
    {
        this.modality = modality;

        return self();
    }

    @NotNull
    public ModalityOrderCountBuilder setCount(int count)
    {
        this.count = count;

        return self();
    }

    @NotNull
    protected String getModality()
    {
        return modality;
    }

    protected int getCount()
    {
        return count;
    }

    @NotNull
    public ModalityOrderCount build()
    {
        return new ModalityOrderCount(getModality(),
                                      getCount());
    }


    @NotNull
    protected ModalityOrderCountBuilder self()
    {
        return this;
    }
}