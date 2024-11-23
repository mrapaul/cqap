package com.lakeland.ris.datamodel;

public enum OrderStatus
{
    DRAFT((byte) 0),
    ORDERED((byte) 1),
    READY((byte) 2),
    ASSIGNED((byte) 3),
    PENDING((byte) 4),
    READ((byte) 5),
    CLOSED((byte) 6),
    FINAL((byte) 7),
    DELETED((byte) 8);

    private byte value;

    private OrderStatus(byte value)
    {
    	this.value = value;
    }

    public byte getValue()
    {
        return value;
    }
}