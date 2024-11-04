package com.capstone.fx;

import com.capstone.fx.controllers.*;
import com.capstone.fx.model.*;
import com.cqap.client.*;
import com.peirs.datamodel.Role;
import com.peirs.datamodel.*;
import com.peirs.datamodel.dicom.*;
import com.peirs.datamodel.hl7.*;
import com.peirs.datamodel.ticket.*;
import javafx.application.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.*;
import jfxtras.labs.dialogs.*;
import org.slf4j.*;
import org.springframework.context.annotation.*;
import org.springframework.http.*;
import org.springframework.http.client.*;
import org.springframework.web.client.*;

import java.io.*;
import java.util.*;

public class Main extends Application
{
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    private static final String TITLE = "Cornerstone Quality Assurance";
    private static final double MINIMUM_WINDOW_WIDTH = 390.0;
    private static final double MINIMUM_WINDOW_HEIGHT = 500.0;
    private AnnotationConfigApplicationContext theContext;
    private ClientRestService theClientService;
    private EntityCache theEntityCache;
    private User theUser;
    private Stage thePrimaryStage;
    private Stage theSecondaryStage;
    private final StackPane theViews;

    public Main()
    {
        theEntityCache = new EntityCache();
        theViews = new StackPane();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage aStage)
    {
        try
        {
            Platform.setImplicitExit(false);
            thePrimaryStage = aStage;
            thePrimaryStage.setTitle(TITLE);
            thePrimaryStage.setMinWidth(MINIMUM_WINDOW_WIDTH);
            thePrimaryStage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
            theSecondaryStage = new Stage();
            theSecondaryStage.initModality(Modality.WINDOW_MODAL);
            theSecondaryStage.initOwner(thePrimaryStage);
            theSecondaryStage.setScene(new Scene(theViews));
            login();
            thePrimaryStage.show();
            thePrimaryStage.setOnCloseRequest(new EventHandler<WindowEvent>()
            {
                @Override public void handle(WindowEvent aWindowEvent)
                {
                    aWindowEvent.consume();
                    theContext.close();
                    theEntityCache = new EntityCache();
                    login();
                    thePrimaryStage.show();
                }
            });
        }
        catch (Exception anException)
        {
            LOGGER.error("Error loading root layout", anException);
        }
    }

    public void login()
    {
        try
        {
            replaceSceneContent(thePrimaryStage, "fxml/Login.fxml", 30, 30);
            thePrimaryStage.centerOnScreen();
        }
        catch (Exception anException)
        {
            LOGGER.error("Error loading dashboard", anException);
        }
    }

    public void showDashboard()
    {
        try
        {
            replaceSceneContent(thePrimaryStage, "fxml/Dashboard.fxml", 30, 30);
            thePrimaryStage.sizeToScene();
        }
        catch (Exception anException)
        {
            LOGGER.error("Error loading dashboard", anException);
        }
    }

    public void showImageSearch()
    {
        try
        {
            replaceSceneContent(thePrimaryStage, "fxml/NewTicket.fxml", 30, 30);
        }
        catch (Exception anException)
        {
            LOGGER.error("Error loading image search", anException);
        }
    }

    public void showStudySearch()
    {
        try
        {
            replaceSceneContent(thePrimaryStage, "fxml/TicketArchive.fxml", 30, 30);
        }
        catch (Exception anException)
        {
            LOGGER.error("Error loading ticket search", anException);
        }
    }

    public void closeTicket()
    {
        theSecondaryStage.close();
    }

    public void showMyStudyList()
    {
        try
        {
            replaceSceneContent(thePrimaryStage, "fxml/MyTickets.fxml", 30, 30);
        }
        catch (Exception anException)
        {
            LOGGER.error("Error loading my study list", anException);
        }
    }

    public void showTicketAdmin()
    {
        try
        {
            TicketAdministrationController myController =
                    replaceSceneContent(thePrimaryStage, "fxml/TicketAdmin.fxml", 30, 30);
            myController.showTickets();
        }
        catch (Exception anException)
        {
            LOGGER.error("Error loading my study list", anException);
        }
    }

    public void showERPOpen(ProfessionalTicket aTicket)
    {
        try
        {
            ERPOpenController
                    myController =
                    replaceSceneContent(theSecondaryStage, "fxml/ERPOpen.fxml", 31, 31);
            myController.display(aTicket);
            showTicket();
        }
        catch (Exception anException)
        {
            LOGGER.error("Error loading ERP Open Review", anException);
        }
    }

    private void showTicket()
    {
        if (!theSecondaryStage.isShowing())
        {
            theSecondaryStage.showAndWait();
        }
    }

