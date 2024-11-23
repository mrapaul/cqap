package com.lakeland.ris.ui.datamodel;

import com.peirs.datamodel.PACS;


import java.util.*;

import com.lakeland.ris.datamodel.*;


public class ExternalDicomStudyBuilder {
    
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

    public ExternalDicomStudyBuilder() {
        super();

    }



    public ExternalDicomStudyBuilder setStudyId( String studyId) {
        this.studyId = studyId;

        return self();
    }


    public ExternalDicomStudyBuilder setStudyInstanceUID( String studyInstanceUID) {
        this.studyInstanceUID = studyInstanceUID;

        return self();
    }


    public ExternalDicomStudyBuilder setPatientName( String patientName) {
        this.patientName = patientName;

        return self();
    }


    public ExternalDicomStudyBuilder setPatientId( String patientId) {
        this.patientId = patientId;

        return self();
    }


    public ExternalDicomStudyBuilder setStudyDescription( String studyDescription) {
        this.studyDescription = studyDescription;

        return self();
    }


    public ExternalDicomStudyBuilder setAccessionNumber( String accessionNumber) {
        this.accessionNumber = accessionNumber;

        return self();
    }


    public ExternalDicomStudyBuilder setStudyDate( String studyDate) {
        this.studyDate = studyDate;

        return self();
    }


    public ExternalDicomStudyBuilder setStudyTime( String studyTime) {
        this.studyTime = studyTime;

        return self();
    }


    public ExternalDicomStudyBuilder setImageCount(int imageCount) {
        this.imageCount = imageCount;

        return self();
    }


    public ExternalDicomStudyBuilder setPacs( PACS pacs) {
        this.pacs = pacs;

        return self();
    }

    
    protected String getStudyId() {
        return studyId;
    }

    
    protected String getStudyInstanceUID() {
        return studyInstanceUID;
    }

    
    protected String getPatientName() {
        return patientName;
    }

    
    protected String getPatientId() {
        return patientId;
    }

    
    protected String getStudyDescription() {
        return studyDescription;
    }

    
    protected String getAccessionNumber() {
        return accessionNumber;
    }

    
    protected String getStudyDate() {
        return studyDate;
    }

    
    protected String getStudyTime() {
        return studyTime;
    }

    protected int getImageCount() {
        return imageCount;
    }

    public PACS getPacs() {
        return pacs;
    }


    public ExternalDicomStudy build() {
        return new ExternalDicomStudy(getStudyId(),
                getStudyInstanceUID(),
                getPatientName(),
                getPatientId(),
                getStudyDescription(),
                getAccessionNumber(),
                getStudyDate(),
                getStudyTime(),
                getImageCount(),
                getPacs());
    }



    protected ExternalDicomStudyBuilder self() {
        return this;
    }

}