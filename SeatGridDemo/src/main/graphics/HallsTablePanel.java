package main.graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import main.data.Hall;
import main.util.Strings;

public class HallsTablePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private ArrayList<Hall> hallList;
	final JTable table;

	public HallsTablePanel(ArrayList<Hall> list) {
		super();
		setLayout(new BorderLayout());
		hallList = list;

		// tworzenie danych do tabeli
		String[] columnNames = {Strings.HEADER_HALL_ID, Strings.HEADER_HALL_MAX };
		int size = hallList.size();
		Object[][] data = new Object[size][2];
		for (int i = 0; i < size; i++) {
			data[i][0] = hallList.get(i).getHallId();
			data[i][1] = "" + hallList.get(i).getRows()
					* hallList.get(i).getSeatsInRow();
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
