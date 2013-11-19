package main.view;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import main.model.Hall;
import main.util.Strings;

/**
 * Analogiczne dzialanie do EventDetailPanel.
 *
 * @author Mateusz
 *
 */
public class HallDetailPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    JTextArea text;

    public HallDetailPanel() {
        super();
        setLayout(new BorderLayout());
        text = new JTextArea();
        text.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(text);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public void setupText(Hall hall) {
        text.setText("");
        text.append(Strings.DETAIL_HALL_TITLE + "\n");
        text.append("---------------" + "\n");
        text.append(Strings.DETAIL_HALL_ID + hall.getHallId() + "\n");
        text.append(
                Strings.DETAIL_HALL_MAX + hall.getRows() * hall.getSeatsInRow() + "\n");
        text.append(
                Strings.DETAIL_HALL_NUM_OF_EVENTS + hall.getEventList().size() + "\n");
    }
}
