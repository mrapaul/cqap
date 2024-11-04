package com.capstone.rest;

import com.peirs.datamodel.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component("UserService")
public class UserService
{
    @Autowired private UserRepository theUserRepository;

    public User findUser(String aName)
    {
        return theUserRepository.findByTheUsername(aName);
    }

    public Users findAllUsers()
    {
        return new Users(theUserRepository.findAll());
    }

    public Users findUsersByRole(Role aRole)
    {
        return new Users(theUserRepository.findByTheRole(aRole));
    }
}
