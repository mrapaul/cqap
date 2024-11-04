package com.capstone.rest;

import com.peirs.datamodel.*;
import org.jboss.resteasy.annotations.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Controller
@Path("/users")
public class UserController
{
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired private UserService theUserService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("login/{username}")
    public User login(@PathParam("username") String username)
    {
        return theUserService.findUser(username);
    }

    @GET
    @GZIP
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("findUsersByRole/{role}")
    public Users findUsersByRole(@PathParam("role") Role role)
    {
        return theUserService.findUsersByRole(role);
    }

    @GET
    @GZIP
    @Produces(MediaType.APPLICATION_JSON)
    @Path("findAllUsers")
    public Users findAll()
    {
        return theUserService.findAllUsers();
    }
}
