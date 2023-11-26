package com.peirs.datamodel;

public class TicketPriorities
{
    private boolean thePRRTRT;
    private boolean thePRRTRC;
    private boolean thePRUR;
    private boolean thePRTR;
    private boolean thePRRR;
    private boolean theTRR;
    private boolean theTRT;

    public boolean isPRRTRT()
    {
        return thePRRTRT;
    }

    public void setPRRTRT(boolean aPRRTRT)
    {
        thePRRTRT = aPRRTRT;
    }

    public boolean isPRRTRC()
    {
        return thePRRTRC;
    }

    public void setPRRTRC(boolean aPRRTRC)
    {
        thePRRTRC = aPRRTRC;
    }

    public boolean isPRUR()
    {
        return thePRUR;
    }

    public void setPRUR(boolean aPRUR)
    {
        thePRUR = aPRUR;
    }

    public boolean isPRTR()
    {
        return thePRTR;
    }

    public void setPRTR(boolean aPRTR)
    {
        thePRTR = aPRTR;
    }

    public boolean isPRRR()
    {
        return thePRRR;
    }

    public void setPRRR(boolean aPRRR)
    {
        thePRRR = aPRRR;
    }

    public boolean isTRR()
    {
        return theTRR;
    }

    public void setTRR(boolean aTRR)
    {
        theTRR = aTRR;
    }

    public boolean isTRT()
    {
        return theTRT;
    }

    public void setTRT(boolean aTRT)
    {
        theTRT = aTRT;
    }
}
