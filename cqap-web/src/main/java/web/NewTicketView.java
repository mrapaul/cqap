package web;

import com.lakeland.ris.ui.datamodel.*;
import com.peirs.datamodel.*;
import com.peirs.datamodel.dicom.*;
import com.peirs.datamodel.ticket.*;
import com.vaadin.data.*;
import com.vaadin.navigator.*;


import java.io.*;
import java.util.*;

public interface NewTicketView extends View
{
    void setListener(Listener listener);

    void setContainers(Container queryResults,
                       Container groups,
                       Container institutions,
                       Container pirs,
                       Container sts,
                       Container pacsContainer,
                       Container externalImagesContainer,
                       Container internalImagesContainer);

    void displayCreateResult(String result);

    void displayStudy(DicomStudy study, Collection<DicomStudy> relatedExams, Listener listener);

    void editNewPACS(String pacsId);

    interface Listener extends ExamReportAttachListener
    {

        void query(DicomStudyQuery query);

        void reset();

        void createTickets(Set<DicomStudyQueryResult> images,
                           Set<TicketType> types,
                           TicketPriority priority,
                           Boolean submittedVariance);

        void editStudy(DicomStudyQueryResult image);

        String uploadFile(File file);

        void saveStudy(DicomStudy study);

        void refreshExternalImages(PACS pacs, Date value);

        void importImage(PACS pacs, ExternalDicomStudy externalDicomStudy);

        void searchForInternalImagesForExternalImage(ExternalDicomStudy externalDicomStudy);

        void newPACSSelected();

        void savePACS(PACS pacs);

        void deletePACS(PACS pacs);

        void addPACS();

        void refreshPACS();

        void filter(String text);
    }
}
