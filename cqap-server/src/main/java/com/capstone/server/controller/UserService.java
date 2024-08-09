package com.capstone.server.controller;

import com.peirs.datamodel.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component("UserService")
public class UserService
{
    private UserRepository theUserRepository;

    @Autowired
    public UserService(UserRepository aUserRepository)
    {
        theUserRepository = aUserRepository;
    }

    public User findByUsername(String aName)
    {
        User myUser = theUserRepository.findByTheUsername(aName);

        return myUser != null ? myUser : new User();
    }

    public Users findAllUsers()
    {
        return new Users(theUserRepository.findAll());
    }

    public Users findUsersByRole(Role aRole)
    {
        return new Users(theUserRepository.findByTheRole(aRole));
    }

    public User createOrUpdate(User aUser)
    {
        return theUserRepository.save(aUser);
    }

    public void delete(User aUser)
    {
        theUserRepository.delete(aUser);
    }
}
