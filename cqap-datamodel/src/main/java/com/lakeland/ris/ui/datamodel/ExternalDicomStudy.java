package com.lakeland.ris.ui.datamodel;

import com.peirs.datamodel.PACS;
import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;

import java.util.*;

import com.lakeland.ris.datamodel.*;


public class ExternalDicomStudy {
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

    private PACS pacs;

    public ExternalDicomStudy() {
        // empty
    }

    @JsonCreator
    public ExternalDicomStudy(@Nullable String studyId,
                              @Nullable String studyInstanceUID,
                              @Nullable String patientName,
                              @Nullable String patientId,
                              @Nullable String studyDescription,
                              @Nullable String accessionNumber,
                              @Nullable String studyDate,
                              @Nullable String studyTime,
                              int imageCount,
                              @Nullable PACS pacs) {
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

    @Nullable
    public String getStudyId() {
        return studyId;
    }

    @Nullable
    public String getStudyInstanceUID() {
        return studyInstanceUID;
    }

    @Nullable
    public String getPatientName() {
        return patientName;
    }

    @Nullable
    public String getPatientId() {
        return patientId;
    }

    @Nullable
    public String getStudyDescription() {
        return studyDescription;
    }

    @Nullable
    public String getAccessionNumber() {
        return accessionNumber;
    }

    @Nullable
    public String getStudyDate() {
        return studyDate;
    }

    @Nullable
    public String getStudyTime() {
        return studyTime;
    }

    public int getImageCount() {
        return imageCount;
    }

    public void setStudyId(@Nullable String studyId) {
        this.studyId = studyId;
    }

    public void setStudyInstanceUID(@Nullable String studyInstanceUID) {
        this.studyInstanceUID = studyInstanceUID;
    }

    public void setPatientName(@Nullable String patientName) {
        this.patientName = patientName;
    }

    public void setPatientId(@Nullable String patientId) {
        this.patientId = patientId;
    }

    public void setStudyDescription(@Nullable String studyDescription) {
        this.studyDescription = studyDescription;
    }

    public void setAccessionNumber(@Nullable String accessionNumber) {
        this.accessionNumber = accessionNumber;
    }

    public void setStudyDate(@Nullable String studyDate) {
        this.studyDate = studyDate;
    }

    public void setStudyTime(@Nullable String studyTime) {
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

    @NotNull
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

    @NotNull
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