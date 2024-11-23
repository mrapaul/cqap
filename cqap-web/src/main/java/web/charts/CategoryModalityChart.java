package web.charts;

import com.cqap.client.*;
import com.peirs.datamodel.*;
import com.vaadin.addon.charts.*;
import com.vaadin.addon.charts.model.*;
import com.vaadin.addon.charts.model.style.*;
import com.vaadin.ui.*;

import web.*;

import java.util.*;


@SuppressWarnings("serial")
public class CategoryModalityChart
{
    private static Chart createChart(ClientRestService clientRestService)
    {
        Collection<CategoryDistribution>
                categoryModalityDistributions =
                clientRestService.getCategoryModalityDistributions();

        Chart chart = new Chart(ChartType.PIE);

        Configuration conf = chart.getConfiguration();
        conf.setTitle("Category & Modality Distribution");
        conf.getChart().setPlotBackgroundColor(new SolidColor(40, 40, 40));
        conf.getChart().setBackgroundColor(new SolidColor(40, 40, 40));

        YAxis yaxis = new YAxis();
        yaxis.setTitle("Total percent distribution");

        PlotOptionsPie pie = new PlotOptionsPie();
        pie.setShadow(false);
        conf.setPlotOptions(pie);

        DataSeries innerSeries = new DataSeries();
        innerSeries.setName("Modality");
        PlotOptionsPie innerPieOptions = new PlotOptionsPie();
        innerSeries.setPlotOptions(innerPieOptions);
        innerPieOptions.setSize(237);
        innerPieOptions.setDataLabels(new Labels());
        innerPieOptions.getDataLabels().setFormatter(
                "this.y > 5 ? this.point.name : null");
        innerPieOptions.getDataLabels().setColor(new SolidColor(255, 255, 255));
        innerPieOptions.getDataLabels().setDistance(-30);

        DataSeries outerSeries = new DataSeries();
        outerSeries.setName("Category");
        PlotOptionsPie outerSeriesOptions = new PlotOptionsPie();
        outerSeries.setPlotOptions(outerSeriesOptions);
        outerSeriesOptions.setInnerSize(237);
        outerSeriesOptions.setSize(318);
        outerSeriesOptions.setDataLabels(new Labels());
        outerSeriesOptions
                .getDataLabels()
                .setFormatter(
                        "this.y > 1 ? ''+ this.point.name +': '+ this.y : null");


        for (CategoryDistribution distribution : categoryModalityDistributions)
        {
            outerSeries.add(new DataSeriesItem(distribution.getCategory(), distribution.getCount()));
            Collection<ModalityDistribution> modalityDistributions = distribution.getModalityDistributions();
            for (ModalityDistribution modalityDistribution : modalityDistributions)
            {
                innerSeries.add(new DataSeriesItem(modalityDistribution.getModality(),
                        modalityDistribution.getCount()));
            }
        }
        conf.setSeries(innerSeries, outerSeries);
        chart.drawChart(conf);

        return chart;
    }

    public static Component getChart(ClientRestService clientRestService)
    {
        Component ret = createChart(clientRestService);
        ret.setSizeFull();
        return ret;
    }
}