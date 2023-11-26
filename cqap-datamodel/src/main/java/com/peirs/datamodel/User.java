package com.peirs.datamodel;

import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.*;

@Document(collection = "Users")
public class User
{
    @Id private String theId;
    private String theName;
    private String theUsername;
    private String thePosition;
    private Role theRole;
    @DBRef private List<Institution> theInstitutions;
    @DBRef private Group theGroup;
    private Address theAddress;
    private Phone theCellPhoneNumber;
    private Phone thePhoneNumber;
    private Phone theFaxNumber;
    private Email theEmail;
    private TicketPriorities theTicketPriorities;
    private NotificationPreference theNotificationPreference;
    private CompletedNotification theCompletedNotification;
    private String theAlias;
    private Set<String> theCPTPrimarySpecialities;
    private Set<String> theCPTSecondarySpecialities;
    private OsirixConfiguration theOsirixConfiguration;
    private String theRadiologistID;
    private String theRadiologistNPI;

    public String getId()
    {
        return theId;
    }

    public void setId(String aId)
    {
        theId = aId;
    }

    public String getName()
    {
        return theName;
    }

    public void setName(String aName)
    {
        theName = aName;
    }

    public String getUsername()
    {
        return theUsername;
    }

    public void setUsername(String aUsername)
    {
        theUsername = aUsername;
    }

    public String getPosition()
    {
        return thePosition;
    }

    public void setPosition(String aPosition)
    {
        thePosition = aPosition;
    }

    public Role getRole()
    {
        return theRole;
    }

    public void setRole(Role aRole)
    {
        theRole = aRole;
    }

    public List<Institution> getInstitutions()
    {
        return theInstitutions;
    }

    public void setInstitutions(List<Institution> aInstitutions)
    {
        theInstitutions = aInstitutions;
    }

    public Group getGroup()
    {
        return theGroup;
    }

    public void setGroup(Group aGroup)
    {
        theGroup = aGroup;
    }

    @Override
    public String toString()
    {
        return theName;
    }

    public Address getAddress()
    {
        return theAddress;
    }

    public void setAddress(Address aAddress)
    {
        theAddress = aAddress;
    }

    public Phone getCellPhoneNumber()
    {
        return theCellPhoneNumber;
    }

    public void setCellPhoneNumber(Phone aCellPhoneNumber)
    {
        theCellPhoneNumber = aCellPhoneNumber;
    }

    public Phone getPhoneNumber()
    {
        return thePhoneNumber;
    }

    public void setPhoneNumber(Phone aPhoneNumber)
    {
        thePhoneNumber = aPhoneNumber;
    }

    public Phone getFaxNumber()
    {
        return theFaxNumber;
    }

    public void setFaxNumber(Phone aFaxNumber)
    {
        theFaxNumber = aFaxNumber;
    }

    public Email getEmail()
    {
        return theEmail;
    }

    public void setEmail(Email aEmail)
    {
        theEmail = aEmail;
    }

    public TicketPriorities getTicketPriorities()
    {
        return theTicketPriorities;
    }

    public void setTicketPriorities(TicketPriorities aTicketPriorities)
    {
        theTicketPriorities = aTicketPriorities;
    }

    public NotificationPreference getNotificationPreference()
    {
        return theNotificationPreference;
    }

    public void setNotificationPreference(NotificationPreference aNotificationPreference)
    {
        theNotificationPreference = aNotificationPreference;
    }

    public CompletedNotification getCompletedNotification()
    {
        return theCompletedNotification;
    }

    public void setCompletedNotification(CompletedNotification aCompletedNotification)
    {
        theCompletedNotification = aCompletedNotification;
    }

    public String getAlias()
    {
        return theAlias;
    }

    public void setAlias(String aAlias)
    {
        theAlias = aAlias;
    }

    public Set<String> getCPTPrimarySpecialities()
    {
        return theCPTPrimarySpecialities;
    }

    public void setCPTPrimarySpecialities(Set<String> aCPTPrimarySpecialities)
    {
        theCPTPrimarySpecialities = aCPTPrimarySpecialities;
    }

    public Set<String> getCPTSecondarySpecialities()
    {
        return theCPTSecondarySpecialities;
    }

    public void setCPTSecondarySpecialities(Set<String> aCPTSecondarySpecialities)
    {
        theCPTSecondarySpecialities = aCPTSecondarySpecialities;
    }

    public OsirixConfiguration getOsirixConfiguration()
    {
        return theOsirixConfiguration;
    }

    public void setOsirixConfiguration(OsirixConfiguration aOsirixConfiguration)
    {
        theOsirixConfiguration = aOsirixConfiguration;
    }

    public String getRadiologistNPI()
    {
        return theRadiologistNPI;
    }

    public void setRadiologistNPI(String aRadiologistNPI)
    {
        this.theRadiologistNPI = aRadiologistNPI;
    }

    public String getRadiologistID()
    {
        return theRadiologistID;
    }

    public void setRadiologistID(String aRadiologistID)
    {
        this.theRadiologistID = aRadiologistID;
    }
}
