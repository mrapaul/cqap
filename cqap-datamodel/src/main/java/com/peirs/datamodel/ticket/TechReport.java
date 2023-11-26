package com.peirs.datamodel.ticket;


import com.peirs.datamodel.*;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.*;

public class TechReport
{
    private int theCategory;
    private String theMedicalImageQualityComments;
    private boolean theCriteria1;
    private boolean theCriteria2;
    private boolean theCriteria3;
    private boolean theCriteria4;
    private boolean theCriteria5;
    private String theTechnicalImageQualityComments;
    private String theRecommendation;
    private int theReportQuality;
    @DBRef private User theERP;
    private Date theReportStartedTime;
    private Date theReportCompletedTime;

    public int getCategory()
    {
        return theCategory;
    }

    public void setCategory(int aCategory)
    {
        theCategory = aCategory;
    }

    public String getMedicalImageQualityComments()
    {
        return theMedicalImageQualityComments;
    }

    public void setMedicalImageQualityComments(String aMedicalImageQualityComments)
    {
        theMedicalImageQualityComments = aMedicalImageQualityComments;
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

    public String getTechnicalImageQualityComments()
    {
        return theTechnicalImageQualityComments;
    }

    public void setTechnicalImageQualityComments(String aTechnicalImageQualityComments)
    {
        theTechnicalImageQualityComments = aTechnicalImageQualityComments;
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

    public User getERP()
    {
        return theERP;
    }

    public void setERP(User aERP)
    {
        theERP = aERP;
    }

    public Date getReportStartedTime()
    {
        return theReportStartedTime;
    }

    public void setReportStartedTime(Date aReportStartedTime)
    {
        theReportStartedTime = aReportStartedTime;
    }

    public Date getReportCompletedTime()
    {
        return theReportCompletedTime;
    }

    public void setReportCompletedTime(Date aReportCompletedTime)
    {
        theReportCompletedTime = aReportCompletedTime;
    }
}
