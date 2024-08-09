package com.capstone.server.controller.responses;

import com.capstone.server.controller.*;
import com.peirs.datamodel.*;
import com.peirs.datamodel.ticket.*;
import org.bson.types.*;

import java.util.*;

public abstract class BaseResponseLetterGenerator implements Runnable
{
    private final ProfessionalTicketRepository theTicketRepository;
    private final UserRepository theUserRepository;
    private final StorageService theStorageRepository;
    private final String theTicketId;
    private final String theUserId;

    public BaseResponseLetterGenerator(ProfessionalTicketRepository aTicketRepository,
                                       UserRepository aUserRepository,
                                       StorageService aStorageService,
                                       String aTicketId,
                                       String aUserId)
    {
        theTicketRepository = aTicketRepository;
        theUserRepository = aUserRepository;
        theStorageRepository = aStorageService;
        theTicketId = aTicketId;
        theUserId = aUserId;
    }

    @Override
    public void run()
    {
        ProfessionalTicket myTicket = theTicketRepository.findOne(new ObjectId(theTicketId));
        User myUser = theUserRepository.findOne(new ObjectId(theUserId));
        generateResponseLetter(new ResponseLetters(theStorageRepository), myTicket);
        myTicket.getNotes().add(new InternalNote("Generated " + getResponseLetterName(), new Date(), myUser));
        theTicketRepository.save(myTicket);
    }

    protected abstract void generateResponseLetter(ResponseLetters aLetters, ProfessionalTicket aTicket);

    protected abstract String getResponseLetterName();
}
