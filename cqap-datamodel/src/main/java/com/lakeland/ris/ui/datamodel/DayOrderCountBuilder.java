package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class DayOrderCountBuilder
{
    @NotNull private Date date;
    private int count;
    private int morningShift;
    private int afternoonShift;
    private int eveningShift;

    public DayOrderCountBuilder(@NotNull Date date)
    {
        super();

        this.date = date;
    }


    @NotNull
    public DayOrderCountBuilder setDate(@NotNull Date date)
    {
        this.date = date;

        return self();
    }

    @NotNull
    public DayOrderCountBuilder setCount(int count)
    {
        this.count = count;

        return self();
    }

    @NotNull
    public DayOrderCountBuilder setMorningShift(int morningShift)
    {
        this.morningShift = morningShift;

        return self();
    }

    @NotNull
    public DayOrderCountBuilder setAfternoonShift(int afternoonShift)
    {
        this.afternoonShift = afternoonShift;

        return self();
    }

    @NotNull
    public DayOrderCountBuilder setEveningShift(int eveningShift)
    {
        this.eveningShift = eveningShift;

        return self();
    }

    @NotNull
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

    @NotNull
    public DayOrderCount build()
    {
        return new DayOrderCount(getDate(),
                                 getCount(),
                                 getMorningShift(),
                                 getAfternoonShift(),
                                 getEveningShift());
    }


    @NotNull
    protected DayOrderCountBuilder self()
    {
        return this;
    }
}