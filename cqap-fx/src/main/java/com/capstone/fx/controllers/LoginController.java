package com.capstone.fx.controllers;

import com.capstone.fx.utils.*;
import com.peirs.datamodel.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import org.slf4j.*;

public class LoginController extends BaseController
{
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    @FXML public TextField theUserId;
    @FXML public PasswordField thePassword;
    @FXML public Button theLogin;
    @FXML public Label theErrorMessage;
    @FXML public RadioButton theTestMode;

    @FXML
    public void initialize()
    {
        theErrorMessage.getStyleClass().add("error");
        theLogin.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
        {
            public void handle(MouseEvent e)
            {
                processLogin();
            }
        });
    }

    @FXML
    public void processLogin()
    {
        if (FieldValidation.checkTextField(theUserId))
        {
            theMain.setTestMode(theTestMode.isSelected());
            String myUsername = theUserId.getText();
            User myUser = theMain.getClientService().loginUser(myUsername);

            if (myUser.getUsername() != null)
            {
                theErrorMessage.setText("");
                theMain.setUser(myUser);
                theMain.showDashboard();
            }
            else
            {
                theErrorMessage.setText("No user found for username " + myUsername);
            }
        }
    }

    @FXML
    public void processCancel()
    {
        try
        {
            theMain.stop();
        }
        catch (Exception anException)
        {
            LOGGER.error("Error stopping application", anException);
            System.exit(-1);
        }
    }
}
