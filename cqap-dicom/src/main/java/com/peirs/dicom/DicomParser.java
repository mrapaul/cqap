package com.peirs.dicom;

import com.peirs.datamodel.dicom.*;
import org.dcm4che2.data.*;
import org.dcm4che2.io.*;
import org.slf4j.*;

import java.io.*;
import java.util.*;

public class DicomParser
{
    private static final Logger LOGGER = LoggerFactory.getLogger(DicomParser.class);

    public DicomImage parse(File aFile)
    {
        DicomImage myImage = new DicomImage();
        try (DicomInputStream myInputStream = new DicomInputStream(aFile))
        {
            DicomObject myObject = myInputStream.readDicomObject();
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

    private void parseFields(DicomImage aImage, DicomObject aObject)
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
                aImage.setAccessionNumber(myValue);

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
                aImage.setScheduledProcedureStepDescription(myValue);

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
        //            DicomElement myImageElement = myObject.get(Tag.PixelData);
        aImage.remove(Tag.PixelData);
    }
}
