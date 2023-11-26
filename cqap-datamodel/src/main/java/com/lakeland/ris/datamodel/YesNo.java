package com.lakeland.ris.datamodel;

import org.jetbrains.annotations.*;

public enum YesNo
{
    Y((byte) 0),
    N((byte) 1);

    private byte value;

    private YesNo(byte value)
    {
    	this.value = value;
    }

    public byte getValue()
    {
        return value;
    }
}