package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class ExternalDicomStudies
{
    @NotNull private Collection<ExternalDicomStudy> studies;

    public ExternalDicomStudies()
    {
        // empty
    }

    @JsonCreator
    public ExternalDicomStudies(@NotNull Collection<ExternalDicomStudy> studies)
    {
        super();

        this.studies = studies;
    }

    @NotNull
    public Collection<ExternalDicomStudy> getStudies()
    {
        return studies;
    }
    public void setStudies(@NotNull Collection<ExternalDicomStudy> studies)
    {
        this.studies = studies;
    }

    @NotNull
    public String toString()
    {
        return "ExternalDicomStudies(" +
            " studies: " + getStudies() + ")";
    }

    @NotNull
    public ExternalDicomStudiesBuilder toBuilder()
    {
        return new ExternalDicomStudiesBuilder(getStudies());
    }
}