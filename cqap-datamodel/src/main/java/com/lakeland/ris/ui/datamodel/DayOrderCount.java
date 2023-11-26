package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;


public class DayOrderCount
{
    @NotNull private Date date;
    private int count;
    private int morningShift;
    private int afternoonShift;
    private int eveningShift;

    public DayOrderCount()
    {
        // empty
    }

    @JsonCreator
    public DayOrderCount(@NotNull Date date,
                         int count,
                         int morningShift,
                         int afternoonShift,
                         int eveningShift)
    {
        super();

        this.date = date;
        this.count = count;
        this.morningShift = morningShift;
        this.afternoonShift = afternoonShift;
        this.eveningShift = eveningShift;
    }

    @NotNull
    public Date getDate()
    {
        return date;
    }

    public int getCount()
    {
        return count;
    }

    public int getMorningShift()
    {
        return morningShift;
    }

    public int getAfternoonShift()
    {
        return afternoonShift;
    }

    public int getEveningShift()
    {
        return eveningShift;
    }
    public void setDate(@NotNull Date date)
    {
        this.date = date;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    public void setMorningShift(int morningShift)
    {
        this.morningShift = morningShift;
    }

    public void setAfternoonShift(int afternoonShift)
    {
        this.afternoonShift = afternoonShift;
    }

    public void setEveningShift(int eveningShift)
    {
        this.eveningShift = eveningShift;
    }

    @NotNull
    public String toString()
    {
        return "DayOrderCount(" +
            " date: " + getDate() +
            " count: " + getCount() +
            " morningShift: " + getMorningShift() +
            " afternoonShift: " + getAfternoonShift() +
            " eveningShift: " + getEveningShift() + ")";
    }

    @NotNull
    public DayOrderCountBuilder toBuilder()
    {
        return new DayOrderCountBuilder(getDate()).setCount(getCount())
                                                  .setMorningShift(getMorningShift())
                                                  .setAfternoonShift(getAfternoonShift())
                                                  .setEveningShift(getEveningShift());
    }
}