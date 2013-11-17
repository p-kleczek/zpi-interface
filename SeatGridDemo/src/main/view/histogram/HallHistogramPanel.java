package main.view.histogram;

import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import main.controller.HistogramController;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.PeriodAxis;
import org.jfree.chart.axis.PeriodAxisLabelInfo;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;

/**
 * Minimalny widget zawierający histogram zajętości miejsc w sali.
 *
 * @author bargosc
 */
public class HallHistogramPanel extends JPanel {

    /**
     * Daje możliwość łatwej zmiany dokładności opisu osi czasu wykresu na
     * najdokładniejszą (co do minuty). Wartość domyślna.
     */
    public static final PeriodAxisLabelSet DETAILED_LABEL_SET = new PeriodAxisLabelSet(
            new PeriodAxisLabelInfo(Hour.class, new SimpleDateFormat("HH:mm")),
            new PeriodAxisLabelInfo(Day.class, new SimpleDateFormat("d MMMM yyyy")));
    /**
     * Daje możliwość łatwej zmiany dokładności opisu osi czasu wykresu na mniej
     * dokładną (co do dnia).
     */
    public static final PeriodAxisLabelSet NORMAL_LABEL_SET = new PeriodAxisLabelSet(
            new PeriodAxisLabelInfo(Day.class, new SimpleDateFormat("d")),
            new PeriodAxisLabelInfo(Month.class, new SimpleDateFormat("MMMM yyyy")));
    /**
     * Daje możliwość łatwej zmiany dokładności opisu osi poziomej wykresu na
     * taką, by pokryła większy przedział czasu (miesiące).
     */
    public static final PeriodAxisLabelSet BIG_PERIODS_LABEL_SET = new PeriodAxisLabelSet(
            new PeriodAxisLabelInfo(Month.class, new SimpleDateFormat("MMM")),
            new PeriodAxisLabelInfo(Year.class, new SimpleDateFormat("yyyy")));
    // end of public constants declaration
    private final static String HISTOGRAM_TITLE = "Ilość zajętych miejsc";
    private final static String HISTOGRAM_X_AXIS = "Czas";
    private final static String HISTOGRAM_Y_AXIS = "Zajęte miejsca";
    // end of private constants declaration
    private final JFreeChart histogram;
    private final TimeSeriesCollection dataset;
    private final HistogramController controller;

    /**
     * Tworzy panel histogramu na podstawie danych zawartych w obiekcie
     * {@code hall}.
     *
     * @param hall Obiekt reprezentujący salę której histogram zajętości miejsc
     * zostanie zwizualizowany.
     */
    public HallHistogramPanel(HistogramController controller) {
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
                HISTOGRAM_TITLE, // title
                HISTOGRAM_X_AXIS, // x axis
                true, // date axis
                HISTOGRAM_Y_AXIS, // y axis
                this.dataset, // dataset
                PlotOrientation.VERTICAL, // orientation
                true, // legend
                true, // tooltips
                false); // URLs

        XYPlot plot = (XYPlot) localJFreeChart.getPlot();
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(true);

        PeriodAxis periodAxis = new PeriodAxis(HISTOGRAM_X_AXIS);
        periodAxis.setAutoRange(true);
        periodAxis.setLabelInfo(DETAILED_LABEL_SET.getLabelSet());

        ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        plot.setDomainAxis(periodAxis);


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

    /*
     * Getters & setters
     */
    public HistogramController getController() {
        return controller;
    }
}
