package com.capstone.fx.utils;

import javafx.collections.*;

public class EnumItems
{
    private EnumItems()
    {
        // empty
    }

    public static <T extends Enum> ObservableList<String> fromEnum(T[] aValues)
    {
        ObservableList<String> myList = FXCollections.observableArrayList();
        for (Enum myEnum : aValues)
        {
            myList.add(myEnum.toString());
        }

        return myList;
    }
}
