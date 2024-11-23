package web;

import com.peirs.datamodel.dicom.*;


import java.io.*;

public interface ExamReportAttachListener
{
    String uploadPatientReport(DicomStudy study, File report);
}
