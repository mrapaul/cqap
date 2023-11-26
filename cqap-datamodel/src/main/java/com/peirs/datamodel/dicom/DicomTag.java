package com.peirs.datamodel.dicom;

public class DicomTag
{
    public int dicomTag;
    public String dicomTagName;
    public String value;

    public DicomTag()
    {
        // empty
    }

    public int getDicomTag()
    {
        return dicomTag;
    }

    public void setDicomTag(int aDicomTag)
    {
        dicomTag = aDicomTag;
    }

    public String getDicomTagName()
    {
        return dicomTagName;
    }

    public void setDicomTagName(String aDicomTagName)
    {
        dicomTagName = aDicomTagName;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String aValue)
    {
        value = aValue;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        DicomTag myTag = (DicomTag) o;

        if (dicomTag != myTag.dicomTag)
        {
            return false;
        }
        if (!dicomTagName.equals(myTag.dicomTagName))
        {
            return false;
        }
        if (value != null ? !value.equals(myTag.value) : myTag.value != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int myresult = dicomTag;
        myresult = 31 * myresult + dicomTagName.hashCode();
        myresult = 31 * myresult + (value != null ? value.hashCode() : 0);
        return myresult;
    }

    @Override
    public String toString() {
        return "DicomTag{" +
                "dicomTag=" + dicomTag +
                ", dicomTagName='" + dicomTagName + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
