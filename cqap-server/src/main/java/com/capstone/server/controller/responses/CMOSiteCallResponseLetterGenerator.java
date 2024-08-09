package com.capstone.server.controller.responses;

import com.capstone.server.controller.*;
import com.peirs.datamodel.ticket.*;

public class CMOSiteCallResponseLetterGenerator extends BaseResponseLetterGenerator
{
    public CMOSiteCallResponseLetterGenerator(ProfessionalTicketRepository aRepository,
                                              UserRepository aUserRepository,
                                              StorageService aStorageService,
                                              String aTicketId,
                                              String aUserId)
    {
        super(aRepository, aUserRepository, aStorageService, aTicketId, aUserId);
    }

    @Override protected void generateResponseLetter(ResponseLetters aLetters, ProfessionalTicket aTicket)
    {
        aLetters.generateCMOSiteCallReport(aTicket);
    }

    @Override protected String getResponseLetterName()
    {
        return "CMO Site Call Report";
    }
}
