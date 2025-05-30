package com.lakeland.ris.datamodel;

public enum UrgentExamType
{
    STROKE_PROTOCOL((byte) 0),
    AAA((byte) 1);

    private byte value;

    private UrgentExamType(byte value)
    {
    	this.value = value;
    }

    public byte getValue()
    {
        return value;
    }
}