package main.view.histogram;

import javax.swing.JPanel;
import main.controller.HistogramPanelController;
import main.util.Strings;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.PeriodAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

/**
 * Minimalny widget zawierający histogram zajętości miejsc w sali.
 *
 * @author bargosc
 */
public class HallHistogramPanel extends JPanel {

    private final JFreeChart histogram;
    private final TimeSeriesCollection dataset;
    private final HistogramPanelController controller;
    private XYPlot plot;

    /**
     * Tworzy panel histogramu korzystający z danym kontrolerem.
     *
     * @param controller Kontroler któremu podlegać ma panel
     */
    public HallHistogramPanel(HistogramPanelController controller) {
        this.dataset = new TimeSeriesCollection();
        this.histogram = createChart();
        this.controller = controller;

        initComponents();
    }

    /**
     * Tworzy obiekt histogramu {@link org.jfree.chart.JFreeChart}. Histogram
     * zostaje ustawiony tak, by umożlić użytkownikowi komfortowe korzystanie z
     * gotowego widgetu.
     *
     * @return Stworzony obiekt histogramu
     */
    private JFreeChart createChart() {
        JFreeChart localJFreeChart = ChartFactory.createXYBarChart(
                Strings.HISTOGRAM_TITLE, // title
                Strings.HISTOGRAM_X_AXIS, // x axis
                true, // date axis
                Strings.HISTOGRAM_Y_AXIS, // y axis
                this.dataset, // dataset
                PlotOrientation.VERTICAL, // orientation
                true, // legend
                true, // tooltips
                false); // URLs

        plot = (XYPlot) localJFreeChart.getPlot();
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(true);

        setAxisLabelSet(PeriodAxisLabelSet.DETAILED_LABEL_SET);

        ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        ChartUtilities.applyCurrentTheme(localJFreeChart);
        return localJFreeChart;
    }

    /**
     * Dodaje obiekt klasy ChartPanel do widgetu.
     */
    private void initComponents() {
        ChartPanel chartPanel = new ChartPanel(this.histogram);
        this.add(chartPanel);
    }

    /**
     * Oddelegowuje przekezaną w argumencie serię danych sali do
     * {@link org.jfree.data.time.TimeSeriesCollection#addSeries(org.jfree.data.time.TimeSeries)}
     *
     * @param series Seria danych zawierająca na osi X wartości czasu, a na osi
     * Y odpowiadające im sumaryczne ilości zajętych miejsc w sali.
     */
    public void displayHallData(TimeSeries series) {
        this.dataset.addSeries(series);
    }

    /**
     * Pozwala na wyczyszczenie wyrenderowanego wykresu
     */
    public void clearHistogram() {
        this.dataset.removeAllSeries();
    }

    /*
     * Getters & setters
     */
    public HistogramPanelController getController() {
        return controller;
    }

    public void setAxisLabelSet(PeriodAxisLabelSet axisSet) {
        PeriodAxis periodAxis = new PeriodAxis(Strings.HISTOGRAM_X_AXIS);
        periodAxis.setAutoRange(true);
        periodAxis.setLabelInfo(axisSet.getLabelSet());
        plot.setDomainAxis(periodAxis);
    }
}
