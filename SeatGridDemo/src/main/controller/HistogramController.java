package main.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import main.data.Hall;
import main.model.HallEventsDataModel;
import main.view.HallHistogramPanel;
import org.jfree.data.time.Hour;
import org.jfree.data.time.TimeSeries;

/**
 * Zapewnia komunikację pomiędzy modelem i widokiem widgetu histogramu oraz
 * upublicznia API do zarządzania nim.
 *
 * @author bargosc
 */
public class HistogramController {

    private ArrayList<HallHistogramPanel> histogramPanels;

    /**
     * Tworzy obiekt kontrolera oraz inicjuje jego pola.
     */
    HistogramController() {
        this.histogramPanels = new ArrayList<>();
    }

    /**
     * [API] Dostarcza możliwości wyrenderowania na połączonych z kontrolerem
     * panelach wszystkich danych skojarzonych z daną salą.
     *
     * @param hall Sala której dane zostaną wyrenderowane
     */
    public void displayHallHistogram(Hall hall) {
        HallEventsDataModel eventsData = new HallEventsDataModel(hall);
        TimeSeries series = new TimeSeries(eventsData.getHallId());

        HashMap<Date, Double> rawData = eventsData.getData();
        for (Date date : rawData.keySet()) {
            series.add(new Hour(date), rawData.get(date));
        }

        for (HallHistogramPanel panel : histogramPanels) {
            panel.displayHallData(series);
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
}
