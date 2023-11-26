package com.capstone.server.controller.responses;

import com.capstone.server.controller.*;
import com.peirs.datamodel.ticket.*;

public final class TechERPCompletedResponseLetterGenerator extends BaseResponseLetterGenerator
{
    public TechERPCompletedResponseLetterGenerator(ProfessionalTicketRepository aRepository,
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
        aLetters.generateTechERPReport(aTicket, aStoreAttachment, aMailAddresses);
    }

    @Override protected String getResponseLetterName()
    {
        return "Tech ERP Response Letter";
    }
}

