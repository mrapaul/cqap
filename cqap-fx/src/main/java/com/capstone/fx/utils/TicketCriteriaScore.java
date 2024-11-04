package com.capstone.fx.utils;

import com.peirs.datamodel.ticket.*;

public final class TicketCriteriaScore
{
    public static String getTechReportCriteriaScore(boolean aReportedCriteria, TechTicketQualityCriteria aCriteria)
    {
        return aReportedCriteria ? aCriteria.getScore() + "/" + aCriteria.getScore() : "0/" + aCriteria.getScore();
    }

}
