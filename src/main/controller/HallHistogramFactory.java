package main.controller;

import javax.swing.JFrame;
import javax.swing.JPanel;
import main.model.Hall;
import main.view.histogram.HallHistogramFrame;
import main.view.histogram.HallHistogramPanel;

/**
 * Dostarcza wygodnych metod tworzenia elementów GUI wizualizacji histogramów
 * zajętości miejsc.
 *
 * @author bargosc
 */
public class HallHistogramFactory {

    /**
     * Tworzy okno zawierające histogram zajętości miejsc w sali {@code hall}.
     *
     * @param hall Sala której histogram ma zostać zwizualizowany
     * @return Obiekt klasy {@link main.view.HallHistogramFrame} zawierający
     * panel histogramu.
     */
    public static JFrame createFrame(Hall hall) {
        HistogramFrameController controller = new HistogramFrameController();
        HallHistogramFrame frame = new HallHistogramFrame(controller);

        JPanel panel = createPanel(hall);
        controller.addHistogramFrame(frame);
        controller.displayHistogramPanel(hall);

        return frame;
    }

    /**
     * Tworzy panel zawierający histogram zajętości miejsc w sali {@code hall}.
     *
     * @param hall Sala której histogram ma zostać zwizualizowany
     * @return Panel zawierający histogram.
     */
    public static HallHistogramPanel createPanel(Hall hall) {
        HistogramPanelController controller = new HistogramPanelController();
        HallHistogramPanel panel = new HallHistogramPanel(controller);

        controller.addHistogramPanel(panel);
        controller.displayHallHistogram(hall);

        return panel;
    }
}
