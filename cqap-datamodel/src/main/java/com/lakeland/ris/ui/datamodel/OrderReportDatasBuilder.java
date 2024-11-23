package com.lakeland.ris.ui.datamodel;


import java.util.*;
import com.lakeland.ris.datamodel.*;
import java.util.*;

public class OrderReportDatasBuilder
{
    private Collection<OrderReportData> data;

    public OrderReportDatasBuilder(Collection<OrderReportData> data)
    {
        super();

        this.data = data;
    }


    
    public OrderReportDatasBuilder setData(Collection<OrderReportData> data)
    {
        this.data = data;

        return self();
    }

    
    protected Collection<OrderReportData> getData()
    {
        return data;
    }

    
    public OrderReportDatas build()
    {
        return new OrderReportDatas(getData());
    }


    
    protected OrderReportDatasBuilder self()
    {
        return this;
    }
}