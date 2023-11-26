package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class ModalityOrderCount
{
    @NotNull private String modality;
    private int count;

    public ModalityOrderCount()
    {
        // empty
    }

    @JsonCreator
    public ModalityOrderCount(@NotNull String modality,
                              int count)
    {
        super();

        this.modality = modality;
        this.count = count;
    }

    @NotNull
    public String getModality()
    {
        return modality;
    }

    public int getCount()
    {
        return count;
    }
    public void setModality(@NotNull String modality)
    {
        this.modality = modality;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    @NotNull
    public String toString()
    {
        return "ModalityOrderCount(" +
            " modality: " + getModality() +
            " count: " + getCount() + ")";
    }

    @NotNull
    public ModalityOrderCountBuilder toBuilder()
    {
        return new ModalityOrderCountBuilder(getModality()).setCount(getCount());
    }
}