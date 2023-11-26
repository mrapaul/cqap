package com.capstone.server.controller;

import ch.lambdaj.function.convert.*;
import com.lakeland.ris.ui.datamodel.*;
import com.peirs.datamodel.PACS;
import org.dcm4che2.data.*;
import org.jetbrains.annotations.*;

public class DicomObjectToExternalDicomStudyConverter implements Converter<DicomObject, ExternalDicomStudy>
{
    @Override public ExternalDicomStudy convert(DicomObject from)
    {
        DicomElement imageCountElement = from.get(Tag.NumberOfStudyRelatedInstances);

        return new ExternalDicomStudy(getValue(from, Tag.StudyID),
                getValue(from, Tag.StudyInstanceUID),
                getValue(from, Tag.PatientName),
                getValue(from, Tag.PatientID),
                getValue(from, Tag.StudyDescription),
                getValue(from, Tag.AccessionNumber),
                getValue(from, Tag.StudyDate),
                getValue(from, Tag.StudyTime),
                imageCountElement.getInt(true),
                new PACS());
    }

    @Nullable
    private String getValue(DicomObject object, int tag)
    {
        DicomElement dicomElement = object.get(tag);

        return dicomElement != null ? dicomElement.getString(object.getSpecificCharacterSet(), true) : null;
    }
}
