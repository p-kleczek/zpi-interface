package main.view;

import org.jfree.chart.axis.PeriodAxisLabelInfo;

/**
 * Umożliwia łatwe tworzenie oraz przechowywanie struktur wymaganych przez
 * JFreeChart do opisu osi przedziałów czasu.
 *
 * @author bargosc
 */
public class PeriodAxisLabelSet {

    private final PeriodAxisLabelInfo[] labelSet;

    /**
     * Tworzy obiekt inicjując go wszystkimi podanymi wartościami.
     *
     * @param labelSet Obiekty klasy
     * {@link org.jfree.chart.axis.PeriodAxisLabelInfo} reprezentujące kolejne
     * poziomy osi
     */
    PeriodAxisLabelSet(PeriodAxisLabelInfo... labelSet) {
        this.labelSet = labelSet;
    }

    // Getters & setters
    PeriodAxisLabelInfo[] getLabelSet() {
        return labelSet;
    }
}