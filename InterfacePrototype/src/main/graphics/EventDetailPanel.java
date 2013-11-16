package main.graphics;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import main.data.Event;
import main.util.Strings;

/**
 * JPanel wyswietlajacy szczegoly eventu po kliknieciu na jakis element tabeli
 * eventow. Nie ma tutaj fukcjonalnosci klikania (to jest zaimplemetowane w
 * samej tabeli - patrz EventTablePanel).
 * 
 * @author Mateusz
 * 
 */

public class EventDetailPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	JTextArea text;

	public EventDetailPanel() {
		super();
		setLayout(new BorderLayout());
		text = new JTextArea();
		text.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(text);
		add(scrollPane, BorderLayout.CENTER);

		setVisible(true);
	}

	public void setupText(Event event) {
		text.setText("");
		text.append(Strings.DETAIL_EVENT_TITLE + "\n");
		text.append("---------------" + "\n");
		text.append(Strings.DETAIL_EVENT_ID + event.getEventId() + "\n");
		text.append(Strings.DETAIL_HALL_ID + event.getHallId() + "\n");
		text.append(Strings.DETAIL_EVENT_DATE + event.getDate() + "\n");
		text.append(Strings.DETAIL_EVENT_ADMINISTRATOR
				+ event.getAdministrator() + "\n");
	}

}
