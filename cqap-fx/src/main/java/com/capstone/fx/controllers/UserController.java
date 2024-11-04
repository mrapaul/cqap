package com.capstone.fx.controllers;

import com.capstone.fx.controllers.*;
import com.capstone.fx.model.*;
import com.peirs.datamodel.*;
import javafx.application.*;
import javafx.beans.value.*;
import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;

import java.util.*;

import static com.capstone.fx.utils.FieldValidation.*;

public class UserController extends BaseController
{
    private final ObservableList<User> theUsers;
    private final ObservableList<String> theTimeZones;
    private final ObservableList<Country> theCountries;
    @FXML private ListView<User> theUserList;
    @FXML private TextField theNameField;
    @FXML private TextField theUsernameField;
    @FXML private ComboBox<Role> theRoleField;
    @FXML private ComboBox<Group> theGroupField;
    @FXML private ComboBox<Institution> theInstitutionField;
    @FXML private ComboBox<Country> theCountryField;
    @FXML private TextField theAddressField;
    @FXML private TextField theAddress1Field;
    @FXML private TextField theCityField;
    @FXML private TextField theStateField;
    @FXML private TextField theZipcodeField;
    @FXML private ComboBox<String> theTimezoneField;
    @FXML private TextField theCellphoneNumberField;
    @FXML private TextField thePhoneNumberField;
    @FXML private TextField theFaxNumberField;
    @FXML private TextField theEmailField;
    @FXML private TextField thePositionField;
    @FXML private TextField theAliasField;
    @FXML private CheckBox theRTRCPR;
    @FXML private CheckBox theRTRTPR;
    @FXML private CheckBox theURPR;
    @FXML private CheckBox theRoutinePR;
    @FXML private CheckBox theTargetedPR;
    @FXML private CheckBox theRoutineTR;
    @FXML private CheckBox theTargetedTR;
    @FXML private RadioButton theFaxNotification;
    @FXML private RadioButton theEmailNotification;
    @FXML private RadioButton theNoNotification;
    @FXML private CheckBox theAllPreferenceCheck;
    @FXML private CheckBox theCategoryCheck;
    @FXML private CheckBox theRTCheck;
    @FXML private CheckBox theURCheck;
    @FXML private CheckBox thePRCheck;
    @FXML private CheckBox theTRCheck;
    @FXML private CheckBox theAFFSCheck;
    @FXML private HBox theSpacer;
    @FXML private HBox theSpacer1;
    private boolean theUserSelected;

    public UserController()
    {
        theUsers = FXCollections.observableArrayList();
        theTimeZones = FXCollections.observableArrayList();
        theCountries = FXCollections.observableArrayList();
    }

    @FXML
    private void initialize()
    {
        theUserList.setItems(theUsers);
        theCountryField.setItems(theCountries);
        theTimezoneField.setItems(theTimeZones);
        theRoleField.setItems(FXCollections.observableArrayList(Role.values()));

        HBox.setHgrow(theSpacer, Priority.ALWAYS);
        HBox.setHgrow(theSpacer1, Priority.ALWAYS);
        addListeners();
        refresh();
    }

    @Override public void setEntityCache(EntityCache aEntityCache)
    {
        super.setEntityCache(aEntityCache);

        theGroupField.setItems(getEntityCache().getGroups());
        theInstitutionField.setItems(getEntityCache().getInstitutions());
        theCountries.addAll(getEntityCache().getCountries());
    }

