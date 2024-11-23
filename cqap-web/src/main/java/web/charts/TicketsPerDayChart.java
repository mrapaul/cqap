package web.charts;

import ch.lambdaj.collection.*;
import com.cqap.client.*;
import com.peirs.datamodel.*;
import com.vaadin.addon.charts.*;
import com.vaadin.addon.charts.model.*;
import com.vaadin.addon.charts.model.style.*;
import com.vaadin.server.*;
import com.vaadin.ui.*;

import web.*;

import java.text.*;
import java.util.*;

import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.sort;
import static ch.lambdaj.collection.LambdaCollections.with;

public class TicketsPerDayChart
{
    private static final int DAY_IN_MILLIS = 24 * 3600 * 1000;

    public static  Component getChart(ClientRestService clientRestService) {
        Collection<TicketsPerDay> ticketsPerDay = clientRestService.getTicketsPerDay();
        List<TicketsPerDay> sortedTicketsPerDay = sort(ticketsPerDay, on(TicketsPerDay.class).getDate());
        List<Integer> counts = with(sortedTicketsPerDay).extract(on(TicketsPerDay.class).getCount());

        Chart chart = new Chart();
        chart.setSizeFull();

        Configuration configuration = chart.getConfiguration();
        configuration.getChart().setZoomType(ZoomType.X);
        configuration.getChart().setSpacingRight(20);
        configuration.getChart().setPlotBackgroundColor(new SolidColor(40, 40, 40));
        configuration.getChart().setBackgroundColor(new SolidColor(40, 40, 40));

        configuration.getTitle().setText(
                "Daily Ticket Count");

        String title = Page.getCurrent().getWebBrowser().isTouchDevice() ? "Drag your finger over the plot to zoom in"
                : "Click and drag in the plot area to zoom in";
        configuration.getSubTitle().setText(title);

        configuration.getxAxis().setType(AxisType.DATETIME);
        configuration.getxAxis().setTitle(new Title(""));

        configuration.getLegend().setEnabled(false);

        Axis yAxis = configuration.getyAxis();
        yAxis.setTitle(new Title("Count"));
        yAxis.setMin(0);
        yAxis.setStartOnTick(false);
        yAxis.setShowFirstLabel(false);

        configuration.getTooltip().setShared(true);

        PlotOptionsArea plotOptions = new PlotOptionsArea();

        GradientColor fillColor = GradientColor.createLinear(0, 0, 0, 1);
        fillColor.addColorStop(0, new SolidColor(249, 221, 81));
        fillColor.addColorStop(1, new SolidColor(104, 92, 176));
        plotOptions.setFillColor(fillColor);

        plotOptions.setLineWidth(1);
        plotOptions.setShadow(false);

        Marker marker = new Marker();
        marker.setEnabled(false);
        State hoverState = new State(true);
        hoverState.setRadius(5);
        MarkerStates states = new MarkerStates(hoverState);
        marker.setStates(states);

        State hoverStateForArea = new State(true);
        hoverState.setLineWidth(1);

        plotOptions.setStates(new States(hoverStateForArea));
        plotOptions.setMarker(marker);
        plotOptions.setShadow(false);
        configuration.setPlotOptions(plotOptions);


        ListSeries ls = new ListSeries();
        PlotOptionsArea options = new PlotOptionsArea();
        options.setPointInterval(DAY_IN_MILLIS);
        ls.setPlotOptions(options);
        ls.setName("Tickets");

        if (!sortedTicketsPerDay.isEmpty())
        {
            Date date = sortedTicketsPerDay.get(0).getDate();
            options.setPointStart(date.getTime());

            ls.setData(counts.toArray(new Integer[0]));
        }
        configuration.setSeries(ls);

        chart.drawChart(configuration);

        return chart;
    }
}
