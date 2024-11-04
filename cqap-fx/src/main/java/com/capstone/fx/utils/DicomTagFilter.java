package com.capstone.fx.utils;

import com.peirs.datamodel.dicom.*;
import javafx.scene.control.*;

import java.util.*;

public class DicomTagFilter
{
    public static void filter(List<DicomTag> aTags, String aFilter, List<DicomTag> aResult, TableView<DicomTag> aTableView)
    {
        aResult.clear();

        for (DicomTag myTag : aTags)
        {
            if (matchesFilter(myTag, aFilter))
            {
                aResult.add(myTag);
            }
        }
        reapplyTableSortOrder(aTableView);

    }

    public static boolean matchesFilter(DicomTag aTag, String aFilterText)
    {
        if (aFilterText == null || aFilterText.isEmpty())
        {
            return true;
        }

        String lowerCaseFilterString = aFilterText.toLowerCase();
        if (aTag.getDicomTagName() != null && aTag.getDicomTagName().toLowerCase().contains(lowerCaseFilterString))
        {
            return true;
        }
        else if (aTag.getValue() != null && aTag.getValue().toLowerCase().contains(lowerCaseFilterString))
        {
            return true;
        }

        return false;
    }

    private static void reapplyTableSortOrder(TableView<DicomTag> aTableView)
    {
        ArrayList<TableColumn<DicomTag, ?>> sortOrder = new ArrayList<>(aTableView.getSortOrder());
        aTableView.getSortOrder().clear();
        aTableView.getSortOrder().addAll(sortOrder);
    }

}