    private void addListeners()
    {
        theCountryField.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Country>()
        {
            @Override public void changed(ObservableValue<? extends Country> aObservableValue,
                                          Country aCountry,
                                          Country aCountry2)
            {
                Country myCountry = aObservableValue.getValue();

                if (myCountry == null)
                {
                    return;
                }

                theTimeZones.clear();
                theTimeZones.addAll(getClientService().findTimezones(myCountry));
            }
        });
        theUserList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<User>()
        {
            @Override
            public void changed(ObservableValue<? extends User> aObservable, User aOldValue, User aNewValue)
            {
                showUserDetails(aNewValue);
            }
        });
        theUserList.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                User myUser = theUserList.getSelectionModel().getSelectedItem();
                if (myUser != null)
                {
                    showUserDetails(myUser);
                }
            }
        });
    }

    private void showUserDetails(User aUser)
    {
        reset();
        if (aUser == null)
        {
            return;
        }

        theUserSelected = true;
        theNameField.setText(aUser.getName());
        theUsernameField.setText(aUser.getUsername());
        theRoleField.getSelectionModel().select(aUser.getRole());
        thePositionField.setText(aUser.getPosition());
        theGroupField.getSelectionModel().select(aUser.getGroup());
        if (aUser.getInstitutions() != null && !aUser.getInstitutions().isEmpty())
        {
            theInstitutionField.getSelectionModel().select(aUser.getInstitutions().iterator().next());
        }
        Address myAddress = aUser.getAddress();
        if (myAddress != null)
        {
            theAddressField.setText(myAddress.getAddress());
            theAddress1Field.setText(myAddress.getAddress1());
            theCityField.setText(myAddress.getCity());
            theStateField.setText(myAddress.getState());
            theZipcodeField.setText(myAddress.getZipcode());
            Country myCountry = myAddress.getCountry();
            if (myCountry != null)
            {
                theCountryField.getSelectionModel().select(myCountry);
            }
            String myTimeZone = myAddress.getTimeZone();
            if (myTimeZone != null)
            {
                theTimezoneField.getSelectionModel().select(myTimeZone);
            }
        }
        Phone myPhoneNumber = aUser.getPhoneNumber();
        if (myPhoneNumber != null)
        {
            thePhoneNumberField.setText(myPhoneNumber.getNumber());
        }
        Phone myCellPhoneNumber = aUser.getCellPhoneNumber();
        if (myCellPhoneNumber != null)
        {
            theCellphoneNumberField.setText(myCellPhoneNumber.getNumber());
        }
        Phone myFaxNumber = aUser.getFaxNumber();
        if (myFaxNumber != null)
        {
            theFaxNumberField.setText(myFaxNumber.getNumber());
        }
        Email myEmail = aUser.getEmail();
        if (myEmail != null)
        {
            theEmailField.setText(myEmail.getAddress());
        }

        TicketPriorities myTicketPriorities = aUser.getTicketPriorities();
        if (myTicketPriorities != null)
        {
            theRTRCPR.setSelected(myTicketPriorities.isPRRTRC());
            theRTRTPR.setSelected(myTicketPriorities.isPRRTRT());
            theURPR.setSelected(myTicketPriorities.isPRUR());
            theRoutinePR.setSelected(myTicketPriorities.isPRRR());
            theTargetedPR.setSelected(myTicketPriorities.isPRTR());
            theRoutineTR.setSelected(myTicketPriorities.isTRR());
            theTargetedTR.setSelected(myTicketPriorities.isTRT());
        }

        CompletedNotification myCompletedNotification = aUser.getCompletedNotification();
        if (myCompletedNotification != null)
        {
            theNoNotification.setSelected(true);
            theEmailNotification.setSelected(myCompletedNotification.isEmail());
            theFaxNotification.setSelected(myCompletedNotification.isFax());
        }

        NotificationPreference myPreference = aUser.getNotificationPreference();
        if (myPreference != null)
        {
            theAllPreferenceCheck.setSelected(myPreference.isAll());
            theCategoryCheck.setSelected(myPreference.isCategory());
            theRTCheck.setSelected(myPreference.isRT());
            theURCheck.setSelected(myPreference.isUR());
            thePRCheck.setSelected(myPreference.isPR());
            theTRCheck.setSelected(myPreference.isTR());
            theAFFSCheck.setSelected(myPreference.isAFFS());
        }

        theAliasField.setText(aUser.getAlias());
    }

    @FXML
    private void onNew()
    {
        reset();
        theUserSelected = false;
        theCountryField.getSelectionModel().select(0);
    }

    @FXML
    private void onSave()
    {
        User myUser = create();
        if (isInputValid())
        {
            myUser.setName(theNameField.getText().trim());
            myUser.setUsername(theUsernameField.getText().trim());
            myUser.setRole(theRoleField.getSelectionModel().getSelectedItem());
            myUser.setPosition(thePositionField.getText());
            Institution myInstitution = theInstitutionField.getSelectionModel().getSelectedItem();
            if (myInstitution != null)
            {
                myUser.setInstitutions(Arrays.asList(myInstitution));
            }
            Group myGroup = theGroupField.getSelectionModel().getSelectedItem();
            if (myGroup != null)
            {
                myUser.setGroup(myGroup);
            }
            Address myAddress = myUser.getAddress() != null ? myUser.getAddress() : new Address();
            myAddress.setAddress(theAddressField.getText());
            myAddress.setAddress1(theAddress1Field.getText());
            myAddress.setCity(theCityField.getText());
            myAddress.setState(theStateField.getText());
            myAddress.setZipcode(theZipcodeField.getText());
            Country myCountry = theCountryField.getSelectionModel().getSelectedItem();
            if (myCountry != null)
            {
                myAddress.setCountry(myCountry);
            }
            String myTimeZone = theTimezoneField.getSelectionModel().getSelectedItem();
            if (myTimeZone != null)
            {
                myAddress.setTimeZone(myTimeZone);
            }
            myUser.setAddress(myAddress);
            String myPhone = thePhoneNumberField.getText();
            if (myPhone != null)
            {
                Phone myPhoneNumber = new Phone();
                myPhoneNumber.setNumber(myPhone.trim());
                myUser.setPhoneNumber(myPhoneNumber);
            }
            String myCellphone = theCellphoneNumberField.getText();
            if (myCellphone != null)
            {
                Phone myPhoneNumber = new Phone();
                myPhoneNumber.setNumber(myCellphone.trim());
                myUser.setCellPhoneNumber(myPhoneNumber);
            }
            String myFax = theFaxNumberField.getText();
            if (myFax != null)
            {
                Phone myPhoneNumber = new Phone();
                myPhoneNumber.setNumber(myFax.trim());
                myUser.setFaxNumber(myPhoneNumber);
            }
            String myEmail = theEmailField.getText();
            if (myEmail != null)
            {
                Email myMail = new Email();
                myMail.setAddress(myEmail);
                myUser.setEmail(myMail);
            }
            TicketPriorities myTicketPriorities = new TicketPriorities();
            myTicketPriorities.setPRRTRC(theRTRCPR.isSelected());
            myTicketPriorities.setPRRTRT(theRTRTPR.isSelected());
            myTicketPriorities.setPRUR(theURPR.isSelected());
            myTicketPriorities.setPRRR(theRoutinePR.isSelected());
            myTicketPriorities.setPRTR(theTargetedPR.isSelected());
            myTicketPriorities.setTRR(theRoutineTR.isSelected());
            myTicketPriorities.setTRT(theTargetedTR.isSelected());
            myUser.setTicketPriorities(myTicketPriorities);

            CompletedNotification myNotification = new CompletedNotification();
            myNotification.setEmail(theEmailNotification.isSelected());
            myNotification.setFax(theFaxNotification.isSelected());
            myUser.setCompletedNotification(myNotification);

            NotificationPreference myPreference = new NotificationPreference();
            myPreference.setAll(theAllPreferenceCheck.isSelected());
            myPreference.setCategory(theCategoryCheck.isSelected());
            myPreference.setRT(theRTCheck.isSelected());
            myPreference.setUR(theURCheck.isSelected());
            myPreference.setPR(thePRCheck.isSelected());
            myPreference.setTR(theTRCheck.isSelected());
            myPreference.setAFFS(theAFFSCheck.isSelected());
            myUser.setNotificationPreference(myPreference);

            myUser.setAlias(theAliasField.getText());
            save(myUser);
            refresh();
        }
    }

    private User create()
    {
        return !theUserSelected ? new User() : theUserList.getSelectionModel().getSelectedItem();
    }

    private void save(User aUser)
    {
        getClientService().createOrUpdateUser(aUser);
    }

    @FXML
    private void onDelete()
    {
        for (User myUser : theUserList.getSelectionModel().getSelectedItems())
        {
            getClientService().deleteUser(myUser);
        }
        refresh();
    }

    @FXML
    private void onCancel()
    {
        reset();
    }

    private boolean isInputValid()
    {
        boolean myValid = checkTextField(theNameField);
        myValid |= checkTextField(theUsernameField);
        myValid |= checkComboBox(theRoleField);

        return myValid;
    }

    private void reset()
    {
        theNameField.clear();
        theUsernameField.clear();
        theRoleField.getSelectionModel().clearSelection();
        thePositionField.clear();
        theGroupField.getSelectionModel().clearSelection();
        theInstitutionField.getSelectionModel().clearSelection();
        theCountryField.getSelectionModel().clearSelection();
        theAddressField.clear();
        theAddress1Field.clear();
        theCityField.clear();
        theStateField.clear();
        theZipcodeField.clear();
        theTimezoneField.getSelectionModel().clearSelection();
        theCellphoneNumberField.clear();
        thePhoneNumberField.clear();
        theFaxNumberField.clear();
        theEmailField.clear();
        theRTRCPR.setSelected(false);
        theRTRTPR.setSelected(false);
        theURPR.setSelected(false);
        theRoutinePR.setSelected(false);
        theTargetedPR.setSelected(false);
        theRoutineTR.setSelected(false);
        theTargetedTR.setSelected(false);
        theNoNotification.setSelected(true);
        theAllPreferenceCheck.setSelected(false);
        theCategoryCheck.setSelected(false);
        theRTCheck.setSelected(false);
        theURCheck.setSelected(false);
        thePRCheck.setSelected(false);
        theTRCheck.setSelected(false);
        theAFFSCheck.setSelected(false);
        theUserSelected = false;
    }

    public void refresh()
    {
        reset();
        theUsers.clear();
        Platform.runLater(new Runnable()
        {
            @Override public void run()
            {
                theUsers.clear();
                theUsers.addAll(getClientService().findAllUsers());
            }
        });
    }
}
