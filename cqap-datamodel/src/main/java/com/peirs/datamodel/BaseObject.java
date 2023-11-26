package com.peirs.datamodel;

import org.springframework.data.mongodb.core.index.*;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.*;

public class BaseObject
{
    @Indexed private Date theCreatedDate;
    @Indexed private Date theUpdatedDate;
    @Indexed private Date theDeletedDate;
    @Indexed private boolean theDeleted;
    @DBRef private User theLastUpdatedBy;

    public Date getCreatedDate()
    {
        return theCreatedDate;
    }

    public void setCreatedDate(Date aCreatedDate)
    {
        theCreatedDate = aCreatedDate;
    }

    public Date getUpdatedDate()
    {
        return theUpdatedDate;
    }

    public void setUpdatedDate(Date aUpdatedDate)
    {
        theUpdatedDate = aUpdatedDate;
    }

    public Date getDeletedDate()
    {
        return theDeletedDate;
    }

    public void setDeletedDate(Date aDeletedDate)
    {
        theDeletedDate = aDeletedDate;
    }

    public boolean isDeleted()
    {
        return theDeleted;
    }

    public void setDeleted(boolean aDeleted)
    {
        theDeleted = aDeleted;
    }

    public User getLastUpdatedBy()
    {
        return theLastUpdatedBy;
    }

    public void setLastUpdatedBy(User aLastUpdatedBy)
    {
        theLastUpdatedBy = aLastUpdatedBy;
    }
}
