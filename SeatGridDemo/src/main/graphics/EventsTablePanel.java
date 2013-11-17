package main.graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import main.data.Event;
import main.util.Strings;

/**
 * JPanel zawierajacy tabele z eventami. Klikanie odpowiednich elementow
 * uruchamia wyswietlanie szczegolow na innym panelu (EventDetailPanel).
 * 
 * @author Mateusz
 * 
 */

public class EventsTablePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private ArrayList<Event> eventList;
	final JTable table;
	private ManageEventsFrame frame;

	public EventsTablePanel(ManageEventsFrame parentFrame, ArrayList<Event> list) {
		super();
		setLayout(new BorderLayout());
		eventList = list;
		frame = parentFrame;

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
		// tworzenie tabeli oraz blokowanie edycji pól
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		table = new JTable(model) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false; // Disallow the editing of any cell
			}
		};
		table.setPreferredScrollableViewportSize(new Dimension(300, 400));
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel rowSM = table.getSelectionModel();
		rowSM.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				// Ignore extra messages.
				if (e.getValueIsAdjusting())
					return;

				ListSelectionModel lsm = (ListSelectionModel) e.getSource();
				if (lsm.isSelectionEmpty()) {
					System.out.println("No rows are selected.");
				} else {
					int selectedRow = lsm.getMinSelectionIndex();
					System.out.println("Row " + selectedRow
							+ " is now selected.");
					// wyswietl szczegoly w polu odpowiedniego frame'a
					frame.setDetailText(selectedRow);
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);

		setVisible(true);
	}
}
