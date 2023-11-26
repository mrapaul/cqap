package com.capstone.server.controller.responses;

import com.capstone.server.controller.*;
import com.peirs.datamodel.ticket.*;

public class CMOCompletedResponseLetterGenerator extends BaseResponseLetterGenerator
{
    public CMOCompletedResponseLetterGenerator(ProfessionalTicketRepository aRepository,
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
        aLetters.generateCMOReport(aTicket, aStoreAttachment, aMailAddresses);
    }

    @Override protected String getResponseLetterName()
    {
        return "ERP Response Letter";
    }
}
