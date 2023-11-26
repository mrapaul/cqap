package com.capstone.server.controller;

import com.peirs.datamodel.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class GroupController
{
    private final GroupService theGroupService;

    @Autowired
    public GroupController(@Qualifier("GroupService") GroupService aGroupService)
    {
        theGroupService = aGroupService;
    }

    @RequestMapping("/group/findAll")
    public @ResponseBody Groups findAll()
    {
        return theGroupService.findAll();
    }

    @RequestMapping(value = "group/createOrUpdate", method = RequestMethod.POST)
    public @ResponseBody void createOrUpdate(@RequestBody Group aGroup)
    {
        theGroupService.createOrUpdate(aGroup);
    }

    @RequestMapping(value = "group/delete", method = RequestMethod.POST)
    public @ResponseBody void delete(@RequestBody Group aGroup)
    {
        theGroupService.delete(aGroup);
    }
}
