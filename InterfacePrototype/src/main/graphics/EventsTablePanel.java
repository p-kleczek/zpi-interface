package main.graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import main.data.Event;
import main.util.Strings;

public class EventsTablePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private ArrayList<Event> eventList;
	final JTable table;

	public EventsTablePanel(ArrayList<Event> list) {
		super();
		setLayout(new BorderLayout());
		eventList = list;

		// tworzenie danych do tabeli
		String[] columnNames = { Strings.HEADER_HALL_ID,
				Strings.HEADER_EVENT_ID, Strings.HEADER_EVENT_DATE,
				Strings.HEADER_EVENT_ADMINISTRATOR };
		int size = eventList.size();
		Object[][] data = new Object[size][4];
		for (int i = 0; i < size; i++) {
			data[i][0] = eventList.get(i).getHallId();
			data[i][1] = eventList.get(i).getEventId();
			data[i][2] = eventList.get(i).getDate();
			data[i][3] = eventList.get(i).getAdministrator();
		}

		// tworzenie tabeli
		table = new JTable(data, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(300, 400));
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);

		setVisible(true);
	}
}
