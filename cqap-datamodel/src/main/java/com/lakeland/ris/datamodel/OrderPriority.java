package com.lakeland.ris.datamodel;


public enum OrderPriority
{
    Prior((byte) 0, 0, "Priors"),
    Duplicate((byte) 1, 1, "Duplicate"),
    Low((byte) 2, 2, "Low (24 hour) – All routine exams"),
    Medium((byte) 3, 3, "Medium (2 hour) – Non-STAT inpatients"),
    STAT((byte) 4, 4, "STAT (30 Minutes) – ED and STAT inpatients"),
    SuperSTAT((byte) 5, 5, "Super STAT (20 Minutes) – Trauma, Stroke Protocol, AAA, PE");

    private byte value;
    private int rank;
    private String description;

    private OrderPriority(byte value,
                          int rank,
                          String description)
    {
    	this.value = value;
    	this.rank = rank;
    	this.description = description;
    }

    public byte getValue()
    {
        return value;
    }

    public int getRank()
    {
        return rank;
    }

    public String getDescription()
    {
        return description;
    }
}