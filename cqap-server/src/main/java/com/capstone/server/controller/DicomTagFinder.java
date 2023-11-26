package com.capstone.server.controller;

import com.peirs.datamodel.dicom.*;

public final class DicomTagFinder
{
    public static DicomTag find(DicomStudy aStudy, int aTag)
    {
        if (aStudy.getTags() != null)
        {
            for (DicomTag myTag : aStudy.getTags())
            {
                if (myTag.getDicomTag() == aTag)
                {
                    return myTag;
                }
            }
        }

        return null;
    }
}

