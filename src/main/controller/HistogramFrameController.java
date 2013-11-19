package main.controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import main.model.Event;
import main.model.EventFilter;
import main.model.Hall;
import main.model.HallEventsDataModel;
import main.view.histogram.HallHistogramFrame;
import main.view.histogram.HallHistogramPanel;
import main.view.histogram.PeriodAxisLabelSet;
import org.jfree.data.time.TimeSeries;

/**
 * Zapewnia komunikację pomiędzy modelem i widokiem histogramu oraz upublicznia
 * API do zarządzania nim.
 *
 * @author bargosc
 */
public class HistogramFrameController {

    private ArrayList<HallHistogramFrame> histogramFrames;

    /**
     * Tworzy obiekt kontrolera oraz inicjuje jego pola.
     */
    HistogramFrameController() {
        this.histogramFrames = new ArrayList<>();
    }

    /**
     * [API] Łączy dany widok z kontrolerem, przez co wszystkie akcje wykonane
     * na kontrolerze skutkować będą zmianami także w tym widoku.
     *
     * @param frame Widok który ma zostać połączony z kontrolerem.
     */
    public void addHistogramFrame(HallHistogramFrame frame) {
        this.histogramFrames.add(frame);
    }

    /**
     * Dostarcza łatwego sposobu na stworzenie i wyrenderowanie panelu
     * histogramu na podstawie przekazanego obiektu reprezentującego salę.
     *
     * @param hall Reprezentuje salę której wydarzenia mają zostać przedstawione
     * na histogramie.
     */
    public void displayHistogramPanel(Hall hall) {
        HallHistogramPanel panel = HallHistogramFactory.createPanel(hall);
        ArrayList<Event> hallEvents = hall.getEventList();
        Event[] eventArr = hallEvents.toArray(new Event[hallEvents.size()]);

        for (HallHistogramFrame frame : histogramFrames) {
            JList eventList = frame.getEventList();

            DefaultListModel<Event> model = (DefaultListModel<Event>) eventList.getModel();
            model.removeAllElements();
            for (Event event : eventArr) {
                model.addElement(event);
            }

            frame.setHistogramPanel(panel);
            frame.setHall(hall);
        }
    }

    /**
     * Ustawia wybrany zestaw etykiet osi czasu w panelu histogramu należącego
     * do przekazanego widoku.
     *
     * @param frame Widok którego panel należy zaktualizować
     * @param axisSet Wybrany zestaw etykiet osi czasu
     */
    public void handleAxisComboSelection(HallHistogramFrame frame,
                                         PeriodAxisLabelSet axisSet) {
        HallHistogramPanel panel = frame.getHistogramPanel();
        HistogramPanelController panelController = panel.getController();
        panelController.setAxisLabelSet(panel, axisSet);
    }

    /**
     * Na podstawie wybranych w widoku {@code frame} wydarzeń tworzy zawężony do
     * tych wydarzeń zbiór danych do wyrenderowania i przekazuje go do metody
     * {@link main.controller.HistogramPanelController#displayHallHistogram(main.view.histogram.HallHistogramPanel, org.jfree.data.time.TimeSeries)}.
     *
     * @param frame Widok w którym należy wyrenderować zawężony histogram
     * @param selectedEvents Lista wydarzeń które należy uwzględnić w
     * histogramie
     */
    public void handleGenerateHistogramClick(HallHistogramFrame frame,
                                             List<Event> selectedEvents) {
        Hall hall = frame.getHall();
        HallHistogramPanel panel = frame.getHistogramPanel();
        HistogramPanelController panelController = panel.getController();

        EventFilter filter = new EventFilter();
        for (Event event : selectedEvents) {
            filter.addValidId(event.getEventId());
        }

        HallEventsDataModel model = new HallEventsDataModel(hall, filter);
        TimeSeries series = panelController.getTimeSeries(model);
        panelController.displayHallHistogram(panel, series);
    }
}
