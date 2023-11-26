package com.capstone.server.controller;

import com.peirs.datamodel.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController
{
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private final UserService theUserService;

    @Autowired
    public UserController(@Qualifier("UserService") UserService aUserService)
    {
        theUserService = aUserService;
    }

    @RequestMapping("/user/login")
    public @ResponseBody User login(@RequestParam(required = false) String name)
    {
        LOGGER.info("login '{}'", name);

        return theUserService.findByUsername(name);
    }

    @RequestMapping("/user/findByRole")
    public @ResponseBody Users findUsersByRole(@RequestParam(required = true) Role role)
    {
        return theUserService.findUsersByRole(role);
    }

    @RequestMapping("/user/findAll")
    public @ResponseBody Users findAll()
    {
        return theUserService.findAllUsers();
    }

    @RequestMapping(value = "/user/createOrUpdate", method = RequestMethod.POST)
    public @ResponseBody User createOrUpdateUser(@RequestBody User aUser)
    {
        return theUserService.createOrUpdate(aUser);
    }

    @RequestMapping(value = "/user/delete", method = RequestMethod.POST)
    public @ResponseBody void deleteUser(@RequestBody User aUser)
    {
        theUserService.delete(aUser);
    }
}
