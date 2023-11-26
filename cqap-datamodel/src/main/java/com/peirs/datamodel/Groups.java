package com.peirs.datamodel;

import java.util.*;

public class Groups
{
    private List<Group> theGroups;

    public Groups()
    {
        theGroups = new ArrayList<>();
    }

    public Groups(List<Group> aGroups)
    {
        theGroups = aGroups;
    }

    public List<Group> getGroups()
    {
        return theGroups;
    }

    public void setGroups(List<Group> aGroups)
    {
        theGroups = aGroups;
    }
}
