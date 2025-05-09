package web;

import com.vaadin.addon.charts.model.*;
import com.vaadin.addon.charts.model.style.*;

@SuppressWarnings("serial")
public class ValoDarkTheme extends Theme
{

    protected static final int BORDER_RADIUS = 5;
    protected final static SolidColor COLOR1 = new SolidColor(48, 144, 240);
    protected final static SolidColor COLOR2 = new SolidColor(236, 100, 100);
    protected final static SolidColor COLOR3 = new SolidColor(152, 223, 88);
    protected final static SolidColor COLOR4 = new SolidColor(249, 221, 81);
    protected final static SolidColor COLOR5 = new SolidColor(36, 220, 212);
    protected final static SolidColor COLOR6 = new SolidColor(236, 100, 165);
    protected final static SolidColor COLOR7 = new SolidColor(104, 92, 176);
    protected final static SolidColor COLOR8 = new SolidColor(255, 125, 66);
    protected final static SolidColor COLOR9 = new SolidColor(51, 97, 144);
    protected final static SolidColor COLOR10 = new SolidColor(170, 81, 77);
    protected final static SolidColor COLOR11 = new SolidColor(127, 176, 83);
    protected final static SolidColor COLOR12 = new SolidColor(187, 168, 91);
    protected final static SolidColor COLOR13 = new SolidColor(36, 121, 129);
    protected final static SolidColor COLOR14 = new SolidColor(150, 57, 112);
    protected final static SolidColor COLOR15 = new SolidColor(75, 86, 168);
    protected final static SolidColor COLOR16 = new SolidColor(154, 89, 61);

    protected final static SolidColor TITLE_COLOR = new SolidColor(255, 255,
            255);
    protected final static SolidColor TOOLTIP_TEXT_COLOR = new SolidColor(51,
            51, 51);
    protected final static SolidColor TOOLTIP_BACKGROUND_COLOR = new SolidColor(
            255, 255, 255, 0.9);
    protected final static SolidColor SUBTITLE_COLOR = new SolidColor(201, 201,
            201);
    protected final static SolidColor LINE_COLOR = new SolidColor(54, 54, 54);
    protected final static SolidColor TEXT_COLOR = new SolidColor(148, 148, 148);
    protected final static SolidColor GRID_COLOR = new SolidColor(250, 250, 250);
    protected final static SolidColor LABEL_COLOR = new SolidColor(148, 148,
            148);

    protected final static SolidColor BGCOLOR = new SolidColor(40, 40, 40);
    protected final static SolidColor BGCOLOR_LIGHT_GRAY = new SolidColor(0, 0,
            0, 0.02);
    protected final static SolidColor TRANSPARENT_COLOR = new SolidColor(255,
            255, 255, 0.0);

    protected final static String DEFAULT_FONT_FAMILIES = "Open Sans, Helvetica Neue, Arial, sans-serif";
    protected static final Color LEGEND_TEXT_COLOR = new SolidColor(155, 155,
            155);