    public void showTechERPOpen(ProfessionalTicket aTicket)
    {
        try
        {
            TechERPOpenController myController =
                    replaceSceneContent(theSecondaryStage, "fxml/TechERPOpen.fxml", 31, 31);
            myController.display(aTicket);
            showTicket();
        }
        catch (Exception anException)
        {
            LOGGER.error("Error loading ERP Open Review", anException);
        }
    }

    public void showERPConfirm(ProfessionalTicket aTicket, TicketStatus aStatus)
    {
        try
        {
            ERPConfirmController
                    myController =
                    replaceSceneContent(theSecondaryStage, "fxml/ERPConfirm.fxml", 29, 29);
            myController.setNextStatus(aStatus);
            myController.display(aTicket);
        }
        catch (Exception anException)
        {
            LOGGER.error("Error loading ERP Confirm Review", anException);
        }
    }

    public void showTechERPConfirm(ProfessionalTicket aTicket, TicketStatus aStatus)
    {
        try
        {
            TechERPConfirmController myController =
                    replaceSceneContent(theSecondaryStage, "fxml/TechERPConfirm.fxml", 29, 29);
            myController.setNextStatus(aStatus);
            myController.display(aTicket);
        }
        catch (Exception anException)
        {
            LOGGER.error("Error loading ERP Confirm Review", anException);
        }
    }

    public void showIIROpen(ProfessionalTicket aProfessionalTicket)
    {
        try
        {
            IIROpenController
                    myController =
                    replaceSceneContent(theSecondaryStage, "fxml/IIROpen.fxml", 30, 30);
            myController.display(aProfessionalTicket);
            showTicket();
        }
        catch (Exception anException)
        {
            LOGGER.error("Error loading IIR Open Review", anException);
        }
    }

    public void showCMOOpen(ProfessionalTicket aProfessionalTicket)
    {
        try
        {
            CMOOpenController
                    myController =
                    replaceSceneContent(theSecondaryStage, "fxml/CMOOpen.fxml", 30, 30);
            myController.display(aProfessionalTicket);
            showTicket();
        }
        catch (Exception anException)
        {
            LOGGER.error("Error loading CMO Open Review", anException);
        }
    }

    public void showCMOConfirm(ProfessionalTicket aProfessionalTicket)
    {
        try
        {
            CMOConfirmController
                    myController =
                    replaceSceneContent(theSecondaryStage, "fxml/CMOConfirm.fxml", 29, 29);
            myController.display(aProfessionalTicket);
            showTicket();
        }
        catch (Exception anException)
        {
            LOGGER.error("Error loading CMO Confirm Review", anException);
        }
    }

    public void showSiteCallRequired(ProfessionalTicket aProfessionalTicket)
    {
        try
        {
            SiteCallController
                    myController =
                    replaceSceneContent(theSecondaryStage, "fxml/SiteCall.fxml", 30, 30);
            myController.display(aProfessionalTicket);
            showTicket();
        }
        catch (Exception anException)
        {
            LOGGER.error("Error loading Site Call Required Review", anException);
        }
    }

    public void showCompleted(ProfessionalTicket aTicket)
    {
        try
        {
            if (aTicket.getType() == TicketType.PR)
            {
                if (theUser.getRole() == Role.QAD)
                {
                    CompletedAdminController myController =
                            replaceSceneContent(theSecondaryStage,
                                    "fxml/CompletedAdmin.fxml",
                                    30,
                                    30);
                    myController.display(aTicket);
                }
                else
                {
                    CompletedController
                            myController =
                            replaceSceneContent(theSecondaryStage, "fxml/Completed.fxml", 30, 30);
                    myController.display(aTicket);
                }
            }
            else
            {
                TechPendingController
                        myController =
                        replaceSceneContent(theSecondaryStage, "fxml/TechCompleted.fxml", 30, 30);
                myController.display(aTicket);
            }
            showTicket();
        }
        catch (Exception anException)
        {
            LOGGER.error("Error loading Completed Review", anException);
        }
    }

    public void showTechCompleted(ProfessionalTicket aTicket)
    {
        try
        {
            TechPendingController myController =
                    replaceSceneContent(theSecondaryStage, "fxml/TechCompleted.fxml", 30, 30);
            myController.display(aTicket);
            showTicket();
        }
        catch (Exception anException)
        {
            LOGGER.error("Error loading Completed Review", anException);
        }
    }

    public void showPending(ProfessionalTicket aTicket)
    {
        try
        {
            if (theUser.getRole() == Role.QAD)
            {
                if (aTicket.getType() == TicketType.PR)
                {
                    PendingController
                            myController =
                            replaceSceneContent(theSecondaryStage, "fxml/Pending.fxml", 30, 30);
                    myController.display(aTicket);
                }
                else
                {
                    TechPendingController
                            myController =
                            replaceSceneContent(theSecondaryStage, "fxml/TechPending.fxml", 30, 30);
                    myController.display(aTicket);
                }
                showTicket();
            }
        }
        catch (Exception anException)
        {
            LOGGER.error("Error loading Pending Review", anException);
        }
    }

