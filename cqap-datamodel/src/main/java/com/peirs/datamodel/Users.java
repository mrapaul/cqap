package com.peirs.datamodel;

import java.util.*;

public class Users
{
    private List<User> theUsers;

    public Users()
    {
        theUsers = new ArrayList<>();
    }

    public Users(List<User> aUsers)
    {
        theUsers = aUsers;
    }

    public List<User> getUsers()
    {
        return theUsers;
    }

    public void setUsers(List<User> aUsers)
    {
        theUsers = aUsers;
    }
}
