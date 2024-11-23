package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class ReportTemplates
{
    private Collection<ReportTemplate> templates;

    public ReportTemplates()
    {
        // empty
    }

    @JsonCreator
    public ReportTemplates(Collection<ReportTemplate> templates)
    {
        super();

        this.templates = templates;
    }


    public Collection<ReportTemplate> getTemplates()
    {
        return templates;
    }
    public void setTemplates(Collection<ReportTemplate> templates)
    {
        this.templates = templates;
    }


    public String toString()
    {
        return "ReportTemplates(" +
            " templates: " + getTemplates() + ")";
    }


    @Override
    public boolean equals( Object aObject)
    {
          if (this == aObject)
          {
              return true;
          }

          if (aObject == null || getClass() != aObject.getClass())
          {
              return false;
          }

          final ReportTemplates myObject = (ReportTemplates) aObject;

          return Objects.equals(getTemplates(), myObject.getTemplates());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(
                            getTemplates());
    }


    public ReportTemplatesBuilder toBuilder()
    {
        return new ReportTemplatesBuilder(getTemplates());
    }
}