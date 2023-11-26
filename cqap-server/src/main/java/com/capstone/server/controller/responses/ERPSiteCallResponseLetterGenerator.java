package com.capstone.server.controller.responses;

import com.capstone.server.controller.*;
import com.peirs.datamodel.ticket.*;

public class ERPSiteCallResponseLetterGenerator extends BaseResponseLetterGenerator
{
    public ERPSiteCallResponseLetterGenerator(ProfessionalTicketRepository aRepository,
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
        aLetters.generateERPSiteCallReport(aTicket, aStoreAttachment, aMailAddresses);
    }

    @Override protected String getResponseLetterName()
    {
        return "ERP Site Call Report";
    }
}
