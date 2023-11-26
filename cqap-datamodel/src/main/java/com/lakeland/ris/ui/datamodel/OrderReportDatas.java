package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;
import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrderReportDatas
{
    @NotNull private Collection<OrderReportData> data;

    public OrderReportDatas()
    {
        // empty
    }

    @JsonCreator
    public OrderReportDatas(@NotNull Collection<OrderReportData> data)
    {
        super();

        this.data = data;
    }

    @NotNull
    public Collection<OrderReportData> getData()
    {
        return data;
    }
    public void setData(@NotNull Collection<OrderReportData> data)
    {
        this.data = data;
    }

    @NotNull
    public String toString()
    {
        return "OrderReportDatas(" +
            " data: " + getData() + ")";
    }

    @NotNull
    public OrderReportDatasBuilder toBuilder()
    {
        return new OrderReportDatasBuilder(getData());
    }
}