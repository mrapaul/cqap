package com.peirs.datamodel.ticket;

public enum ProfessionalTicketCategory
{
    CATEGORY_1(1, Constants.CATEGORY_1_DESC, 100),
    CATEGORY_2(2, Constants.CATEGORY_2_DESC, 75),
    CATEGORY_3(3, Constants.CATEGORY_3_DESC, 50),
    CATEGORY_4(4, Constants.CATEGORY_4_DESC, 25),
    CATEGORY_5(5, Constants.CATEGORY_5_DESC, 0);

    private final int theCode;
    private final String theDescription;
    private final int theScore;

    ProfessionalTicketCategory(int aCode, String aDescription, int aScore)
    {
        theCode = aCode;
        theDescription = aDescription;
        theScore = aScore;
    }

    public int getCode()
    {
        return theCode;
    }

    public String getDescription()
    {
        return theDescription;
    }

    public int getScore()
    {
        return theScore;
    }

    public static ProfessionalTicketCategory lookup(int aCode)
    {
        switch (aCode)
        {
            case 1:
            {
                return CATEGORY_1;
            }
            case 2:
            {
                return CATEGORY_2;
            }
            case 3:
            {
                return CATEGORY_3;
            }
            case 4:
            {
                return CATEGORY_4;
            }
            case 5:
            {
                return CATEGORY_5;
            }
        }

        return null;
    }

    public static ProfessionalTicketCategory lookup(String aDescription)
    {
        switch (aDescription)
        {
            case Constants.CATEGORY_1_DESC:
            {
                return CATEGORY_1;
            }
            case Constants.CATEGORY_2_DESC:
            {
                return CATEGORY_2;
            }
            case Constants.CATEGORY_3_DESC:
            {
                return CATEGORY_3;
            }
            case Constants.CATEGORY_4_DESC:
            {
                return CATEGORY_4;
            }
            case Constants.CATEGORY_5_DESC:
            {
                return CATEGORY_5;
            }
        }

        return null;
    }

    @Override public String toString()
    {
        return getDescription();
    }

    private static class Constants
    {
        private static final
        String CATEGORY_5_DESC =
                "5. Sentinel event - event that may cause a serious unexpected or unanticipated outcome, death or serious physical or psychological injury, or the risk thereof";
        private static final
        String CATEGORY_4_DESC =
                "4. Interpretation variance - variance is, or would be expected to directly affect patient care and/or outcome";
        private static final
        String
                CATEGORY_3_DESC =
                "3. Interpretation variance - variance may affect patient care and/or outcome or require further assessment";
        private static final
        String
                CATEGORY_2_DESC =
                "2. Interpretation variance - variance is unlikely to affect patient care and/or outcome";
        private static final
        String
                CATEGORY_1_DESC =
                "1. No variance - Expert reviewer agrees with primary interpretation";
    }
}
