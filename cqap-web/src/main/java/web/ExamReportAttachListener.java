package web;

import com.peirs.datamodel.dicom.*;
import org.jetbrains.annotations.*;

import java.io.*;

public interface ExamReportAttachListener
{
    String uploadPatientReport(@NotNull DicomStudy study, @NotNull File report);
}
