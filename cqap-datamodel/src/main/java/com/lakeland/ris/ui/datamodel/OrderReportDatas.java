package com.lakeland.ris.ui.datamodel;

import org.codehaus.jackson.annotate.*;

import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrderReportDatas
{
    private Collection<OrderReportData> data;

    public OrderReportDatas()
    {
        // empty
    }

    @JsonCreator
    public OrderReportDatas(Collection<OrderReportData> data)
    {
        super();

        this.data = data;
    }


    public Collection<OrderReportData> getData()
    {
        return data;
    }
    public void setData(Collection<OrderReportData> data)
    {
        this.data = data;
    }


    public String toString()
    {
        return "OrderReportDatas(" +
            " data: " + getData() + ")";
    }


    public OrderReportDatasBuilder toBuilder()
    {
        return new OrderReportDatasBuilder(getData());
    }
}