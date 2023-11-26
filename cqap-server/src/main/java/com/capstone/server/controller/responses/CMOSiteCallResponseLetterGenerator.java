package com.capstone.server.controller.responses;

import com.capstone.server.controller.*;
import com.peirs.datamodel.ticket.*;

public class CMOSiteCallResponseLetterGenerator extends BaseResponseLetterGenerator
{
    public CMOSiteCallResponseLetterGenerator(ProfessionalTicketRepository aRepository,
                                              UserRepository aUserRepository,
                                              StorageService aStorageService,
                                              String aTicketId,
                                              String aUserId,
                                              boolean aStoreAttachment,
                                              String aMailAddresses)
    {
        super(aRepository, aUserRepository, aStorageService, aTicketId, aUserId, aStoreAttachment, aMailAddresses);
    }

    @Override protected void generateResponseLetter(ResponseLetters aLetters,
                                                    ProfessionalTicket aTicket,
                                                    boolean aStoreAttachment,
                                                    String aMailAddresses)
    {
        aLetters.generateCMOSiteCallReport(aTicket, aStoreAttachment, aMailAddresses);
    }

    @Override protected String getResponseLetterName()
    {
        return "CMO Site Call Report";
    }
}
