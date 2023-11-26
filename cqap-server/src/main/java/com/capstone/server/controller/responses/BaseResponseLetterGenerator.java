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
    private final boolean theStoreAttachment;
    private final String theMailAddresses;

    public BaseResponseLetterGenerator(ProfessionalTicketRepository aTicketRepository,
                                       UserRepository aUserRepository,
                                       StorageService aStorageService,
                                       String aTicketId,
                                       String aUserId,
                                       boolean aStoreAttachment,
                                       String aMailAddresses)
    {
        theTicketRepository = aTicketRepository;
        theUserRepository = aUserRepository;
        theStorageRepository = aStorageService;
        theTicketId = aTicketId;
        theUserId = aUserId;
        theStoreAttachment = aStoreAttachment;
        theMailAddresses = aMailAddresses;
    }

    @Override
    public void run()
    {
        ProfessionalTicket myTicket = theTicketRepository.findById(new ObjectId(theTicketId)).orElseThrow();
        User myUser = theUserRepository.findById(new ObjectId(theUserId)).orElseThrow();
        generateResponseLetter(new ResponseLetters(theStorageRepository),
                myTicket,
                theStoreAttachment,
                theMailAddresses);
        if (theStoreAttachment)
        {
            myTicket = theTicketRepository.findById(new ObjectId(theTicketId)).orElseThrow();
            myTicket.getNotes().add(new InternalNote("Generated " + getResponseLetterName(), new Date(), myUser));
            theTicketRepository.save(myTicket);
        }

        if (theMailAddresses != null)
        {
            myTicket = theTicketRepository.findById(new ObjectId(theTicketId)).orElseThrow();
            myTicket.getNotes()
                    .add(new InternalNote("Re-sent " + getResponseLetterName() + " to " + theMailAddresses,
                            new Date(),
                            myUser));
            theTicketRepository.save(myTicket);
        }
    }

    protected abstract void generateResponseLetter(ResponseLetters aLetters,
                                                   ProfessionalTicket aTicket,
                                                   boolean aStoreAttachment,
                                                   String aMailAddresses);

    protected abstract String getResponseLetterName();
}
