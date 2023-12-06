package web;

import com.lakeland.ris.ui.datamodel.*;
import com.peirs.datamodel.*;
import com.peirs.datamodel.dicom.*;
import com.peirs.datamodel.ticket.*;
import com.vaadin.data.*;
import com.vaadin.navigator.*;
import org.jetbrains.annotations.*;

import java.io.*;
import java.util.*;

public interface NewTicketView extends View
{
    void setListener(Listener listener);

    void setContainers(@NotNull Container queryResults,
                       @NotNull Container groups,
                       @NotNull Container institutions,
                       @NotNull Container pirs,
                       @NotNull Container sts,
                       @NotNull Container pacsContainer,
                       @NotNull Container externalImagesContainer,
                       @NotNull Container internalImagesContainer);

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

        void savePACS(@NotNull PACS pacs);

        void deletePACS(@NotNull PACS pacs);

        void addPACS();

        void refreshPACS();

        void filter(String text);
    }
}
