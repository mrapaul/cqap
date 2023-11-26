package com.capstone.server.controller;

import com.peirs.datamodel.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component("UserService")
public class UserService
{
    @Autowired private UserRepository theUserRepository;

    public User findByUsername(String aName)
    {
        System.out.println("Looking up user " + aName);

        createAdminUserIfMissing();

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

    private void createAdminUserIfMissing()
    {
        User admin = theUserRepository.findByTheUsername("admin");
        if (admin == null)
        {
            User user = new User();
            user.setUsername("admin");
            user.setName("Administrator");
            user.setAlias("Administrator");
            user.setRole(Role.QAD);
            createOrUpdate(user);
        }
    }
}