    public void showTechPending(ProfessionalTicket aTicket)
    {
        try
        {
            if (theUser.getRole() == Role.QAD)
            {
                TechPendingController myController =
                        replaceSceneContent(theSecondaryStage, "fxml/TechPending.fxml", 30, 30);
                myController.display(aTicket);
                showTicket();
            }
        }
        catch (Exception anException)
        {
            LOGGER.error("Error loading Pending Review", anException);
        }
    }

    public void showUsers()
    {
        try
        {
            replaceSceneContent(thePrimaryStage, "fxml/User.fxml", 40, 40);
        }
        catch (Exception anException)
        {
            LOGGER.error("Error loading users", anException);
        }
    }

    public void showGroups()
    {
        try
        {
            replaceSceneContent(thePrimaryStage, "fxml/Group.fxml", 40, 40);
        }
        catch (Exception anException)
        {
            LOGGER.error("Error loading groups", anException);
        }
    }

    public void showInstitutions()
    {
        try
        {
            replaceSceneContent(thePrimaryStage, "fxml/Institution.fxml", 40, 40);
        }
        catch (Exception anException)
        {
            LOGGER.error("Error loading institutions", anException);
        }
    }

    public void showCPTCodes()
    {
        try
        {
            replaceSceneContent(thePrimaryStage, "fxml/CPTCode.fxml", 40, 40);
        }
        catch (Exception anException)
        {
            LOGGER.error("Error loading CPT codes", anException);
        }
    }

    public void showReport(String aReport)
    {
        try
        {
            UserReportController
                    myController =
                    replaceSceneContent(theSecondaryStage, "fxml/UserReport.fxml", 30, 30);
            myController.displayReport(aReport);
            showTicket();
        }
        catch (Exception anException)
        {
            LOGGER.error("Error loading edit study", anException);
        }
    }


    public void showStudy(DicomStudy aStudy, Collection<HL7> aFilteredMergeHL7s)
    {
        try
        {
            EditStudyController
                    myController =
                    replaceSceneContent(theSecondaryStage, "fxml/EditStudy.fxml", 30, 30);
            myController.display(aStudy, aFilteredMergeHL7s);
            showTicket();
        }
        catch (Exception anException)
        {
            LOGGER.error("Error loading edit study", anException);
        }
    }

    public void showViewer(DicomStudy aStudy)
    {
        try
        {
            FXMLLoader myLoader = new FXMLLoader(Main.class.getClassLoader().getResource("fxml/Viewer.fxml"));
            AnchorPane myPane = (AnchorPane) myLoader.load();
            Scene myScene = new Scene(myPane);
            Stage myStage = new Stage();
            myStage.setScene(myScene);
            myStage.setTitle(aStudy.getPatientName() + "-" + aStudy.getStudyInstanceUID());
            ViewerController myController = getController(myLoader);
            myController.showImages(aStudy);
            myStage.sizeToScene();
            myStage.centerOnScreen();
            myStage.show();
        }
        catch (Exception anException)
        {
            LOGGER.error("Error loading institutions", anException);
        }
    }

    private <T extends BaseController> T replaceSceneContent(Stage aStage,
                                                             String aFile,
                                                             int aHeightBorder,
                                                             int aWidthBorder) throws Exception
    {
        FXMLLoader myLoader = new FXMLLoader(Main.class.getClassLoader().getResource(aFile));
        AnchorPane myPane = (AnchorPane) myLoader.load();
        aStage.setScene(new Scene(myPane));
        setBounds(aStage, myPane, aHeightBorder, aWidthBorder);

        return getController(myLoader);
    }

    private void setBounds(Stage aStage,
                           AnchorPane aAnchorPane,
                           int aHeightBorder,
                           int aWidthBorder)
    {
        Screen myScreen = Screen.getPrimary();
        Rectangle2D myBounds = myScreen.getVisualBounds();
        double myHeight = myBounds.getHeight() - aHeightBorder;
        double myWidth = myBounds.getWidth() - aWidthBorder;
        aStage.setMaxHeight(myHeight);
        aStage.setMaxWidth(myWidth);
        aAnchorPane.requestLayout();
    }

    private <T extends BaseController> T getController(FXMLLoader aLoader)
    {
        T myController = aLoader.getController();
        myController.setMainApp(this);
        myController.setUser(theUser);
        myController.setEntityCache(theEntityCache);
        myController.setClientService(theClientService);
        return myController;
    }

