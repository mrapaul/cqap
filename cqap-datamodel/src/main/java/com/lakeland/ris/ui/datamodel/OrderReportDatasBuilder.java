package com.lakeland.ris.ui.datamodel;

import org.jetbrains.annotations.*;
import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrderReportDatasBuilder
{
    @NotNull private Collection<OrderReportData> data;

    public OrderReportDatasBuilder(@NotNull Collection<OrderReportData> data)
    {
        super();

        this.data = data;
    }


    @NotNull
    public OrderReportDatasBuilder setData(@NotNull Collection<OrderReportData> data)
    {
        this.data = data;

        return self();
    }

    @NotNull
    protected Collection<OrderReportData> getData()
    {
        return data;
    }

    @NotNull
    public OrderReportDatas build()
    {
        return new OrderReportDatas(getData());
    }


    @NotNull
    protected OrderReportDatasBuilder self()
    {
        return this;
    }
}