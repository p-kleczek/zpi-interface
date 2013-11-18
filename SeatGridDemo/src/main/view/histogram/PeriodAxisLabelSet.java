package main.view.histogram;

import java.text.SimpleDateFormat;
import main.util.Strings;
import org.jfree.chart.axis.PeriodAxisLabelInfo;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.Month;
import org.jfree.data.time.Year;

/**
 * Umożliwia łatwe tworzenie oraz przechowywanie zestawów struktur wymaganych
 * przez JFreeChart do opisu osi przedziałów czasu.
 *
 * @author bargosc
 */
public class PeriodAxisLabelSet {

    /**
     * Daje możliwość łatwej zmiany dokładności opisu osi czasu wykresu na
     * najdokładniejszą (co do minuty). Wartość domyślna.
     */
    public static final PeriodAxisLabelSet DETAILED_LABEL_SET = new PeriodAxisLabelSet(
            Strings.DETAILED_LABEL_SET_NAME,
            new PeriodAxisLabelInfo(Hour.class, new SimpleDateFormat("HH:mm")),
            new PeriodAxisLabelInfo(Day.class, new SimpleDateFormat("d MMMM yyyy")));
    /**
     * Daje możliwość łatwej zmiany dokładności opisu osi czasu wykresu na mniej
     * dokładną (co do dnia).
     */
    public static final PeriodAxisLabelSet NORMAL_LABEL_SET = new PeriodAxisLabelSet(
            Strings.NORMAL_LABEL_SET_NAME,
            new PeriodAxisLabelInfo(Day.class, new SimpleDateFormat("d")),
            new PeriodAxisLabelInfo(Month.class, new SimpleDateFormat("MMMM yyyy")));
    /**
     * Daje możliwość łatwej zmiany dokładności opisu osi poziomej wykresu na
     * taką, by pokryła większy przedział czasu (miesiące).
     */
    public static final PeriodAxisLabelSet BIG_PERIODS_LABEL_SET = new PeriodAxisLabelSet(
            Strings.BIG_PERIODS_LABEL_SET_NAME,
            new PeriodAxisLabelInfo(Month.class, new SimpleDateFormat("MMM")),
            new PeriodAxisLabelInfo(Year.class, new SimpleDateFormat("yyyy")));
    // end of public constants declaration
    private final String name;
    private final PeriodAxisLabelInfo[] labelSet;

    /**
     * Tworzy obiekt inicjując go wszystkimi podanymi wartościami.
     *
     * @param name Nazwa zestawu
     * @param labelSet Obiekty klasy
     * {@link org.jfree.chart.axis.PeriodAxisLabelInfo} reprezentujące kolejne
     * poziomy osi
     */
    PeriodAxisLabelSet(String name, PeriodAxisLabelInfo... labelSet) {
        this.name = name;
        this.labelSet = labelSet;
    }

    // Getters & setters
    public String getName() {
        return name;
    }

    PeriodAxisLabelInfo[] getLabelSet() {
        return labelSet;
    }
}