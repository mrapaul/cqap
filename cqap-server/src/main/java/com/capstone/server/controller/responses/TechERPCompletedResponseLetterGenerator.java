package com.capstone.server.controller.responses;

import com.capstone.server.controller.*;
import com.peirs.datamodel.ticket.*;

public final class TechERPCompletedResponseLetterGenerator extends BaseResponseLetterGenerator
{
    public TechERPCompletedResponseLetterGenerator(ProfessionalTicketRepository aRepository,
                                                   UserRepository aUserRepository,
                                                   StorageService aStorageService,
                                                   String aTicketId,
                                                   String aUserId)
    {
        super(aRepository, aUserRepository, aStorageService, aTicketId, aUserId);
    }

    @Override protected void generateResponseLetter(ResponseLetters aLetters, ProfessionalTicket aTicket)
    {
        aLetters.generateTechERPReport(aTicket);
    }

    @Override protected String getResponseLetterName()
    {
        return "Tech ERP Response Letter";
    }
}

