package com.cqap.client;

import com.lakeland.ris.ui.datamodel.CPTCodePrimaryGroup;
import com.lakeland.ris.ui.datamodel.CPTCodePrimaryGroups;
import com.peirs.datamodel.*;
import com.peirs.datamodel.attachments.Attachment;
import com.peirs.datamodel.attachments.Attachments;
import com.peirs.datamodel.dicom.*;
import com.peirs.datamodel.hl7.*;
import com.peirs.datamodel.ticket.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ClientRestService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientRestService.class);
    private final String theServerURL;
    private final RestTemplate theRestTemplate;

    @Autowired
    public ClientRestService(ClientProperties clientProperties, RestTemplate aRestTemplate)
    {
        theServerURL = clientProperties.getServerUrl();
        theRestTemplate = aRestTemplate;
        LOGGER.info("ClientRestService is using server URL '{}'", theServerURL);
        System.setProperty("proxyPort", "8080");
    }

    public List<DicomStudyQueryResult> findDicomStudies(DicomStudyQuery aQuery)
    {
        DicomStudyQueryResults myStudies = theRestTemplate.postForObject(
                theServerURL + "/dicomStudy/find", aQuery, DicomStudyQueryResults.class);
        return myStudies.getResults();
    }

    public List<DicomStudy> findDicomStudiesByStudyInstanceUID(String aStudyInstanceUID)
    {
        try {
            MultiValueMap<String, Object> myValues = new LinkedMultiValueMap<>();
            myValues.add("studyInstanceUID", aStudyInstanceUID);
            DicomStudies myStudies = theRestTemplate.postForObject(theServerURL + "/dicomStudy/findByStudyInstanceUID",
                    myValues,
                    DicomStudies.class);
            return myStudies.getStudies();
        } catch (Exception e) {
            LOGGER.error("Error retrieving studies", e);
            return Collections.emptyList();
        }
    }

    public DicomStudy findDicomStudy(String aId)
    {
        MultiValueMap<String, Object> myValues = new LinkedMultiValueMap<>();
        myValues.add("id", aId);
        return theRestTemplate.postForObject(theServerURL + "/dicomStudy/findOne", myValues, DicomStudy.class);
    }

    public DicomStudy createOrUpdateDicomStudy(DicomStudy aDicomStudy)
    {
        return theRestTemplate.postForObject(theServerURL + "/dicomStudy/createOrUpdate",
                aDicomStudy,
                DicomStudy.class);
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

    public ProfessionalTicket findProfessionalTicket(String ticketId)
    {
        MultiValueMap<String, Object> myValues = new LinkedMultiValueMap<>();
        myValues.add("ticketId", ticketId);
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
        Map<String, Object> myValues = new HashMap<>();
        myValues.put("name", aUsername);
        User myUser = theRestTemplate.getForObject(
                theServerURL + "/user/login?name={name}", User.class, myValues);
        LOGGER.info("Server responded with: {}", myUser);
        return myUser;
    }

    public List<String> findUsersForRole(Role aRole)
    {
        LOGGER.info("Searching for users for role: {}", aRole);
        Map<String, Object> myValues = new HashMap<>();
        myValues.put("role", aRole);
        Users myUsers = theRestTemplate.getForObject(
                theServerURL + "/user/findByRole?role={role}", Users.class, myValues);
        LOGGER.info("Server responded with: {}", myUsers);
        return myUsers.getUsers().stream().map(User::getName).collect(Collectors.toList());
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

    public List<Institution> findAllInstitutions() {
        try {
            Institutions myInstitutions = theRestTemplate
                    .getForObject(theServerURL + "/institution/findAll", Institutions.class);
            return myInstitutions.getInstitutions();
        } catch (Exception e) { // This catches any exception that occurs
            LOGGER.error("Failed to retrieve institutions: {}", e.getMessage());
            // Return an empty list to indicate failure
            return Collections.emptyList();
        }
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

    @Deprecated
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

    @NotNull
    public Collection<CPTCodePrimaryGroup> findAllCPTCodesMapped()
    {
        try
        {
            CPTCodePrimaryGroups myCodes =
                    theRestTemplate.getForObject(theServerURL + "/CPTCodes/findAllMapped", CPTCodePrimaryGroups.class);
            return myCodes.getGroups();
        }
        catch (RestClientException e)
        {
            LOGGER.error("Error retrieving mapped CPT Codes", e);
        }

        return Collections.emptyList();
    }

    public void addErrorHandler(ResponseErrorHandler aErrorHandler)
    {
        theRestTemplate.setErrorHandler(aErrorHandler);
    }

    @Nullable
    public String getViewerLaunchURL(@NotNull String id,
                                     @NotNull String username)
    {
        MultiValueMap<String, Object> values = new LinkedMultiValueMap<>();
        values.add("dicomId", id);
        values.add("username", username);

        return theRestTemplate.postForObject(theServerURL + "/dicomViewer/launchURL", values, String.class);
    }

    public Collection<DicomStudy> findRelatedExams(DicomStudy study)
    {
        return theRestTemplate.postForObject(theServerURL + "/dicomStudy/findRelatedStudies", study, DicomStudies.class)
                .getStudies();
    }

//    public List<PACS> findAllPACS()
//    {
//        return theRestTemplate.getForObject(theServerURL + "/PACS/findAll", PACSs.class).getPACS();
//    }
//
//    public PACS createOrUpdatePACS(PACS pacs)
//    {
//        return theRestTemplate.postForObject(theServerURL + "/PACS/createOrUpdate", pacs, PACS.class);
//    }
//
//    public void deletePACS(PACS pacs)
//    {
//        theRestTemplate.postForLocation(theServerURL + "/PACS/delete", pacs);
//    }
//
//    @NotNull
//    public Collection<ExternalDicomStudy> getExternalImages(ExternalDicomStudyRequest request)
//    {
//        try
//        {
//            ExternalDicomStudies studies = theRestTemplate.postForObject(theServerURL + "/PACS/queryExternalStudies",
//                    request,
//                    ExternalDicomStudies.class);
//            return studies.getStudies();
//        }
//        catch (RestClientException e)
//        {
//            LOGGER.error("Error retrieving external studies", e);
//        }
//
//        return Collections.emptyList();
//    }
//
//    public List<DicomStudy> importImage(PACS pacs, ExternalDicomStudy externalDicomStudy)
//    {
//        return theRestTemplate.postForObject(theServerURL + "/PACS/importExternal",
//                new ExternalDicomStudyImportRequest(externalDicomStudy, pacs),
//                DicomStudies.class)
//                .getStudies();
//    }
//
//    @NotNull
//    public Collection<TicketsPerDay> getTicketsPerDay()
//    {
//        try
//        {
//            return theRestTemplate.getForObject(theServerURL + "/stats/totalTicketsPerDay",
//                    TicketsPerDayCollection.class).getCounts();
//        }
//        catch (RestClientException e)
//        {
//            LOGGER.error("Error retrieving tickets per day stats", e);
//        }
//
//        return Collections.emptyList();
//    }

    @NotNull
    public Long getPRTicketCount()
    {
        try
        {
            return theRestTemplate.getForObject(theServerURL + "/stats/totalPRTicketCount", Long.class);
        }
        catch (RestClientException e)
        {
            LOGGER.error("Error retrieving ticket count", e);
        }

        return 0l;
    }

    @NotNull
    public Long getTRTicketCount()
    {
        try
        {
            return theRestTemplate.getForObject(theServerURL + "/stats/totalTRTicketCount", Long.class);
        }
        catch (RestClientException e)
        {
            LOGGER.error("Error retrieving ticket count", e);
        }

        return 0l;
    }

//    @NotNull
//    public Collection<CategoryDistribution> getCategoryModalityDistributions()
//    {
//        try
//        {
//            return theRestTemplate.getForObject(theServerURL + "/stats/categoryModalityDistributions", CategoryDistributions.class).getCounts();
//        }
//        catch (RestClientException e)
//        {
//            LOGGER.error("Error retrieving category & modality distribution counts", e);
//        }
//
//        return Collections.emptyList();
//    }
//
//    public void resendReports(ResendReportRequest resendReportRequest)
//    {
//        theRestTemplate.postForLocation(theServerURL + "/tickets/resendReports", resendReportRequest);
//    }
}