    public Stage getPrimaryStage()
    {
        return thePrimaryStage;
    }

    @Override
    public void stop() throws Exception
    {
        if (theContext != null)
        {
            theContext.close();
        }

        super.stop();

        System.exit(0);
    }

    public void setUser(User aUser)
    {
        theUser = aUser;
    }

    public void showTicket(TicketQueryResult aTicketQueryResult)
    {
        showTicket(theClientService.findProfessionalTicket(aTicketQueryResult));
    }

    public void showTicket(ProfessionalTicket aTicket)
    {
        switch (aTicket.getStatus())
        {
            case OPEN_ERP_REVIEW:
            {
                showERPOpen(aTicket);

                break;
            }
            case TECH_OPEN_ERP_REVIEW:
            {
                showTechERPOpen(aTicket);

                break;
            }
            case OPEN_PIR_REVIEW:
            {
                showIIROpen(aTicket);

                break;
            }
            case OPEN_CMO_REVIEW:
            {
                showCMOOpen(aTicket);

                break;
            }
            case TECH_OPEN_CMO_REVIEW:
            {
                showTechERPOpen(aTicket);

                break;
            }
            case OPEN_SITE_CALL_REQUIRED:
            {
                showSiteCallRequired(aTicket);

                break;
            }
            case COMPLETED:
            {
                showCompleted(aTicket);

                break;
            }
            case TECH_COMPLETED:
            {
                showTechCompleted(aTicket);

                break;
            }
            case PENDING:
            {
                showPending(aTicket);

                break;
            }
            case TECH_PENDING:
            {
                showTechPending(aTicket);

                break;
            }
        }
    }

    public void setTestMode(boolean aTestMode)
    {
        System.setProperty("prod", Boolean.toString(!aTestMode));
        thePrimaryStage.setTitle(aTestMode ? TITLE + " : Trial Mode" : TITLE);
        theContext = new AnnotationConfigApplicationContext(ClientServiceProvider.class);
        theClientService = theContext.getBean(ClientRestService.class);
        theClientService.addErrorHandler(new ResponseErrorHandler()
        {
            @Override public boolean hasError(ClientHttpResponse aClientHttpResponse) throws IOException
            {
                checkAndShowError(aClientHttpResponse);

                return true;
            }

            @Override public void handleError(ClientHttpResponse aClientHttpResponse) throws IOException
            {
                checkAndShowError(aClientHttpResponse);
            }

            private void checkAndShowError(ClientHttpResponse aClientHttpResponse) throws IOException
            {
                if (aClientHttpResponse.getStatusCode() != HttpStatus.OK)
                {
                    LOGGER.error(aClientHttpResponse.getStatusText());

                    showError(aClientHttpResponse);

                }
            }

        });
        Platform.runLater(new Runnable()
        {
            @Override public void run()
            {
                theEntityCache.setCountries(theClientService.findAllCountries());
                theEntityCache.setPIRs(theClientService.findUsersForRole(Role.PIR));
                theEntityCache.setSTs(theClientService.findUsersForRole(Role.ST));
                theEntityCache.setGroups(theClientService.findAllGroups());
                theEntityCache.setInstitutions(theClientService.findAllInstitutions());
            }
        });
    }

    private void showError(ClientHttpResponse aClientHttpResponse) throws IOException
    {
        MonologFXButton mlb = MonologFXButtonBuilder.create()
                .defaultButton(true)
                .type(MonologFXButton.Type.OK)
                .build();

        MonologFXBuilder.create()
                .modal(true)
                .type(MonologFX.Type.ERROR)
                .message("Error code: " +
                        aClientHttpResponse.getStatusCode() +
                        " : " +
                        aClientHttpResponse.getStatusText())
                .titleText("Server Error")
                .button(mlb)
                .buttonAlignment(MonologFX.ButtonAlignment.RIGHT)
                .build().showDialog();
    }

    public ClientRestService getClientService()
    {
        return theClientService;
    }

    public void showCorrespondingTicket(String aCorrespondingReviewViewId)
    {
        TicketQuery myQuery = new TicketQueryBuilder().setTicketId(aCorrespondingReviewViewId).build();
        List<TicketQueryResult> myQueryResults = getClientService().findProfessionalTickets(myQuery);
        if (!myQueryResults.isEmpty())
        {
            showTicket(myQueryResults.iterator().next());
        }
        theSecondaryStage.sizeToScene();
    }

    public void createAndShowPRTicket(ProfessionalTicket aTicket)
    {
        ProfessionalTicket myCorrespondingTicket = getClientService().createCorrespondingTicket(aTicket, theUser);
        if (myCorrespondingTicket != null)
        {
            showTicket(myCorrespondingTicket);
        }
    }

}
