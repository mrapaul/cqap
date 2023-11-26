package com.peirs.datamodel.ticket;

public enum TechTicketQualityCriteria
{
    CRITERIA1("1. The examination protocol was followed?", 20),
    CRITERIA2("2. The patient was properly positioned for imaging?", 20),
    CRITERIA3("3. The are no technical artifacts present?", 20),
    CRITERIA4("4. Patient demographics and other identifying patient information are accurate?", 20),
    CRITERIA5("5. Markers and/or other notations for position are present?", 20);

    private final String theCriteriaDescription;
    private final int theScore;

    private TechTicketQualityCriteria(String aCriteriaDescription, int aScore)
    {
        theCriteriaDescription = aCriteriaDescription;
        theScore = aScore;
    }

    public String getCriteriaDescription()
    {
        return theCriteriaDescription;
    }

    public int getScore()
    {
        return theScore;
    }
}
