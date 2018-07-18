package com.agit.crm.main.viewmodel.customer.feedback;

import org.zkoss.chart.Chart;
import org.zkoss.chart.Charts;
import org.zkoss.chart.Point;
import org.zkoss.chart.Series;
import org.zkoss.chart.Tooltip;
import org.zkoss.chart.plotOptions.PiePlotOptions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Window;

/**
 *
 * @author lintang
 */
public class PieDonutComposer extends SelectorComposer<Window> {

    @Wire
    Charts chart;

    @Wire
    Charts chart2;

    @Wire
    Charts chart1;

    public void doAfterCompose(Window comp) throws Exception {
        super.doAfterCompose(comp);

        //chart Pie 1
        Chart chartOptional = chart.getChart();
        chartOptional.setPlotBorderWidth(0);
        chartOptional.setPlotShadow(false);

        chart.getTooltip().setPointFormat(
                "{series.name}: <b>{point.percentage:.1f}%</b>");

        PiePlotOptions plotOptions = chart.getPlotOptions().getPie();
        plotOptions.setAllowPointSelect(true);
        plotOptions.setCursor("pointer");
        plotOptions.getDataLabels().setEnabled(false);
        plotOptions.setShowInLegend(true);

        Series series = chart.getSeries();
        series.setType("pie");
        series.setName("Browser share");
        series.addPoint(new Point("Sangat Puas", 45.0));
        series.addPoint(new Point("Puas", 26.8));
        Point point = new Point("Kurang Puas", 12.8);
        point.setSliced(true);
        point.setSelected(true);
        series.addPoint(point);
        series.addPoint(new Point("Kecewa", 8.5));
        series.addPoint(new Point("Bingung", 8.5));

        //chart Pie 2
        Chart chartOptional1 = chart1.getChart();
        chartOptional1.setPlotBorderWidth(0);
        chartOptional1.setPlotShadow(false);

        chart1.getTooltip().setPointFormat(
                "{series.name}: <b>{point.percentage:.1f}%</b>");

        PiePlotOptions plotOptions1 = chart1.getPlotOptions().getPie();
        plotOptions1.setAllowPointSelect(true);
        plotOptions1.setCursor("pointer");
        plotOptions1.getDataLabels().setEnabled(false);
        plotOptions1.setShowInLegend(true);

        Series series1 = chart1.getSeries();
        series1.setType("pie");
        series1.setName("Browser share");
        series1.addPoint(new Point("Sangat Puas", 45.0));
        series1.addPoint(new Point("Puas", 26.8));
        Point point1 = new Point("Kurang Puas", 12.8);
        point1.setSliced(true);
        point1.setSelected(true);
        series1.addPoint(point);
        series1.addPoint(new Point("Kecewa", 8.5));
        series1.addPoint(new Point("Bingung", 8.5));

        //chart batang
        super.doAfterCompose(comp);
        chart2.setModel(ColumnBasicData.getCategoryModel());

        chart2.getXAxis().setCrosshair(true);

        chart2.getYAxis().setMin(0);
        chart2.getYAxis().getTitle().setText("Total");

        Tooltip tooltip = chart.getTooltip();
        tooltip.setHeaderFormat("<span style=\"font-size:10px\">{point.key}</span><table>");
        tooltip.setPointFormat("<tr><td style=\"color:{series.color};padding:0\">{series.name}: </td>"
                + "<td style=\"padding:0\"><b>{point.y:.1f} mm</b></td></tr>");
        tooltip.setFooterFormat("</table>");
        tooltip.setShared(true);
        tooltip.setUseHTML(true);

        chart.getPlotOptions().getColumn().setPointPadding(0.2);
        chart.getPlotOptions().getColumn().setBorderWidth(0);
    }
}
