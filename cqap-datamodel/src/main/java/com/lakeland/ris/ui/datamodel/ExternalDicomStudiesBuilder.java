package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class ExternalDicomStudiesBuilder
{
    @NotNull private Collection<ExternalDicomStudy> studies;

    public ExternalDicomStudiesBuilder(@NotNull Collection<ExternalDicomStudy> studies)
    {
        super();

        this.studies = studies;
    }


    @NotNull
    public ExternalDicomStudiesBuilder setStudies(@NotNull Collection<ExternalDicomStudy> studies)
    {
        this.studies = studies;

        return self();
    }

    @NotNull
    protected Collection<ExternalDicomStudy> getStudies()
    {
        return studies;
    }

    @NotNull
    public ExternalDicomStudies build()
    {
        return new ExternalDicomStudies(getStudies());
    }


    @NotNull
    protected ExternalDicomStudiesBuilder self()
    {
        return this;
    }
}