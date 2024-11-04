package com.capstone.fx.controllers;

import com.capstone.fx.controllers.*;
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

import static com.capstone.fx.utils.FieldValidation.*;

public class InstitutionController extends BaseController
{
    @FXML private ListView<Institution> theInstitutionList;
    private final ObservableList<Group> theGroups;
    private final ObservableList<String> theTimeZones;
    private final ObservableList<Country> theCountries;
    @FXML private ListView<User> theUserList;
    @FXML private TextField theNameField;
    @FXML private TextField theAliasField;
    @FXML private ComboBox<Group> theGroupField;
    @FXML private ComboBox<Country> theCountryField;
    @FXML private TextField theAddressField;
    @FXML private TextField theAddress1Field;
    @FXML private TextField theCityField;
    @FXML private TextField theStateField;
    @FXML private TextField theZipcodeField;
    @FXML private ComboBox<String> theTimezoneField;
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
    @FXML private HBox theSpacer;
    @FXML private HBox theSpacer1;
    private final ObservableList<Institution> theInstitutions;
    private boolean theInstitutionSelected;

    public InstitutionController()
    {
        theInstitutions = FXCollections.observableArrayList();
        theGroups = FXCollections.observableArrayList();
        theTimeZones = FXCollections.observableArrayList();
        theCountries = FXCollections.observableArrayList();
    }

