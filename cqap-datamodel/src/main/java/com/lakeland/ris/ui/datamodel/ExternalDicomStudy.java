package com.lakeland.ris.ui.datamodel;

import com.peirs.datamodel.PACS;
import org.codehaus.jackson.annotate.*;


import java.util.*;

import com.lakeland.ris.datamodel.*;


public class ExternalDicomStudy {
    
    private String studyId;
    
    private String studyInstanceUID;
    
    private String patientName;
    
    private String patientId;
    
    private String studyDescription;
    
    private String accessionNumber;
    
    private String studyDate;
    
    private String studyTime;
    private int imageCount;

    private PACS pacs;

    public ExternalDicomStudy() {
        // empty
    }

    @JsonCreator
    public ExternalDicomStudy( String studyId,
                               String studyInstanceUID,
                               String patientName,
                               String patientId,
                               String studyDescription,
                               String accessionNumber,
                               String studyDate,
                               String studyTime,
                              int imageCount,
                               PACS pacs) {
        super();

        this.studyId = studyId;
        this.studyInstanceUID = studyInstanceUID;
        this.patientName = patientName;
        this.patientId = patientId;
        this.studyDescription = studyDescription;
        this.accessionNumber = accessionNumber;
        this.studyDate = studyDate;
        this.studyTime = studyTime;
        this.imageCount = imageCount;
        this.pacs = pacs;
    }

    
    public String getStudyId() {
        return studyId;
    }

    
    public String getStudyInstanceUID() {
        return studyInstanceUID;
    }

    
    public String getPatientName() {
        return patientName;
    }

    
    public String getPatientId() {
        return patientId;
    }

    
    public String getStudyDescription() {
        return studyDescription;
    }

    
    public String getAccessionNumber() {
        return accessionNumber;
    }

    
    public String getStudyDate() {
        return studyDate;
    }

    
    public String getStudyTime() {
        return studyTime;
    }

    public int getImageCount() {
        return imageCount;
    }

    public void setStudyId( String studyId) {
        this.studyId = studyId;
    }

    public void setStudyInstanceUID( String studyInstanceUID) {
        this.studyInstanceUID = studyInstanceUID;
    }

    public void setPatientName( String patientName) {
        this.patientName = patientName;
    }

    public void setPatientId( String patientId) {
        this.patientId = patientId;
    }

    public void setStudyDescription( String studyDescription) {
        this.studyDescription = studyDescription;
    }

    public void setAccessionNumber( String accessionNumber) {
        this.accessionNumber = accessionNumber;
    }

    public void setStudyDate( String studyDate) {
        this.studyDate = studyDate;
    }

    public void setStudyTime( String studyTime) {
        this.studyTime = studyTime;
    }

    public void setImageCount(int imageCount) {
        this.imageCount = imageCount;
    }

    public PACS getPacs() {
        return pacs;
    }

    public void setPacs(PACS pacs) {
        this.pacs = pacs;
    }


    public String toString() {
        return "ExternalDicomStudy(" +
                " studyId: " + getStudyId() +
                " studyInstanceUID: " + getStudyInstanceUID() +
                " patientName: " + getPatientName() +
                " patientId: " + getPatientId() +
                " studyDescription: " + getStudyDescription() +
                " accessionNumber: " + getAccessionNumber() +
                " studyDate: " + getStudyDate() +
                " studyTime: " + getStudyTime() +
                " imageCount: " + getImageCount() +
                " pacs: " + getPacs() + ")";
    }


    public ExternalDicomStudyBuilder toBuilder() {
        return new ExternalDicomStudyBuilder().setStudyId(getStudyId())
                .setStudyInstanceUID(getStudyInstanceUID())
                .setPatientName(getPatientName())
                .setPatientId(getPatientId())
                .setStudyDescription(getStudyDescription())
                .setAccessionNumber(getAccessionNumber())
                .setStudyDate(getStudyDate())
                .setStudyTime(getStudyTime())
                .setImageCount(getImageCount())
                .setPacs(getPacs());
    }
}