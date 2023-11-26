package com.peirs.datamodel.ticket;

import com.peirs.datamodel.*;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.*;

public class InternalNote
{
    private String theNote;
    private Date theDate;
    @DBRef private User theUser;

    public InternalNote()
    {
        // empty
    }

    public InternalNote(String aNote, Date aDate, User aUser)
    {
        theNote = aNote;
        theDate = aDate;
        theUser = aUser;
    }

    public String getNote()
    {
        return theNote;
    }

    public void setNote(String aNote)
    {
        theNote = aNote;
    }

    public Date getDate()
    {
        return theDate;
    }

    public void setDate(Date aDate)
    {
        theDate = aDate;
    }

    public User getUser()
    {
        return theUser;
    }

    public void setUser(User aUser)
    {
        theUser = aUser;
    }
}
