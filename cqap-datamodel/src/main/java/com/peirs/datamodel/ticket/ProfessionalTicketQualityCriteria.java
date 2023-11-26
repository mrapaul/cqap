package com.peirs.datamodel.ticket;

public enum ProfessionalTicketQualityCriteria
{
    CRITERIA1("1. The report includes a conclusion or impression?", 25),
    CRITERIA2("2. The report addresses clinical history and/or symptoms or provides differential diagnosis?", 25),
    CRITERIA3("3. The report addresses the relevant positive and/or negative findings?", 25),
    CRITERIA4("4. The report is organized in a structured format?", 20),
    CRITERIA5("5. The report text contains no errors that would impact patient care or outcome?", 5);

    private final String theCriteriaDescription;
    private final int theScore;

    private ProfessionalTicketQualityCriteria(String aCriteriaDescription, int aScore)
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
