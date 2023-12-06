package web.charts;

import com.cqap.client.*;
import com.vaadin.addon.charts.*;
import com.vaadin.addon.charts.model.*;
import com.vaadin.addon.charts.model.style.*;
import com.vaadin.ui.*;
import org.jetbrains.annotations.*;

@SuppressWarnings("serial")
public class TicketTypeChart
{

    private static Chart createChart(@NotNull ClientRestService clientRestService)
    {
        Long prTicketCount = clientRestService.getPRTicketCount();
        Long trTicketCount = clientRestService.getTRTicketCount();

        Chart chart = new Chart(ChartType.PIE);

        Configuration conf = chart.getConfiguration();
        conf.setTitle("Ticket Type Distribution");
        conf.getChart().setPlotBackgroundColor(new SolidColor(40, 40, 40));
        conf.getChart().setBackgroundColor(new SolidColor(40, 40, 40));

        PlotOptionsPie plotOptions = new PlotOptionsPie();
        plotOptions.setCursor(Cursor.POINTER);
        Labels dataLabels = new Labels();
        dataLabels.setEnabled(true);
        dataLabels
                .setFormatter("''+ this.point.name +': '+ this.percentage +' %'");
        plotOptions.setDataLabels(dataLabels);
        conf.setPlotOptions(plotOptions);

        final DataSeries series = new DataSeries();
        series.add(new DataSeriesItem("PR", prTicketCount));
        series.add(new DataSeriesItem("TR", trTicketCount));
        conf.setSeries(series);

        chart.addPointClickListener(new PointClickListener()
        {

            @Override
            public void onClick(PointClickEvent event)
            {
                Notification.show("Click: "
                        + series.get(event.getPointIndex()).getName());
            }
        });

        chart.drawChart(conf);

        return chart;
    }

    public static Component getChart(@NotNull ClientRestService clientRestService)
    {
        Component ret = createChart(clientRestService);
        ret.setSizeFull();

        return ret;
    }
}