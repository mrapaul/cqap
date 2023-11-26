package com.lakeland.ris.datamodel;

import org.jetbrains.annotations.*;

public enum Modality
{
    CT((byte) 0, "CT/SR"),
    NM((byte) 1, "NM"),
    US((byte) 2, "US"),
    XR((byte) 3, "XR/CR/RF"),
    MR((byte) 4, "MR"),
    XA((byte) 5, "XA/IV"),
    MG((byte) 6, "MG"),
    DX((byte) 7, "DX"),
    OTHER((byte) 8, "OTHER");

    private byte value;
    private String description;

    private Modality(byte value,
                     String description)
    {
    	this.value = value;
    	this.description = description;
    }

    public byte getValue()
    {
        return value;
    }

    @NotNull
    public String getDescription()
    {
        return description;
    }
}