    public ValoDarkTheme() {
        setColors(COLOR1, COLOR2, COLOR3, COLOR4, COLOR5, COLOR6, COLOR7,
                COLOR8, COLOR9, COLOR10, COLOR11, COLOR12, COLOR13, COLOR14,
                COLOR15, COLOR16);
        Style style = new Style();
        style.setFontFamily(DEFAULT_FONT_FAMILIES);
        style.setFontSize("14px");
        getChart().setStyle(style);

        getTitle().setColor(TITLE_COLOR);
        getTitle().setFontSize("26px");
        getTitle().setFontWeight(FontWeight.NORMAL);

        getSubtitle().setColor(SUBTITLE_COLOR);
        getSubtitle().setFontWeight(FontWeight.NORMAL);
        getSubtitle().setFontSize("14px");

        getChart().setClassName("vaadin-chart");
        getChart().setPlotBackgroundColor(TRANSPARENT_COLOR);
        getChart().setPlotBackgroundImage("");
        getChart().setPlotBorderColor(TRANSPARENT_COLOR);
        getChart().setBackgroundColor(BGCOLOR);
        getChart().setPlotBorderWidth(0);
        getChart().setBorderRadius(0);
        getChart().setPlotShadow(false);

        setAxisDefaults(getxAxis());

        setAxisDefaults(getyAxis());

        getTooltip().setBackgroundColor(TOOLTIP_BACKGROUND_COLOR);
        getTooltip().setBorderWidth(0);
        getTooltip().setBorderRadius(BORDER_RADIUS);
        getTooltip().getStyle().setColor(TOOLTIP_TEXT_COLOR);

        getLegend().getItemStyle().setColor(LEGEND_TEXT_COLOR);
        getLegend().getItemStyle().setFontWeight(FontWeight.NORMAL);
        getLegend().getItemStyle().setFontSize("14px");
        Style itemHoverStyle = new Style();
        itemHoverStyle.setColor(LEGEND_TEXT_COLOR);
        getLegend().setItemHoverStyle(itemHoverStyle);
        getLegend().setItemHiddenStyle(new Style());
        getLegend().getItemHiddenStyle()
                .setColor(new SolidColor(128, 128, 128));
        getLegend().setBorderRadius(BORDER_RADIUS);
        getLegend().setBorderColor(LINE_COLOR);
        getLegend().setBackgroundColor(new SolidColor(40, 40, 40, 0.9));

        getLabels().setColor(TEXT_COLOR);

        getCredits().setStyle(new Style());
        getCredits().getStyle().setFontSize("14px");
        getCredits().getStyle().setColor(new SolidColor(128, 128, 128));
        getCredits().setText("");
        getCredits().setHref("");

        getyAxis().setMinorTickInterval(TickIntervalStyle.NONE);
        getyAxis().setAlternateGridColor(new SolidColor(50, 50, 50));
        getyAxis().setGridLineColor(LINE_COLOR);
        getyAxis().setGridLineWidth(0);

        getxAxis().setGridLineColor(LINE_COLOR);
        getxAxis().setGridLineWidth(0);

        // Shadows on by default, off in range stuff
        getPlotOptions().getArearange().setShadow(false);
        getPlotOptions().getAreasplinerange().setShadow(false);
        getPlotOptions().getLine().setShadow(false);
        getPlotOptions().getSpline().setShadow(false);
        getPlotOptions().getBar().setShadow(false);
        getPlotOptions().getColumn().setShadow(false);
        getPlotOptions().getArea().setShadow(false);
        getPlotOptions().getPie().setShadow(false);

        getPlotOptions().getPie().setBorderWidth(0);
        getPlotOptions().getColumn().setBorderWidth(0);
        getPlotOptions().getColumn().setPointPadding(0);
        getPlotOptions().getBar().setBorderWidth(0);
        getPlotOptions().getBar().setPointPadding(0);

        setDataLabelsDefaults(getPlotOptions().getBar());
        setDataLabelsDefaults(getPlotOptions().getColumn());
        setDataLabelsDefaults(getPlotOptions().getLine());
        setDataLabelsDefaults(getPlotOptions().getPie());
        setDataLabelsDefaults(getPlotOptions().getArearange());
        setDataLabelsDefaults(getPlotOptions().getAreasplinerange());
        setDataLabelsDefaults(getPlotOptions().getSpline());
        setDataLabelsDefaults(getPlotOptions().getBar());

        State state = new State(false);
        getPlotOptions().getPie().setStates(new States(state));
    }

    protected void setDataLabelsDefaults(AbstractPlotOptions plotOptions) {
        Labels labels = new Labels();
        labels.setColor(TEXT_COLOR);
        labels.getStyle().setFontFamily(DEFAULT_FONT_FAMILIES);
        labels.getStyle().setFontSize("12px");
        plotOptions.setDataLabels(labels);
    }

    protected void setAxisDefaults(AxisStyle style) {
        style.setGridLineColor(GRID_COLOR);
        style.setLineColor(GRID_COLOR);
        style.setLineWidth(0);
        style.setTickWidth(0);
        style.setTickColor(new SolidColor(192, 208, 224));

        style.setAlternateGridColor(new SolidColor(255, 255, 255, 0.0));

        style.getTitle().setColor(TEXT_COLOR);
        style.getTitle().setFontWeight(FontWeight.BOLD);

        style.getSubtitle().setColor(SUBTITLE_COLOR);
        style.getSubtitle().setFontSize("14px");
        style.getSubtitle().setFontWeight(FontWeight.NORMAL);

        style.getLabels().setFontWeight(FontWeight.NORMAL);
        style.getLabels().setColor(LABEL_COLOR);
        style.getLabels().setFontSize("14px");
    }

}