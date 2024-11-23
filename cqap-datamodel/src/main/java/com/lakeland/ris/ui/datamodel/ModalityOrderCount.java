package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;


public class ModalityOrderCount
{
    private String modality;
    private int count;

    public ModalityOrderCount()
    {
        // empty
    }

    @JsonCreator
    public ModalityOrderCount(String modality,
                              int count)
    {
        super();

        this.modality = modality;
        this.count = count;
    }


    public String getModality()
    {
        return modality;
    }

    public int getCount()
    {
        return count;
    }
    public void setModality(String modality)
    {
        this.modality = modality;
    }

    public void setCount(int count)
    {
        this.count = count;
    }


    public String toString()
    {
        return "ModalityOrderCount(" +
            " modality: " + getModality() +
            " count: " + getCount() + ")";
    }


    public ModalityOrderCountBuilder toBuilder()
    {
        return new ModalityOrderCountBuilder(getModality()).setCount(getCount());
    }
}