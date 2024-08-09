package com.cqap.util;

import ch.lambdaj.function.convert.*;
import com.peirs.datamodel.*;
import com.peirs.datamodel.dicom.*;
import com.peirs.datamodel.ticket.*;

public class TicketQueryResultConverter implements Converter<ProfessionalTicket, TicketQueryResult>
{
    @Override public TicketQueryResult convert(ProfessionalTicket aProfessionalTicket)
    {
        TicketQueryResult myResult = new TicketQueryResult();
        myResult.setTicketId(aProfessionalTicket.getId());
        myResult.setViewId(aProfessionalTicket.getViewId());
        myResult.setType(aProfessionalTicket.getType());
        myResult.setPriority(aProfessionalTicket.getPriority());
        myResult.setStatus(aProfessionalTicket.getStatus());
        myResult.setSubmittedTime(aProfessionalTicket.getSubmittedTime());
        myResult.setInstitution(aProfessionalTicket.getStudy().getInstitution());

        if (aProfessionalTicket.getType() == TicketType.PR)
        {
            ERPReport myERPReport = aProfessionalTicket.getERPReport();
            if (myERPReport != null)
            {
                myResult.setERPCategory(myERPReport.getCategory());
                myResult.setERP(myERPReport.getERP().getName());
            }

            CMOReport myCMOReport = aProfessionalTicket.getCMOReport();
            if (myCMOReport != null)
            {
                myResult.setCMOCategory(myCMOReport.getCategory());
                myResult.setCMO(myCMOReport.getCMO().getName());
            }

            int myTicketCategory = myResult.getCMOCategory() != 0 ?
                    myResult.getCMOCategory() :
                    myResult.getERPCategory();
            myResult.setCategory(myTicketCategory);
        }
        else
        {
            TechReport myTechReport = aProfessionalTicket.getTechReport();
            if (myTechReport != null)
            {
                myResult.setCategory(myTechReport.getCategory());
                myResult.setERP(myTechReport.getERP().getName());
            }
        }

        DicomStudy myStudy = aProfessionalTicket.getStudy();
        myResult.setStudyDate(myStudy.getStudyDate());
        myResult.setPatientName(myStudy.getPatientName());
        myResult.setPatientID(myStudy.getPatientID());
        myResult.setPatientBirthDate(myStudy.getPatientBirthDate());
        myResult.setAccessionNumber(myStudy.getAccessionNumber());
        myResult.setStudyDescription(myStudy.getStudyDescription());
        myResult.setModality(myStudy.getModality());
        myResult.setInstitutions(myStudy.getInstitutions());
        Institution myInstitution = myStudy.getInstitution();
        if (myInstitution != null)
        {
            myResult.setInstitutionName(myInstitution.getName());
        }

        return myResult;
    }
}
