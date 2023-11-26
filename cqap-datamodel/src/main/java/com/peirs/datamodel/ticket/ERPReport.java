package com.peirs.datamodel.ticket;

import com.peirs.datamodel.*;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.*;

public class ERPReport
{
    private int theCategory;
    private String theReportAccuracyComments;
    private boolean theCriteria1;
    private boolean theCriteria2;
    private boolean theCriteria3;
    private boolean theCriteria4;
    private boolean theCriteria5;
    private String theReportQualityComments;
    private String theRecommendation;
    private int theReportQuality;
    private String theAdditionalFactFindings;
    @DBRef private User theERP;
    private SiteCallReport theSiteCallReport;
    private Date theReportTime;

    public int getCategory()
    {
        return theCategory;
    }

    public void setCategory(int aCategory)
    {
        theCategory = aCategory;
    }

    public String getReportAccuracyComments()
    {
        return theReportAccuracyComments;
    }

    public void setReportAccuracyComments(String aReportAccuracyComments)
    {
        theReportAccuracyComments = aReportAccuracyComments;
    }

    public boolean isCriteria1()
    {
        return theCriteria1;
    }

    public void setCriteria1(boolean aCriteria1)
    {
        theCriteria1 = aCriteria1;
    }

    public boolean isCriteria2()
    {
        return theCriteria2;
    }

    public void setCriteria2(boolean aCriteria2)
    {
        theCriteria2 = aCriteria2;
    }

    public boolean isCriteria3()
    {
        return theCriteria3;
    }

    public void setCriteria3(boolean aCriteria3)
    {
        theCriteria3 = aCriteria3;
    }

    public boolean isCriteria4()
    {
        return theCriteria4;
    }

    public void setCriteria4(boolean aCriteria4)
    {
        theCriteria4 = aCriteria4;
    }

    public boolean isCriteria5()
    {
        return theCriteria5;
    }

    public void setCriteria5(boolean aCriteria5)
    {
        theCriteria5 = aCriteria5;
    }

    public String getReportQualityComments()
    {
        return theReportQualityComments;
    }

    public void setReportQualityComments(String aReportQualityComments)
    {
        theReportQualityComments = aReportQualityComments;
    }

    public String getRecommendation()
    {
        return theRecommendation;
    }

    public void setRecommendation(String aRecommendation)
    {
        theRecommendation = aRecommendation;
    }

    public int getReportQuality()
    {
        return theReportQuality;
    }

    public void setReportQuality(int aReportQuality)
    {
        theReportQuality = aReportQuality;
    }

    public String getAdditionalFactFindings()
    {
        return theAdditionalFactFindings;
    }

    public void setAdditionalFactFindings(String aAdditionalFactFindings)
    {
        theAdditionalFactFindings = aAdditionalFactFindings;
    }

    public User getERP()
    {
        return theERP;
    }

    public void setERP(User aERP)
    {
        theERP = aERP;
    }

    public SiteCallReport getSiteCallReport()
    {
        return theSiteCallReport;
    }

    public void setSiteCallReport(SiteCallReport aSiteCallReport)
    {
        theSiteCallReport = aSiteCallReport;
    }

    public Date getReportTime()
    {
        return theReportTime;
    }

    public void setReportTime(Date aReportTime)
    {
        theReportTime = aReportTime;
    }
}
