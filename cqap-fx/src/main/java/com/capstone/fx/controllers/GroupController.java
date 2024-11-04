package com.capstone.fx.controllers;

import com.capstone.fx.controllers.*;
import com.capstone.fx.utils.*;
import com.peirs.datamodel.*;
import javafx.application.*;
import javafx.beans.value.*;
import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.ListView;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import jfxtras.labs.scene.control.*;

import java.util.*;

public class GroupController extends BaseController
{
    private final ObservableList<Group> theGroups;
    private final ObservableList<String> theTimeZones;
    private final ObservableList<Country> theCountries;
    private final ObservableList<String> theHealthcareSegments;
    @FXML private ListView<Group> theGroupList;
    @FXML private TextField theNameField;
    @FXML private ComboBox<String> theSegmentField;
    @FXML private ComboBox<Country> theCountryField;
    @FXML private TextField theAddressField;
    @FXML private TextField theAddress1Field;
    @FXML private TextField theCityField;
    @FXML private TextField theStateField;
    @FXML private TextField theZipcodeField;
    @FXML private ComboBox<String> theTimezoneField;
    @FXML private TextField thePrimaryContactNameField;
    @FXML private TextField thePrimaryPhoneNumberField;
    @FXML private TextField thePrimaryFaxNumberField;
    @FXML private TextField thePrimaryEmailField;
    @FXML private TextField theBillingContactNameField;
    @FXML private TextField theBillingPhoneNumberField;
    @FXML private TextField theBillingFaxNumberField;
    @FXML private TextField theBillingEmailField;
    @FXML private TextField theWebsiteField;
    @FXML private TextField theNotesField;
    @FXML private CalendarTextField theStartDateField;
    @FXML private CalendarTextField theEndDateField;
    @FXML private CheckBox thePRContract;
    @FXML private CheckBox theTRContract;
    @FXML private CheckBox theRTRCPR;
    @FXML private CheckBox theRTRTPR;
    @FXML private CheckBox theURPR;
    @FXML private CheckBox theRoutinePR;
    @FXML private CheckBox theTargetedPR;
    @FXML private CheckBox theRoutineTR;
    @FXML private CheckBox theTargetedTR;
    @FXML private TextField theBillingAddressField;
    @FXML private TextField theBillingAddress1Field;
    @FXML private TextField theBillingCityField;
    @FXML private TextField theBillingStateField;
    @FXML private TextField theBillingZipcodeField;
    @FXML private CheckBox theCopyContactCheck;
    @FXML private HBox theSpacer;
    @FXML private HBox theSpacer1;
    private boolean theGroupSelected;

    public GroupController()
    {
        theGroups = FXCollections.observableArrayList();
        theTimeZones = FXCollections.observableArrayList();
        theCountries = FXCollections.observableArrayList();
        theHealthcareSegments = FXCollections.observableArrayList();
    }

    @FXML
    private void initialize()
    {
        theGroupList.setItems(theGroups);
        theCountryField.setItems(theCountries);
        theTimezoneField.setItems(theTimeZones);
        theSegmentField.setItems(theHealthcareSegments);
        theStartDateField.setValue(new GregorianCalendar());
        theEndDateField.setValue(new GregorianCalendar());
        addSpacers();
        addListeners();
        refresh();
    }

    @FXML
    private void onCopyPrimaryContactToBilling()
    {
        if (theCopyContactCheck.isSelected())
        {
            theBillingContactNameField.setText(thePrimaryContactNameField.getText());
            theBillingPhoneNumberField.setText(thePrimaryPhoneNumberField.getText());
            theBillingFaxNumberField.setText(thePrimaryFaxNumberField.getText());
            theBillingEmailField.setText(thePrimaryEmailField.getText());
            theBillingAddressField.setText(theAddressField.getText());
            theBillingAddress1Field.setText(theAddress1Field.getText());
            theBillingCityField.setText(theCityField.getText());
            theBillingStateField.setText(theStateField.getText());
            theBillingZipcodeField.setText(theZipcodeField.getText());
        }
        else
        {
            theBillingContactNameField.clear();
            theBillingPhoneNumberField.clear();
            theBillingFaxNumberField.clear();
            theBillingEmailField.clear();
            theBillingAddressField.clear();
            theBillingAddress1Field.clear();
            theBillingCityField.clear();
            theBillingStateField.clear();
            theBillingZipcodeField.clear();
        }
    }

    private void addSpacers()
    {
        HBox.setHgrow(theSpacer, Priority.ALWAYS);
        HBox.setHgrow(theSpacer1, Priority.ALWAYS);
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
        theGroupList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Group>()
        {
            @Override
            public void changed(ObservableValue<? extends Group> aObservable, Group aOldValue, Group aNewValue)
            {
                showGroupDetails(aNewValue);
            }
        });

