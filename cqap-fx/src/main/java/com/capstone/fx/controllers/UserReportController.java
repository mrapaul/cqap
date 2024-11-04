package com.capstone.fx.controllers;

import com.capstone.fx.controllers.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class UserReportController extends BaseController
{
    @FXML private HBox theSpacer;
    @FXML private TextArea theReport;

    @FXML
    public void initialize()
    {
        HBox.setHgrow(theSpacer, Priority.ALWAYS);
    }

    public void displayReport(String aReport)
    {
        theReport.setText(aReport);
    }

    @FXML
    public void onClose()
    {
        theMain.closeTicket();
    }
}
