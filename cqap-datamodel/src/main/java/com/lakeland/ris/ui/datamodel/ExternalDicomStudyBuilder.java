package com.lakeland.ris.ui.datamodel;

import com.peirs.datamodel.PACS;
import org.jetbrains.annotations.*;

import java.util.*;

import com.lakeland.ris.datamodel.*;


public class ExternalDicomStudyBuilder {
    @Nullable
    private String studyId;
    @Nullable
    private String studyInstanceUID;
    @Nullable
    private String patientName;
    @Nullable
    private String patientId;
    @Nullable
    private String studyDescription;
    @Nullable
    private String accessionNumber;
    @Nullable
    private String studyDate;
    @Nullable
    private String studyTime;
    private int imageCount;
    @Nullable
    private PACS pacs;

    public ExternalDicomStudyBuilder() {
        super();

    }


    @NotNull
    public ExternalDicomStudyBuilder setStudyId(@Nullable String studyId) {
        this.studyId = studyId;

        return self();
    }

    @NotNull
    public ExternalDicomStudyBuilder setStudyInstanceUID(@Nullable String studyInstanceUID) {
        this.studyInstanceUID = studyInstanceUID;

        return self();
    }

    @NotNull
    public ExternalDicomStudyBuilder setPatientName(@Nullable String patientName) {
        this.patientName = patientName;

        return self();
    }

    @NotNull
    public ExternalDicomStudyBuilder setPatientId(@Nullable String patientId) {
        this.patientId = patientId;

        return self();
    }

    @NotNull
    public ExternalDicomStudyBuilder setStudyDescription(@Nullable String studyDescription) {
        this.studyDescription = studyDescription;

        return self();
    }

    @NotNull
    public ExternalDicomStudyBuilder setAccessionNumber(@Nullable String accessionNumber) {
        this.accessionNumber = accessionNumber;

        return self();
    }

    @NotNull
    public ExternalDicomStudyBuilder setStudyDate(@Nullable String studyDate) {
        this.studyDate = studyDate;

        return self();
    }

    @NotNull
    public ExternalDicomStudyBuilder setStudyTime(@Nullable String studyTime) {
        this.studyTime = studyTime;

        return self();
    }

    @NotNull
    public ExternalDicomStudyBuilder setImageCount(int imageCount) {
        this.imageCount = imageCount;

        return self();
    }

    @NotNull
    public ExternalDicomStudyBuilder setPacs(@Nullable PACS pacs) {
        this.pacs = pacs;

        return self();
    }

    @Nullable
    protected String getStudyId() {
        return studyId;
    }

    @Nullable
    protected String getStudyInstanceUID() {
        return studyInstanceUID;
    }

    @Nullable
    protected String getPatientName() {
        return patientName;
    }

    @Nullable
    protected String getPatientId() {
        return patientId;
    }

    @Nullable
    protected String getStudyDescription() {
        return studyDescription;
    }

    @Nullable
    protected String getAccessionNumber() {
        return accessionNumber;
    }

    @Nullable
    protected String getStudyDate() {
        return studyDate;
    }

    @Nullable
    protected String getStudyTime() {
        return studyTime;
    }

    protected int getImageCount() {
        return imageCount;
    }

    public PACS getPacs() {
        return pacs;
    }

    @NotNull
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


    @NotNull
    protected ExternalDicomStudyBuilder self() {
        return this;
    }

}