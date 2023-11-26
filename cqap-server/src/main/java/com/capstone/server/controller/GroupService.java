package com.capstone.server.controller;

import com.peirs.datamodel.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component("GroupService")
public class GroupService
{
    @Autowired private GroupRepository theRepository;

    public Groups findAll()
    {
        return new Groups(theRepository.findAll());
    }

    public Group createOrUpdate(Group aGroup)
    {
        return theRepository.save(aGroup);
    }

    public void delete(Group aGroup)
    {
        theRepository.delete(aGroup);
    }
}
