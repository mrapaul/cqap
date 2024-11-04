package com.capstone.fx.controllers;

import com.capstone.fx.utils.*;
import com.peirs.datamodel.*;
import com.peirs.datamodel.ticket.*;
import javafx.beans.value.*;
import javafx.collections.*;
import javafx.fxml.*;
import javafx.scene.control.*;

import java.util.*;

public class TicketArchiveController extends MyTicketController
{
    @FXML private ComboBox<TicketType> theTicketType;
    @FXML private ComboBox<String> theModality;
    @FXML private ComboBox<Integer> theCategory;

    @FXML
    public void initialize()
    {
        super.initialize();
        theTicketType.setItems(FXCollections.observableArrayList(TicketType.values()));
        theCategory.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5));
        theModality.setItems(EnumItems.fromEnum(Modality.values()));
        theTicketType.valueProperty().addListener(new ChangeListener<TicketType>()
        {
            @Override public void changed(ObservableValue<? extends TicketType> aObservableValue,
                                          TicketType aTicketType,
                                          TicketType aTicketType2)
            {
                if (aObservableValue != null)
                {
                    ObservableList<String> myTicketStatuses = FXCollections.observableArrayList();
                    TicketType mySelectedTicketType = aObservableValue.getValue();
                    for (TicketStatus myStatus : TicketStatus.values())
                    {
                        if (myStatus.getTicketType() == mySelectedTicketType)
                        {
                            myTicketStatuses.add(myStatus.name());
                        }
                    }
                    theStatus.setItems(myTicketStatuses);
                }
            }
        });
    }

    @Override protected TicketQueryBuilder buildQuery()
    {
        TicketQueryBuilder myBuilder = super.buildQuery();
        Integer myCategory = theCategory.getSelectionModel().getSelectedItem();
        String myModality = theModality.getSelectionModel().getSelectedItem();
        TicketType myTicketType = theTicketType.getSelectionModel().getSelectedItem();
        myBuilder.setCategory(myCategory);
        if (myTicketType != null)
        {
            myBuilder.setTicketType(myTicketType.name());
        }
        if (myModality != null)
        {
            myBuilder.setModalities(Arrays.asList(myModality));
        }
        return myBuilder;
    }

    @FXML
    public void onTicketSearchReset()
    {
        theTicketType.getSelectionModel().clearSelection();
        theCategory.getSelectionModel().clearSelection();
        theModality.getSelectionModel().clearSelection();
        super.onTicketSearchReset();
    }
}