    @FXML
    public void initialize()
    {
        theInstitutionList.setItems(theInstitutions);
        theCountryField.setItems(theCountries);
        theTimezoneField.setItems(theTimeZones);
        theGroupField.setItems(theGroups);
        theCountries.addAll(theCountries);
        addSpacers();
        addListeners();
        refresh();
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
        theInstitutionList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Institution>()
        {
            @Override
            public void changed(ObservableValue<? extends Institution> aObservable,
                                Institution aOldValue,
                                Institution aNewValue)
            {
                showDetails(aNewValue);
            }
        });
        theGroupField.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Group>()
        {
            @Override
            public void changed(ObservableValue<? extends Group> aObservable,
                                Group aOldValue,
                                Group aNewValue)
            {
                Group myGroup = aObservable.getValue();
                Contract myContract = myGroup != null ? myGroup.getContract() : null;
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
        });
        theInstitutionList.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                Institution myInstitution = theInstitutionList.getSelectionModel().getSelectedItem();
                if (myInstitution != null)
                {
                    showDetails(myInstitution);
                }
            }
        });
    }

    private void showDetails(Institution aInstitution)
    {
        reset();
        if (aInstitution == null)
        {
            return;
        }

        theInstitutionSelected = true;
        theNameField.setText(aInstitution.getName());
        theAliasField.setText(aInstitution.getAlias());
        Group myGroup = aInstitution.getGroup();
        if (myGroup != null)
        {
            theGroupField.getSelectionModel().select(myGroup);
        }
        Address myAddress = aInstitution.getAddress();
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
        theBillingContactNameField.setText(aInstitution.getBillingContactName());
        Phone myPhoneNumber = aInstitution.getBillingPhone();
        if (myPhoneNumber != null)
        {
            theBillingPhoneNumberField.setText(myPhoneNumber.getNumber());
        }
        Phone myFaxNumber = aInstitution.getBillingFax();
        if (myFaxNumber != null)
        {
            theBillingFaxNumberField.setText(myFaxNumber.getNumber());
        }
        Email myEmail = aInstitution.getBillingEmail();
        if (myEmail != null)
        {
            theBillingEmailField.setText(myEmail.getAddress());
        }
        theWebsiteField.setText(aInstitution.getWebsite());
        theNotesField.setText(aInstitution.getNotes());
        Contract myContract = aInstitution.getContract();
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

    @FXML
    private void onNew()
    {
        reset();
        theInstitutionSelected = false;
    }

    @FXML
    private void onSave()
    {
        Institution myInstitution = create();
        if (isInputValid())
        {
            myInstitution.setName(theNameField.getText());
            myInstitution.setAlias(theAliasField.getText());
            myInstitution.setWebsite(theWebsiteField.getText());
            myInstitution.setNotes(theNotesField.getText());
            Group myGroup = theGroupField.getSelectionModel().getSelectedItem();
            if (myGroup != null)
            {
                myInstitution.setGroup(myGroup);
            }
            Address myAddress = myInstitution.getAddress() != null ? myInstitution.getAddress() : new Address();
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
            myInstitution.setAddress(myAddress);
            myInstitution.setBillingContactName(theBillingContactNameField.getText());
            String myPhone = theBillingPhoneNumberField.getText();
            if (myPhone != null)
            {
                Phone myPhoneNumber = new Phone();
                myPhoneNumber.setNumber(myPhone.trim());
                myInstitution.setBillingPhone(myPhoneNumber);
            }
            String myFax = theBillingFaxNumberField.getText();
            if (myFax != null)
            {
                Phone myPhoneNumber = new Phone();
                myPhoneNumber.setNumber(myFax.trim());
                myInstitution.setBillingFax(myPhoneNumber);
            }
            String myEmail = theBillingEmailField.getText();
            if (myEmail != null)
            {
                Email myMail = new Email();
                myMail.setAddress(myEmail);
                myInstitution.setBillingEmail(myMail);
            }
            Contract myContract = myInstitution.getContract() != null ? myInstitution.getContract() : new Contract();

            Calendar myStartDate = theStartDateField.getValue();
            Calendar myEndDate = theEndDateField.getValue();
            myContract.setStartDate(myStartDate.getTimeInMillis());
            myContract.setEndDate(myEndDate.getTimeInMillis());
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
            myInstitution.setContract(myContract);

            save(myInstitution);
            refresh();
        }
    }

    private Institution create()
    {
        return !theInstitutionSelected ? new Institution() : theInstitutionList.getSelectionModel().getSelectedItem();
    }

    private void save(Institution aInstitution)
    {
        getClientService().createOrUpdateInstitution(aInstitution);
    }

    @FXML
    private void onDelete()
    {
        for (Institution myInstitution : theInstitutionList.getSelectionModel().getSelectedItems())
        {
            getClientService().deleteInstitution(myInstitution);
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
        theAliasField.clear();
        theGroupField.getSelectionModel().clearSelection();
        theCountryField.getSelectionModel().clearSelection();
        theAddressField.clear();
        theAddress1Field.clear();
        theCityField.clear();
        theStateField.clear();
        theZipcodeField.clear();
        theTimezoneField.getSelectionModel().clearSelection();
        theBillingContactNameField.clear();
        theBillingPhoneNumberField.clear();
        theBillingFaxNumberField.clear();
        theBillingEmailField.clear();
        theStartDateField.setValue(new GregorianCalendar());
        theEndDateField.setValue(new GregorianCalendar());
        thePRContract.setSelected(false);
        theTRContract.setSelected(false);
        theRTRCPR.setSelected(false);
        theRTRTPR.setSelected(false);
        theURPR.setSelected(false);
        theInstitutionSelected = false;
    }

    public void refresh()
    {
        reset();
        theInstitutions.clear();
        Platform.runLater(new Runnable()
        {
            @Override public void run()
            {
                getEntityCache().setInstitutions(getClientService().findAllInstitutions());
                theInstitutions.clear();
                theGroups.clear();
                theCountries.clear();
                theInstitutions.addAll(getEntityCache().getInstitutions());
                theGroups.addAll(getEntityCache().getGroups());
                theCountries.addAll(getEntityCache().getCountries());
            }
        });
    }

    private boolean isInputValid()
    {
        boolean myValid = checkTextField(theNameField);
        myValid |= checkComboBox(theCountryField);
        myValid |= checkTextField(theAddressField);
        myValid |= checkComboBox(theTimezoneField);

        return myValid;
    }
}
