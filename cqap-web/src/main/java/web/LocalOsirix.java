package web;

import com.vaadin.ui.*;
import org.apache.xmlrpc.*;


public class LocalOsirix
{
    private static final String OSIRIX_WINDOW_NAME = "osirix";
    private static final String DISPLAY_STUDY_URL = "osirix://?methodName=DisplayStudy&StudyInstanceUID=%s";
    private static final String DOWNLOAD_STUDY_URL = "osirix://?methodName=retrieve&serverName=DCM4CHEE&filterKey=StudyInstanceUID&filterValue=%s";
    private static final String CLOSE_STUDY_URL = "osirix://?methodName=CloseAllWindows";

    public static void openImageWithStudyInstanceUID(String studyInstanceUID) throws XmlRpcException
    {
        UI.getCurrent().getPage().open(String.format(DISPLAY_STUDY_URL, studyInstanceUID), OSIRIX_WINDOW_NAME);
    }

    public static void downloadImages(String studyInstanceUID) throws XmlRpcException
    {
        UI.getCurrent().getPage().open(String.format(DOWNLOAD_STUDY_URL, studyInstanceUID), OSIRIX_WINDOW_NAME);
    }

    public static void closeWindows() throws XmlRpcException
    {
        UI.getCurrent().getPage().open(CLOSE_STUDY_URL, OSIRIX_WINDOW_NAME);
    }
}