        theGroupList.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                Group myGroup = theGroupList.getSelectionModel().getSelectedItem();
                if (myGroup != null)
                {
                    showGroupDetails(myGroup);
                }
            }
        });
    }

    private void showGroupDetails(Group aGroup)
    {
        reset();
        if (aGroup == null)
        {
            return;
        }

        theGroupSelected = true;
        theNameField.setText(aGroup.getName());
        String mySegment = aGroup.getSegment();
        if (mySegment != null)
        {
            theSegmentField.getSelectionModel().select(mySegment);
        }
        Address myAddress = aGroup.getPrimaryAddress();
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
        Address myBillingAddress = aGroup.getBillingAddress();
        if (myAddress != null)
        {
            theBillingAddressField.setText(myBillingAddress.getAddress());
            theBillingAddress1Field.setText(myBillingAddress.getAddress1());
            theBillingCityField.setText(myBillingAddress.getCity());
            theBillingStateField.setText(myBillingAddress.getState());
            theBillingZipcodeField.setText(myBillingAddress.getZipcode());
        }
        setPrimaryDetails(aGroup);
        setBillingDetails(aGroup);
        theWebsiteField.setText(aGroup.getWebsite());
        theNotesField.setText(aGroup.getNotes());
        Contract myContract = aGroup.getContract();
        if (myContract != null)
        {
            GregorianCalendar myStartDate = new GregorianCalendar();
            GregorianCalendar myEndDate = new GregorianCalendar();
            myStartDate.setTimeInMillis(myContract.getStartDate());
            myEndDate.setTimeInMillis(myContract.getEndDate());
            theStartDateField.setValue(myStartDate);
            theEndDateField.setValue(myEndDate);
            thePRContract.setSelected(myContract.isPRContract());
            theTRContract.setSelected(myContract.isTRContract());
            TicketPriorities myTicketPriorities = myContract.getPriorities();
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
        }
    }

    private void setPrimaryDetails(Group aGroup)
    {
        thePrimaryContactNameField.setText(aGroup.getPrimaryContactName());
        Phone myPhoneNumber = aGroup.getPrimaryPhone();
        if (myPhoneNumber != null)
        {
            thePrimaryPhoneNumberField.setText(myPhoneNumber.getNumber());
        }
        Phone myFaxNumber = aGroup.getPrimaryFax();
        if (myFaxNumber != null)
        {
            thePrimaryFaxNumberField.setText(myFaxNumber.getNumber());
        }
        Email myEmail = aGroup.getPrimaryEmail();
        if (myEmail != null)
        {
            thePrimaryEmailField.setText(myEmail.getAddress());
        }
    }

    private void setBillingDetails(Group aGroup)
    {
        theBillingContactNameField.setText(aGroup.getBillingContactName());
        Phone myPhoneNumber = aGroup.getBillingPhone();
        if (myPhoneNumber != null)
        {
            theBillingPhoneNumberField.setText(myPhoneNumber.getNumber());
        }
        Phone myFaxNumber = aGroup.getBillingFax();
        if (myFaxNumber != null)
        {
            theBillingFaxNumberField.setText(myFaxNumber.getNumber());
        }
        Email myEmail = aGroup.getBillingEmail();
        if (myEmail != null)
        {
            theBillingEmailField.setText(myEmail.getAddress());
        }
    }

    @FXML
    private void onNew()
    {
        reset();
        theGroupSelected = false;
    }

    @FXML
    private void onSave()
    {
        Group myGroup = create();
        if (isInputValid())
        {
            myGroup.setName(theNameField.getText());
            myGroup.setSegment(theSegmentField.getSelectionModel().getSelectedItem());
            myGroup.setWebsite(theWebsiteField.getText());
            myGroup.setNotes(theNotesField.getText());
            Address myAddress = myGroup.getPrimaryAddress() != null ? myGroup.getPrimaryAddress() : new Address();
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
            myGroup.setPrimaryAddress(myAddress);
            // primary contact
            myGroup.setPrimaryContactName(thePrimaryContactNameField.getText());
            String myPhone = thePrimaryPhoneNumberField.getText();
            if (myPhone != null)
            {
                Phone myPhoneNumber = new Phone();
                myPhoneNumber.setNumber(myPhone.trim());
                myGroup.setPrimaryPhone(myPhoneNumber);
            }
            String myFax = thePrimaryFaxNumberField.getText();
            if (myFax != null)
            {
                Phone myPhoneNumber = new Phone();
                myPhoneNumber.setNumber(myFax.trim());
                myGroup.setPrimaryFax(myPhoneNumber);
            }
            String myEmail = thePrimaryEmailField.getText();
            if (myEmail != null)
            {
                Email myMail = new Email();
                myMail.setAddress(myEmail);
                myGroup.setPrimaryEmail(myMail);
            }
            // billing contact
            myGroup.setBillingContactName(theBillingContactNameField.getText());
            String myBillingPhone = theBillingPhoneNumberField.getText();
            if (myBillingPhone != null)
            {
                Phone myPhoneNumber = new Phone();
                myPhoneNumber.setNumber(myBillingPhone.trim());
                myGroup.setBillingPhone(myPhoneNumber);
            }
            String myBillingFax = theBillingFaxNumberField.getText();
            if (myBillingFax != null)
            {
                Phone myPhoneNumber = new Phone();
                myPhoneNumber.setNumber(myBillingFax.trim());
                myGroup.setBillingFax(myPhoneNumber);
            }
            String myBillingEmail = theBillingEmailField.getText();
            if (myBillingEmail != null)
            {
                Email myMail = new Email();
                myMail.setAddress(myBillingEmail);
                myGroup.setBillingEmail(myMail);
            }
            Contract myContract = myGroup.getContract() != null ? myGroup.getContract() : new Contract();
            myContract.setStartDate(theStartDateField.getValue().getTimeInMillis());
            myContract.setEndDate(theEndDateField.getValue().getTimeInMillis());
            myContract.setPRContract(thePRContract.isSelected());
            myContract.setTRContract(theTRContract.isSelected());
            TicketPriorities myTicketPriorities = new TicketPriorities();
            myTicketPriorities.setPRRTRC(theRTRCPR.isSelected());
            myTicketPriorities.setPRRTRT(theRTRTPR.isSelected());
            myTicketPriorities.setPRUR(theURPR.isSelected());
            myTicketPriorities.setPRRR(theRoutinePR.isSelected());
            myTicketPriorities.setPRTR(theTargetedPR.isSelected());
            myTicketPriorities.setTRR(theRoutineTR.isSelected());
            myTicketPriorities.setTRT(theTargetedTR.isSelected());
            myContract.setPriorities(myTicketPriorities);
            myGroup.setContract(myContract);

            Address
                    myBillingAddress =
                    myGroup.getBillingAddress() != null ? myGroup.getBillingAddress() : new Address();
            myBillingAddress.setAddress(theBillingAddressField.getText());
            myBillingAddress.setAddress1(theBillingAddress1Field.getText());
            myBillingAddress.setCity(theBillingCityField.getText());
            myBillingAddress.setState(theBillingStateField.getText());
            myBillingAddress.setZipcode(theBillingZipcodeField.getText());
            myGroup.setBillingAddress(myBillingAddress);

            save(myGroup);
            refresh();
        }
    }

    private Group create()
    {
        return !theGroupSelected ? new Group() : theGroupList.getSelectionModel().getSelectedItem();
    }

    private void save(Group aGroup)
    {
        getClientService().createOrUpdateGroup(aGroup);
    }

    @FXML
    private void onDelete()
    {
        for (Group myGroup : theGroupList.getSelectionModel().getSelectedItems())
        {
            getClientService().deleteGroup(myGroup);
        }
        refresh();
    }

    @FXML
    protected void onCancel()
    {
        reset();
    }

    private void reset()
    {
        theNameField.clear();
        theSegmentField.getSelectionModel().clearSelection();
        theCountryField.getSelectionModel().clearSelection();
        theAddressField.clear();
        theAddress1Field.clear();
        theCityField.clear();
        theStateField.clear();
        theZipcodeField.clear();
        theTimezoneField.getSelectionModel().clearSelection();
        thePrimaryContactNameField.clear();
        thePrimaryPhoneNumberField.clear();
        thePrimaryFaxNumberField.clear();
        thePrimaryEmailField.clear();
        theBillingContactNameField.clear();
        theBillingPhoneNumberField.clear();
        theBillingFaxNumberField.clear();
        theBillingEmailField.clear();
        theStartDateField.setValue(new GregorianCalendar());
        theEndDateField.setValue(new GregorianCalendar());
        theBillingAddressField.clear();
        theBillingAddress1Field.clear();
        theBillingCityField.clear();
        theBillingStateField.clear();
        theBillingZipcodeField.clear();
        theWebsiteField.clear();
        theNotesField.clear();
        thePRContract.setSelected(false);
        theTRContract.setSelected(false);
        theRTRCPR.setSelected(false);
        theRTRTPR.setSelected(false);
        theURPR.setSelected(false);
        theGroupSelected = false;
    }

    public void refresh()
    {
        reset();
        theGroups.clear();
        Platform.runLater(new Runnable()
        {
            @Override public void run()
            {
                getEntityCache().setGroups(getClientService().findAllGroups());
                theGroups.clear();
                theCountries.clear();
                theHealthcareSegments.clear();
                theGroups.addAll(getEntityCache().getGroups());
                theCountries.addAll(getEntityCache().getCountries());
                for (HealthcareSegment myHealthcareSegment : getClientService().findAllHealthcareSegments())
                {
                    theHealthcareSegments.add(myHealthcareSegment.getName());
                }
            }
        });
    }

    private boolean isInputValid()
    {
        return FieldValidation.checkTextField(theNameField);
    }
}
