package com.peirs.datamodel.ticket;

import com.peirs.datamodel.*;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.*;

public class SiteCallReport
{
    private String theCallPhysician;
    private String theCaller;
    private String theCallNotes;
    private String theCallDate;
    @DBRef private User theUser;
    private Date theReportTime;

    public String getCallPhysician()
    {
        return theCallPhysician;
    }

    public void setCallPhysician(String aCallPhysician)
    {
        theCallPhysician = aCallPhysician;
    }

    public String getCaller()
    {
        return theCaller;
    }

    public void setCaller(String aCaller)
    {
        theCaller = aCaller;
    }

    public String getCallNotes()
    {
        return theCallNotes;
    }

    public void setCallNotes(String aCallNotes)
    {
        theCallNotes = aCallNotes;
    }

    public String getCallDate()
    {
        return theCallDate;
    }

    public void setCallDate(String aCallDate)
    {
        theCallDate = aCallDate;
    }

    public User getUser()
    {
        return theUser;
    }

    public void setUser(User aUser)
    {
        theUser = aUser;
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
