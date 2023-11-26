package com.peirs.datamodel.ticket;

public enum TicketPriority
{
    RTRC(15),
    RTRT(60),
    UR(12 * 60),
    RR(7 * 24 * 60),
    TR(7 * 24 * 60);

    private int theTimeLimit;

    private TicketPriority(int aTimeLimit)
    {
        theTimeLimit = aTimeLimit;
    }

    public int getTimeLimit()
    {
        return theTimeLimit;
    }
}
