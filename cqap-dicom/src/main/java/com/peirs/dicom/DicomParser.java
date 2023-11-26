package com.peirs.dicom;


import com.peirs.datamodel.dicom.DicomImage;
import com.peirs.datamodel.dicom.DicomTag;
import org.dcm4che2.data.DicomElement;
import org.dcm4che2.data.DicomObject;
import org.dcm4che2.data.SpecificCharacterSet;
import org.dcm4che2.data.Tag;
import org.dcm4che2.io.DicomInputStream;
import org.slf4j.*;

import java.io.*;
import java.util.*;

public class DicomParser
{
    private static final Logger LOGGER = LoggerFactory.getLogger(DicomParser.class);

    public DicomImage parse(File aFile)
    {
        try
        {
            return parse(new DicomInputStream(aFile));
        }
        catch (IOException anException)
        {
            LOGGER.error("Error parsing dicom file", anException);
        }

        return new DicomImage();
    }

    public DicomImage parse(DicomInputStream aInputStream)
    {
        DicomImage myImage = new DicomImage();
        try
        {
            DicomObject myObject = aInputStream.readDicomObject();
            if (myObject != null)
            {
                parseImage(myImage, myObject);
                parseFields(myImage, myObject);
            }
        }
        catch (IOException anException)
        {
            LOGGER.error("Error parsing dicom file", anException);
        }
        return myImage;
    }

    public void parseFields(DicomImage aImage, DicomObject aObject)
    {
        SpecificCharacterSet myCharacterSet = aObject.getSpecificCharacterSet();
        Iterator<DicomElement> myIterator = aObject.iterator();

        while (myIterator.hasNext())
        {
            DicomElement myElement = myIterator.next();
            int myTag = myElement.tag();
            String myTagVR = (aObject).vrOf(myTag).toString();
            if (myTagVR.equals("SQ") || myElement.hasDicomObjects())
            {
                DicomObject myObject = myElement.getDicomObject();
                if (myElement.hasItems() && myObject != null)
                {
                    parseFields(aImage, myObject);
                }
            }
            else
            {
                setFields(aImage, aObject, myElement, myTag, myCharacterSet);
            }
        }
    }

    private void setFields(DicomImage aImage,
                           DicomObject aObject,
                           DicomElement aElement,
                           int aTag,
                           SpecificCharacterSet aCharacterSet)
    {
        DicomTag myTag = new DicomTag();
        int myDicomTag = aElement.tag();
        String myValue = extractString(aObject, aElement, aTag, aCharacterSet);
        myTag.setDicomTag(myDicomTag);
        myTag.setDicomTagName(aObject.nameOf(aTag));
        myTag.setValue(myValue != null ? myValue.trim() : myValue);
        aImage.addTag(myTag);
        switch (myDicomTag)
        {
            case Tag.StudyID:
            {
                aImage.setStudyId(myValue);

                break;
            }
            case Tag.StudyDate:
            {
                aImage.setStudyDate(myValue);

                break;
            }
            case Tag.PatientName:
            {
                aImage.setPatientName(myValue);

                break;
            }
            case Tag.PatientID:
            {
                aImage.setPatientID(myValue);

                break;
            }
            case Tag.PatientBirthDate:
            {
                aImage.setPatientBirthDate(myValue);

                break;
            }
            case Tag.PatientSex:
            {
                aImage.setPatientSex(myValue);

                break;
            }
            case Tag.AccessionNumber:
            {
                if (aImage.getAccessionNumber() == null || aImage.getAccessionNumber().isEmpty())
                {
                    aImage.setAccessionNumber(myValue);
                }

                break;
            }
            case Tag.Modality:
            {
                aImage.setModality(myValue);

                break;
            }
            case Tag.StudyDescription:
            {
                aImage.setStudyDescription(myValue);

                break;
            }
            case Tag.InstitutionName:
            {
                aImage.addInstitution(myValue);

                break;
            }
            case Tag.InstitutionalDepartmentName:
            {
                aImage.setInstitutionalDepartmentName(myValue);

                break;
            }
            case Tag.ScheduledProcedureStepDescription:
            {
                if (aImage.getScheduledProcedureStepDescription() == null || aImage
                        .getScheduledProcedureStepDescription().isEmpty())
                {
                    aImage.setScheduledProcedureStepDescription(myValue);
                }

                break;
            }
            case Tag.OperatorsName:
            {
                aImage.setOperatorName(myValue);

                break;
            }
            case Tag.StudyInstanceUID:
            {
                aImage.setStudyInstanceUID(myValue);

                break;
            }
            case Tag.SeriesInstanceUID:
            {
                aImage.setSeriesInstanceUID(myValue);

                break;
            }
            case Tag.AdditionalPatientHistory:
            {

//                if (aImage.add() == null || aImage.getPatientHistory().isEmpty())
//                {
//                    aImage.setPatientHistory(myValue);
//                }

                break;
            }
            case Tag.ReasonForStudy:
            {
//                if (aImage.getPatientHistory() == null || aImage.getPatientHistory().isEmpty())
//                {
//                    aImage.setPatientHistory(myValue);
//                }

                break;
            }
        }
    }

    private String extractString(DicomObject aObject,
                                 DicomElement aElement,
                                 int aTag,
                                 SpecificCharacterSet aCharacterSet)
    {
        return aObject.vrOf(aTag).toString(aElement.getBytes(), true, aCharacterSet);
    }

    private void parseImage(DicomImage aObject, DicomObject aImage)
    {
        aImage.remove(Tag.PixelData);
        aImage.remove(Tag.RequestAttributesSequence);
    }
}

