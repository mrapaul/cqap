package com.cqap.client;

import ch.lambdaj.*;
import ch.lambdaj.collection.*;
import com.google.common.collect.*;
import com.peirs.datamodel.*;
import com.peirs.datamodel.attachments.*;
import com.peirs.datamodel.dicom.*;
import com.peirs.datamodel.hl7.*;
import com.peirs.datamodel.ticket.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.core.io.*;
import org.springframework.util.*;
import org.springframework.web.client.*;

import java.io.*;
import java.util.*;

public class ClientRestService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientRestService.class);
    @Autowired private RestTemplate theRestTemplate;
    private final String theServerURL;

    public ClientRestService(String aServerURL)
    {
        LOGGER.info("DicomStudyService is using server URL '{}'", aServerURL);
        theServerURL = aServerURL;
    }

    public List<DicomStudyQueryResult> findDicomStudies(DicomStudyQuery aQuery)
    {
        DicomStudyQueryResults myStudies = theRestTemplate.postForObject(
                theServerURL + "/dicomStudy/find", aQuery, DicomStudyQueryResults.class);
        return myStudies.getResults();
    }

    public List<DicomStudy> findDicomStudiesByStudyInstanceUID(String aStudyInstanceUID)
    {
        MultiValueMap<String, Object> myValues = new LinkedMultiValueMap<>();
        myValues.add("studyInstanceUID", aStudyInstanceUID);
        DicomStudies myStudies = theRestTemplate.postForObject(theServerURL + "/dicomStudy/findByStudyInstanceUID",
                myValues,
                DicomStudies.class);
        return myStudies.getStudies();
    }

    public DicomStudy findDicomStudy(String aId)
    {
        MultiValueMap<String, Object> myValues = new LinkedMultiValueMap<>();
        myValues.add("id", aId);
        return theRestTemplate.postForObject(theServerURL + "/dicomStudy/findOne", myValues, DicomStudy.class);
    }

    public void createOrUpdateDicomStudy(DicomStudy aDicomStudy)
    {
        theRestTemplate.postForLocation(theServerURL + "/dicomStudy/createOrUpdate", aDicomStudy);
    }

    public List<TicketQueryResult> findProfessionalTickets(TicketQuery aQuery)
    {
        TicketQueryResults myTickets = theRestTemplate.postForObject(
                theServerURL + "/professionalTickets/find", aQuery, TicketQueryResults.class);
        return myTickets.getTickets();
    }

    public ProfessionalTicket findProfessionalTicket(TicketQueryResult aResult)
    {
        MultiValueMap<String, Object> myValues = new LinkedMultiValueMap<>();
        myValues.add("ticketId", aResult.getTicketId());
        return theRestTemplate.postForObject(
                theServerURL + "/professionalTickets/findOne", myValues, ProfessionalTicket.class);
    }

    public ProfessionalTicket createOrUpdateProfessionalTicket(ProfessionalTicket aProfessionalTicket, User aUser)
    {
        aProfessionalTicket.setUpdatedDate(new Date());
        aProfessionalTicket.setLastUpdatedBy(aUser);
        return theRestTemplate.postForObject(theServerURL + "/professionalTickets/createOrUpdate",
                aProfessionalTicket,
                ProfessionalTicket.class);
    }

    public void deleteProfessionalTicket(ProfessionalTicket aProfessionalTicket, User aUser)
    {
        aProfessionalTicket.setDeletedDate(new Date());
        aProfessionalTicket.setLastUpdatedBy(aUser);
        theRestTemplate.postForLocation(theServerURL + "/professionalTickets/delete", aProfessionalTicket);
    }

    public List<HL7> findMergeHL7Messages(DicomStudy aStudy)
    {
        HL7Messages myMessages = theRestTemplate.postForObject(theServerURL + "/hl7/findForStudy",
                aStudy,
                HL7Messages.class);
        return myMessages.getMessages();
    }

    public User loginUser(String aUsername)
    {
        LOGGER.info("Login to server using name: {}", aUsername);
        Map<String, Object> myValues = Maps.newHashMap();
        myValues.put("name", aUsername);
        User myUser = theRestTemplate.getForObject(
                theServerURL + "/user/login?name={name}", User.class, myValues);
        LOGGER.info("Server responded with: {}", myUser);
        return myUser;
    }

    public List<String> findUsersForRole(Role aRole)
    {
        LOGGER.info("Searching for users for role: {}", aRole);
        Map<String, Object> myValues = Maps.newHashMap();
        myValues.put("role", aRole);
        Users myUsers = theRestTemplate.getForObject(
                theServerURL + "/user/findByRole?role={role}", Users.class, myValues);
        LOGGER.info("Server responded with: {}", myUsers);
        return LambdaCollections.with(myUsers.getUsers()).extract(Lambda.on(User.class).getName());
    }

    public List<User> findAllUsers()
    {
        Users myUsers = theRestTemplate.getForObject(theServerURL + "/user/findAll", Users.class);
        return myUsers.getUsers();
    }

    public void createOrUpdateUser(User aUser)
    {
        theRestTemplate.postForLocation(theServerURL + "/user/createOrUpdate", aUser);
    }

    public void deleteUser(User aUser)
    {
        theRestTemplate.postForLocation(theServerURL + "/user/delete", aUser);
    }

    public List<Group> findAllGroups()
    {
        Groups myGroups = theRestTemplate.getForObject(theServerURL + "/group/findAll", Groups.class);
        return myGroups.getGroups();
    }

    public void createOrUpdateGroup(Group aGroup)
    {
        theRestTemplate.postForLocation(theServerURL + "/group/createOrUpdate", aGroup);
    }

    public void deleteGroup(Group aGroup)
    {
        theRestTemplate.postForLocation(theServerURL + "/group/delete", aGroup);
    }

    public List<Institution> findAllInstitutions()
    {
        Institutions myInstitutions =
                theRestTemplate.getForObject(theServerURL + "/institution/findAll", Institutions.class);
        return myInstitutions.getInstitutions();
    }

    public void createOrUpdateInstitution(Institution aInstitution)
    {
        theRestTemplate.postForLocation(theServerURL + "/institution/createOrUpdate", aInstitution);
    }

    public void deleteInstitution(Institution aInstitution)
    {
        theRestTemplate.postForLocation(theServerURL + "/institution/delete", aInstitution);
    }

    public List<HealthcareSegment> findAllHealthcareSegments()
    {
        HealthcareSegments mySegments =
                theRestTemplate.getForObject(theServerURL + "/healthcareSegment/findAll", HealthcareSegments.class);
        return mySegments.getHealthcareSegments();
    }

    public List<Country> findAllCountries()
    {
        Countries myCountries = theRestTemplate.getForObject(theServerURL + "/countries/findAll", Countries.class);
        return myCountries.getCountries();
    }

    public Set<String> findTimezones(Country aCountry)
    {
        Timezones myTimezones = theRestTemplate.postForObject(
                theServerURL + "/countries/findTimezones", aCountry, Timezones.class);
        return myTimezones.getTimezones();
    }

    public void addTicketAttachment(ProfessionalTicket aTicket, File aFile)
    {
        try
        {
            MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
            parts.add("ticketId", aTicket.getId());
            parts.add("file", new FileSystemResource(aFile));
            String response =
                    theRestTemplate.postForObject(theServerURL + "/tickets/uploadAttachment", parts, String.class);

            if (!Boolean.TRUE.toString().equalsIgnoreCase(response))
            {
                LOGGER.error("Error uploading attachment : ", response);
            }
        }
        catch (Exception e)
        {
            LOGGER.error("Error uploading attachment", e);
        }
    }

    public List<Attachment> getTicketAttachments(ProfessionalTicket aTicket)
    {
        MultiValueMap<String, Object> myValues = new LinkedMultiValueMap<>();
        myValues.add("ticketId", aTicket.getId());
        myValues.add("studyId", aTicket.getStudy().getId());
        Attachments myAttachments = theRestTemplate.postForObject(
                theServerURL + "/tickets/getAttachmentNames", myValues, Attachments.class);
        return myAttachments.getAttachments();
    }

    public InputStream getTicketAttachment(Attachment aAttachment) throws IOException
    {
        MultiValueMap<String, Object> myValues = new LinkedMultiValueMap<>();
        myValues.add("id", aAttachment.getId());
        ByteArrayResource myResource = theRestTemplate.postForObject(
                theServerURL + "/tickets/getAttachment", myValues, ByteArrayResource.class);
        return myResource.getInputStream();
    }

    public void deleteTicketAttachment(Attachment aAttachment)
    {
        MultiValueMap<String, Object> myValues = new LinkedMultiValueMap<>();
        myValues.add("id", aAttachment.getId());
        theRestTemplate.postForLocation(theServerURL + "/tickets/deleteAttachment", myValues);
    }

    public String addDicomStudyPatientReport(DicomStudy aStudy, File aFile)
    {
        try
        {
            MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
            parts.add("studyId", aStudy.getId());
            parts.add("file", new FileSystemResource(aFile));

            return theRestTemplate.postForObject(theServerURL + "/dicomStudy/uploadPatientReport", parts, String.class);
        }
        catch (Exception e)
        {
            LOGGER.error("Error uploading attachment", e);
        }

        return null;
    }

    public void generateERPResponseLetter(ProfessionalTicket aTicket, User aUser)
    {
        generateResponseLetter(aTicket, aUser, "/tickets/generateERPResponseLetter");
    }

    public void generateTechERPResponseLetter(ProfessionalTicket aTicket, User aUser)
    {
        generateResponseLetter(aTicket, aUser, "/tickets/generateTechERPResponseLetter");
    }

    public void generateERPSiteCallLetter(ProfessionalTicket aTicket, User aUser)
    {
        generateResponseLetter(aTicket, aUser, "/tickets/generateERPSiteCallLetter");
    }

    public void generateCMOSiteCallLetter(ProfessionalTicket aTicket, User aUser)
    {
        generateResponseLetter(aTicket, aUser, "/tickets/generateCMOSiteCallLetter");
    }

    public void generateCMOResponseLetter(ProfessionalTicket aTicket, User aUser)
    {
        generateResponseLetter(aTicket, aUser, "/tickets/generateCMOResponseLetter");
    }

    private void generateResponseLetter(ProfessionalTicket aTicket, User aUser, String aURLSuffix)
    {
        MultiValueMap<String, Object> myValues = new LinkedMultiValueMap<>();
        myValues.add("ticketId", aTicket.getId());
        myValues.add("userId", aUser.getId());
        theRestTemplate.postForLocation(theServerURL + aURLSuffix, myValues);
    }

    public String createProfessionalTickets(CreateTicketRequests aRequests)
    {
        return theRestTemplate.postForObject(theServerURL + "/professionalTickets/create", aRequests, String.class);
    }

    public ProfessionalTicket createCorrespondingTicket(ProfessionalTicket aTicket, User aUser)
    {
        MultiValueMap<String, Object> myValues = new LinkedMultiValueMap<>();
        myValues.add("ticketId", aTicket.getId());
        myValues.add("userId", aUser.getId());
        return theRestTemplate.postForObject(theServerURL + "/professionalTickets/createCorresponding",
                myValues,
                ProfessionalTicket.class);
    }

    public void createHL7Message(MergeHL7Message aMessage)
    {
        theRestTemplate.postForLocation(theServerURL + "/hl7/createOrUpdate", aMessage);
    }

    public List<CPTCode> findAllCPTCodes()
    {
        CPTCodes myCodes = theRestTemplate.getForObject(theServerURL + "/CPTCodes/findAll", CPTCodes.class);
        return myCodes.getCodes();
    }

    public void createOrUpdateCPTCode(CPTCode aCPTCode)
    {
        theRestTemplate.postForLocation(theServerURL + "/CPTCodes/createOrUpdate", aCPTCode);
    }

    public void addErrorHandler(ResponseErrorHandler aErrorHandler)
    {
        theRestTemplate.setErrorHandler(aErrorHandler);
    }
}
