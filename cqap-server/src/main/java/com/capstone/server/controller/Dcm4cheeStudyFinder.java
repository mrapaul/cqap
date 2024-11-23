package com.capstone.server.controller;


import com.google.common.collect.Lists;
import com.peirs.datamodel.PACS;
import org.dcm4che2.data.DicomObject;
import org.dcm4che2.data.Tag;
import org.dcm4che2.net.ConfigurationException;
import org.dcm4che2.tool.dcmqr.DcmQR;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Component("Dcm4cheeStudyFinder")
public class Dcm4cheeStudyFinder
{
    private final DateFormat dateFormat;

    public Dcm4cheeStudyFinder()
    {
        dateFormat = new SimpleDateFormat("yyyyMMdd");
    }

    public List<DicomObject> query(PACS pacs, Date studyDate) throws InterruptedException, IOException,
    ConfigurationException
    {
        DcmQR basicQuery = new DcmQR("BasicQuery");
        basicQuery.setRemoteHost(pacs.getHost());
        basicQuery.setRemotePort(pacs.getPort());
        basicQuery.setCalledAET(pacs.getAeTitle(), true);
        basicQuery.setDateTimeMatching(true);
        basicQuery.setCFind(true);
        basicQuery.configureTransferCapability(true);
        basicQuery.setQueryLevel(DcmQR.QueryRetrieveLevel.STUDY);
        basicQuery.addReturnKey(new int[]{Tag.NumberOfStudyRelatedInstances});
        basicQuery.addReturnKey(new int[]{Tag.AccessionNumber});
        basicQuery.addReturnKey(new int[]{Tag.PatientName});
        basicQuery.addReturnKey(new int[]{Tag.PatientID});
        basicQuery.addReturnKey(new int[]{Tag.StudyInstanceUID});
        basicQuery.addReturnKey(new int[]{Tag.StudyDescription});
        basicQuery.addReturnKey(new int[]{Tag.StudyID});
        basicQuery.addReturnKey(new int[]{Tag.StudyDate});
        basicQuery.addReturnKey(new int[]{Tag.StudyTime});
        basicQuery.addReturnKey(new int[]{Tag.StudyID});

        List<DicomObject> results = Lists.newArrayList();
        if (studyDate != null)
        {
            Calendar calendar = new GregorianCalendar();
            if (studyDate != null)
            {
                calendar.setTime(studyDate);
            }
            Date today = calendar.getTime();
            calendar.add(Calendar.DATE, -1);
            Date yesterday = calendar.getTime();
            basicQuery.start();
            basicQuery.open();
            basicQuery.addMatchingKey(Tag.toTagPath("StudyDate"), dateFormat.format(yesterday));
            results.addAll(basicQuery.query());
            basicQuery.addMatchingKey(Tag.toTagPath("StudyDate"), dateFormat.format(today));
            results.addAll(basicQuery.query());
        }
        else
        {
            basicQuery.start();
            basicQuery.open();
            results.addAll(basicQuery.query());
        }
        basicQuery.stop();
        basicQuery.close();

        return results;
    }

    public List<DicomObject> detailedQuery(PACS pacs, String accession) throws IOException, InterruptedException, ConfigurationException
    {
        DcmQR detailedQuery = new DcmQR("DetailedQuery");
        configurePACS(detailedQuery, pacs);
        detailedQuery.setDateTimeMatching(true);
        detailedQuery.setCFind(true);
        detailedQuery.configureTransferCapability(true);
        detailedQuery.setQueryLevel(DcmQR.QueryRetrieveLevel.SERIES);
        detailedQuery.addReturnKey(new int[]{Tag.StudyDescription});
        detailedQuery.addReturnKey(new int[]{Tag.ReasonForStudy});
        detailedQuery.addReturnKey(new int[]{Tag.StudyArrivalDate});
        detailedQuery.addReturnKey(new int[]{Tag.StudyArrivalTime});
        detailedQuery.addReturnKey(new int[]{Tag.StudyDate});
        detailedQuery.addReturnKey(new int[]{Tag.StudyTime});
        detailedQuery.addReturnKey(new int[]{Tag.ReferringPhysicianName});
        detailedQuery.addReturnKey(new int[]{Tag.PerformingPhysicianName});
        detailedQuery.addReturnKey(new int[]{Tag.PatientBirthDate});
        detailedQuery.addReturnKey(new int[]{Tag.PatientID});
        detailedQuery.addReturnKey(new int[]{Tag.Modality});
        detailedQuery.addReturnKey(new int[]{Tag.ScheduledProcedureStepDescription});
        detailedQuery.addReturnKey(new int[]{Tag.RequestedProcedureDescription});
        detailedQuery.addReturnKey(new int[]{Tag.PatientSex});
        detailedQuery.addReturnKey(new int[]{Tag.InstitutionName});
        detailedQuery.addReturnKey(new int[]{Tag.StudyID});
        detailedQuery.addReturnKey(new int[]{Tag.StudyInstanceUID});
        detailedQuery.addReturnKey(new int[]{Tag.NumberOfStudyRelatedInstances});
        detailedQuery.addReturnKey(new int[]{Tag.AccessionNumber});
        detailedQuery.addReturnKey(new int[]{Tag.PatientName});
        detailedQuery.addReturnKey(new int[]{Tag.OperatorsName});
        detailedQuery.addReturnKey(new int[]{Tag.SeriesInstanceUID});
        detailedQuery.addReturnKey(new int[]{Tag.AdmittingDiagnosesDescription});
        detailedQuery.start();
        detailedQuery.open();
        detailedQuery.addMatchingKey(Tag.toTagPath("AccessionNumber"), accession);
        List<DicomObject> dicomObjects = detailedQuery.query();
        detailedQuery.stop();
        detailedQuery.close();

        return dicomObjects;
    }

    private void configurePACS(DcmQR detailedQuery, PACS pacs)
    {
        detailedQuery.setRemoteHost(pacs.getHost());
        detailedQuery.setRemotePort(pacs.getPort());
        detailedQuery.setCalledAET(pacs.getAeTitle(), true);
    }
}
