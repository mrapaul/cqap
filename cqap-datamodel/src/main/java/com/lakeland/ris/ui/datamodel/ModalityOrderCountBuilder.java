package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;


public class ModalityOrderCountBuilder
{
    private String modality;
    private int count;

    public ModalityOrderCountBuilder(String modality)
    {
        super();

        this.modality = modality;
    }


    
    public ModalityOrderCountBuilder setModality(String modality)
    {
        this.modality = modality;

        return self();
    }

    
    public ModalityOrderCountBuilder setCount(int count)
    {
        this.count = count;

        return self();
    }

    
    protected String getModality()
    {
        return modality;
    }

    protected int getCount()
    {
        return count;
    }

    
    public ModalityOrderCount build()
    {
        return new ModalityOrderCount(getModality(),
                                      getCount());
    }


    
    protected ModalityOrderCountBuilder self()
    {
        return this;
    }
}