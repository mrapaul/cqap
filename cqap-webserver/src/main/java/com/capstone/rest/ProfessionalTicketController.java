package com.capstone.rest;


import com.peirs.datamodel.ticket.*;
import org.jboss.resteasy.annotations.*;
import org.jboss.resteasy.annotations.Form;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Controller
@Path("/tickets")
public class ProfessionalTicketController
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ProfessionalTicketController.class);
    @Autowired private ProfessionalTicketService theTicketService;

    @GET
    @GZIP
    @Produces(MediaType.APPLICATION_JSON)
    @Path("findAllProfessionalTickets")
    public ProfessionalTickets findAllProfessionalTickets()
    {
        return theTicketService.findAllTickets();
    }

    @POST
    @GZIP
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("findProfessionalTickets")
    public ProfessionalTickets findProfessionalTickets(@BeanParam TicketQuery aQuery)
    {
        return theTicketService.findTickets(aQuery);
    }
}
