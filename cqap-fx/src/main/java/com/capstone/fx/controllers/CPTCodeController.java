package com.capstone.fx.controllers;

import com.cqap.client.*;
import com.peirs.datamodel.hl7.*;
import javafx.beans.value.*;
import javafx.collections.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;

import java.util.*;

public class CPTCodeController extends BaseController
{
    private final ObservableList<CPTCode> theCPTCodes;
    private final ObservableList<CPTCode> theFilteredCPTCodes;
    @FXML private TableView<CPTCode> theCPTCodesTable;
    @FXML private TableColumn<CPTCode, String> theCPTCodeColumn;
    @FXML private TableColumn<CPTCode, String> theCPTDescriptionColumn;
    @FXML private TableColumn<CPTCode, String> theStudyDescription;
    @FXML private TableColumn<CPTCode, String> thePrimarySubspecialityColumn;
    @FXML private TableColumn<CPTCode, String> theSecondarySubspecialityColumn;
    @FXML private TableColumn<CPTCode, String> theTertiarySubspecialityColumn;
    @FXML private TableColumn<CPTCode, String> theModalityColumn;
    @FXML private TableColumn<CPTCode, String> theCMSRVUColumn;
    @FXML private TextField theFilterField;

    public CPTCodeController()
    {
        theCPTCodes = FXCollections.observableArrayList();
        theFilteredCPTCodes = FXCollections.observableArrayList();
    }

    @FXML
    public void initialize()
    {
        theCPTCodesTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        theCPTCodeColumn.setCellValueFactory(new PropertyValueFactory<CPTCode, String>("CPTCode"));
        theCPTDescriptionColumn.setCellValueFactory(new PropertyValueFactory<CPTCode, String>("CPTDescription"));
        theStudyDescription.setCellValueFactory(new PropertyValueFactory<CPTCode, String>("StudyDescription"));
        thePrimarySubspecialityColumn.setCellValueFactory(new PropertyValueFactory<CPTCode, String>(
                "SubspecialtyPrimary"));
        theSecondarySubspecialityColumn.setCellValueFactory(new PropertyValueFactory<CPTCode, String>(
                "SubspecialtySecondary"));
        theTertiarySubspecialityColumn.setCellValueFactory(new PropertyValueFactory<CPTCode, String>(
                "SubspecialtyTertiary"));
        theModalityColumn.setCellValueFactory(new PropertyValueFactory<CPTCode, String>("ImagingModality"));
        theCMSRVUColumn.setCellValueFactory(new PropertyValueFactory<CPTCode, String>("CMSRVU"));
        theCPTCodesTable.setItems(theFilteredCPTCodes);
        theCPTCodes.addListener(new ListChangeListener<CPTCode>()
        {
            @Override
            public void onChanged(ListChangeListener.Change<? extends CPTCode> change)
            {
                filter(theCPTCodes, theFilterField.getText(), theFilteredCPTCodes, theCPTCodesTable);
            }
        });
        theFilterField.textProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
            {
                filter(theCPTCodes, theFilterField.getText(), theFilteredCPTCodes, theCPTCodesTable);
            }
        });

    }

    @Override
    public void setClientService(ClientRestService aClientService)
    {
        super.setClientService(aClientService);

        refresh();
    }


    @FXML
    public void onSave()
    {

    }

    @FXML
    public void onCancel()
    {

    }

    private void refresh()
    {
        theCPTCodes.addAll(getClientService().findAllCPTCodes());
    }

    private static void filter(List<CPTCode> aCPTCodes,
                               String aFilter,
                               List<CPTCode> aResult,
                               TableView<CPTCode> aTableView)
    {
        aResult.clear();

        for (CPTCode myCPTCode : aCPTCodes)
        {
            if (matchesFilter(myCPTCode, aFilter))
            {
                aResult.add(myCPTCode);
            }
        }
        reapplyTableSortOrder(aTableView);

    }

    private static boolean matchesFilter(CPTCode aTicket, String aFilterText)
    {
        if (aFilterText == null || aFilterText.isEmpty())
        {
            return true;
        }

        String lowerCaseFilterString = aFilterText.toLowerCase();
        if (aTicket.getCPTCode().toLowerCase().contains(lowerCaseFilterString) ||
                aTicket.getCPTDescription().toLowerCase().contains(lowerCaseFilterString) ||
                aTicket.getStudyDescription().toLowerCase().contains(lowerCaseFilterString) ||
                aTicket.getImagingModality().toLowerCase().contains(lowerCaseFilterString) ||
                aTicket.getSubspecialtyPrimary().toLowerCase().contains(lowerCaseFilterString) ||
                aTicket.getSubspecialtySecondary().toLowerCase().contains(lowerCaseFilterString) ||
                aTicket.getSubspecialtyTertiary().toLowerCase().contains(lowerCaseFilterString))
        {
            return true;
        }

        return false;
    }

    private static void reapplyTableSortOrder(TableView<CPTCode> aTableView)
    {
        ArrayList<TableColumn<CPTCode, ?>> sortOrder = new ArrayList<>(aTableView.getSortOrder());
        aTableView.getSortOrder().clear();
        aTableView.getSortOrder().addAll(sortOrder);
    }
}
