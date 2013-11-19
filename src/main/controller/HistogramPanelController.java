package main.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import main.model.Hall;
import main.model.HallEventsDataModel;
import main.view.histogram.HallHistogramPanel;
import main.view.histogram.PeriodAxisLabelSet;
import org.jfree.data.time.Hour;
import org.jfree.data.time.TimeSeries;

/**
 * Zapewnia komunikację pomiędzy modelem i widokiem widgetu histogramu oraz
 * upublicznia API do zarządzania nim.
 *
 * @author bargosc
 */
public class HistogramPanelController {

    private ArrayList<HallHistogramPanel> histogramPanels;

    /**
     * Tworzy obiekt kontrolera oraz inicjuje jego pola.
     */
    HistogramPanelController() {
        this.histogramPanels = new ArrayList<>();
    }

    /**
     * [API] Dostarcza możliwości wyrenderowania na danym panelu danych
     * zawartych w obiekcie TimeSeries.
     *
     * @param panel Panel na którym mają zostać wyrenderowane dane
     * @param series Dane do wyrenderowania
     */
    public void displayHallHistogram(HallHistogramPanel panel,
                                     TimeSeries series) {
        panel.clearHistogram();
        panel.displayHallData(series);
    }

    /**
     * [API] Dostarcza możliwości wyrenderowania na danym panelu wszystkich
     * danych skojarzonych z daną salą.
     *
     * @param panel Panel na którym mają zostać wyrenderowane dane
     * @param hall Sala której dane zostaną wyrenderowane
     */
    public void displayHallHistogram(HallHistogramPanel panel, Hall hall) {
        HallEventsDataModel model = new HallEventsDataModel(hall);
        TimeSeries series = getTimeSeries(model);
        displayHallHistogram(panel, series);
    }

    /**
     * [API] Dostarcza możliwości wyrenderowania na połączonych z kontrolerem
     * panelach wszystkich danych skojarzonych z daną salą.
     *
     * @param hall Sala której dane zostaną wyrenderowane
     */
    public void displayHallHistogram(Hall hall) {
        HallEventsDataModel model = new HallEventsDataModel(hall);
        TimeSeries series = getTimeSeries(model);

        for (HallHistogramPanel panel : histogramPanels) {
            displayHallHistogram(panel, series);
        }
    }

    /**
     * [API] Łączy dany panel z kontrolerem, przez co wszystkie akcje wykonane
     * na kontrolerze skutkować będą zmianami także w tym widoku.
     *
     * @param panel Panel który ma zostać połączony z kontrolerem.
     */
    public void addHistogramPanel(HallHistogramPanel panel) {
        this.histogramPanels.add(panel);
    }

    /**
     * [API] Dostarcza możliwości ustawienia na połączonych z kontrolerem
     * panelach danego zestawu skal czasu.
     *
     * @param axisSet Zestaw skal czasu
     */
    public void setAxisLabelSet(PeriodAxisLabelSet axisSet) {
        for (HallHistogramPanel panel : histogramPanels) {
            setAxisLabelSet(panel, axisSet);
        }
    }

    /**
     * [API] Dostarcza możliwości ustawienia na wybranym panelu danego zestawu
     * skal czasu.
     *
     * @param panel Panel na którym ma zostać ustawiony zestaw skal czasu
     * @param axisSet Zestaw skal czasu
     */
    public void setAxisLabelSet(HallHistogramPanel panel,
                                PeriodAxisLabelSet axisSet) {
        panel.setAxisLabelSet(axisSet);
    }

    /**
     * [API] Pozwala na stworzenie obiektu TimeSeries potrzebnego do
     * wyrenderowania histogramu.
     *
     * @param eventsData Dane dotyczące wydarzeń
     * @return Obiekt typu TimeSeries reprezentujący daty/czasy wydarzeń i
     * korespondujące z nimi wartości zajętości miejsc w sali
     */
    public TimeSeries getTimeSeries(HallEventsDataModel eventsData) {
        TimeSeries series = new TimeSeries(eventsData.getHallId());
        HashMap<Date, Double> rawData = eventsData.getData();
        for (Date date : rawData.keySet()) {
            series.add(new Hour(date), rawData.get(date));
        }
        return series;
    }
}
