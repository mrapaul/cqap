package com.peirs.datamodel.ticket;

import com.peirs.datamodel.*;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.*;

public class IIRReport
{
    private boolean theIIRAgree;
    private boolean theIIRMinorDisagree;
    private boolean theIIRMajorDisagree;
    private String theIIRDisagreeComments;
    @DBRef private User theIIR;
    private Date theReportTime;

    public boolean isIIRAgree()
    {
        return theIIRAgree;
    }

    public void setIIRAgree(boolean aIIRAgree)
    {
        theIIRAgree = aIIRAgree;
    }

    public boolean isIIRMinorDisagree()
    {
        return theIIRMinorDisagree;
    }

    public void setIIRMinorDisagree(boolean aIIRMinorDisagree)
    {
        theIIRMinorDisagree = aIIRMinorDisagree;
    }

    public boolean isIIRMajorDisagree()
    {
        return theIIRMajorDisagree;
    }

    public void setIIRMajorDisagree(boolean aIIRMajorDisagree)
    {
        theIIRMajorDisagree = aIIRMajorDisagree;
    }

    public void setIIRDisagreeComments(String aIIRDisagreeComments)
    {
        theIIRDisagreeComments = aIIRDisagreeComments;
    }

    public String getIIRDisagreeComments()
    {
        return theIIRDisagreeComments;
    }

    public User getIIR()
    {
        return theIIR;
    }

    public void setIIR(User aIIR)
    {
        theIIR = aIIR;
    }

    public Date getReportTime()
    {
        return theReportTime;
    }

    public void setReportTime(Date aReportTime)
    {
        theReportTime = aReportTime;
    }
}
