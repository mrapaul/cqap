package com.capstone.fx.controllers;

import com.peirs.datamodel.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.text.*;

public class DashboardController extends BaseController
{
    @FXML private Text theUserName;
    @FXML private Button theUsers;
    @FXML private Button theGroups;
    @FXML private Button theInstitutions;
    @FXML private Button theCPTCodes;

    @FXML
    private void onImageSearch()
    {
        theMain.showImageSearch();
    }

    @FXML
    private void onTicketSearch()
    {
        theMain.showStudySearch();
    }

    @FXML
    private void showMyStudies()
    {
        theMain.showMyStudyList();
    }

    @FXML
    private void showTicketAdmin()
    {
        theMain.showTicketAdmin();
    }

    @FXML
    private void showUsers()
    {
        theMain.showUsers();
    }

    @FXML
    public void showGroups()
    {
        theMain.showGroups();
    }

    @FXML
    public void showInstitutions()
    {
        theMain.showInstitutions();
    }

    @FXML
    public void showCPTCodes()
    {
        theMain.showCPTCodes();
    }

    public void setUser(User aUser)
    {
        super.setUser(aUser);

        theUserName.setText(theUser.getUsername());
        boolean myAdmin = aUser.getRole() == Role.QAD;
        theUsers.setDisable(!myAdmin);
        theGroups.setDisable(!myAdmin);
        theInstitutions.setDisable(!myAdmin);
        theCPTCodes.setDisable(!myAdmin);
    }
}
