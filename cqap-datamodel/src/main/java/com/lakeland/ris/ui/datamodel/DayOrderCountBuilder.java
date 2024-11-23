package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;


public class DayOrderCountBuilder
{
    private Date date;
    private int count;
    private int morningShift;
    private int afternoonShift;
    private int eveningShift;

    public DayOrderCountBuilder(Date date)
    {
        super();

        this.date = date;
    }


    
    public DayOrderCountBuilder setDate(Date date)
    {
        this.date = date;

        return self();
    }

    
    public DayOrderCountBuilder setCount(int count)
    {
        this.count = count;

        return self();
    }

    
    public DayOrderCountBuilder setMorningShift(int morningShift)
    {
        this.morningShift = morningShift;

        return self();
    }

    
    public DayOrderCountBuilder setAfternoonShift(int afternoonShift)
    {
        this.afternoonShift = afternoonShift;

        return self();
    }

    
    public DayOrderCountBuilder setEveningShift(int eveningShift)
    {
        this.eveningShift = eveningShift;

        return self();
    }

    
    protected Date getDate()
    {
        return date;
    }

    protected int getCount()
    {
        return count;
    }

    protected int getMorningShift()
    {
        return morningShift;
    }

    protected int getAfternoonShift()
    {
        return afternoonShift;
    }

    protected int getEveningShift()
    {
        return eveningShift;
    }

    
    public DayOrderCount build()
    {
        return new DayOrderCount(getDate(),
                                 getCount(),
                                 getMorningShift(),
                                 getAfternoonShift(),
                                 getEveningShift());
    }


    
    protected DayOrderCountBuilder self()
    {
        return this;
    }
}