package com.capstone.fx.controllers;

import javafx.fxml.*;
import javafx.scene.control.*;

public abstract class BaseReadOnlyTicketController extends BaseTicketController
{
    @FXML protected TextArea theAdditionalFindings;

    @FXML
    protected void onAdditionalFactFindings()
    {
        theDetails.setExpandedPane(theAdditionalFactFindingsPanel);
        theAdditionalFindings.requestFocus();
    }

    @Override protected void saveDetails()
    {
        // empty
    }
}
