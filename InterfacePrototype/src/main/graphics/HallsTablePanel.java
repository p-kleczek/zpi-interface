package main.graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import main.data.Hall;
import main.util.Log;
import main.util.Strings;

/**
 * Analogiczne dzialanie do EventTablePanel. Dodatkowa funkcja to pokazanie
 * przycisku wyswietlajacego HallFrame gdy uzytkownik kliknie na element
 * tabeli.
 * 
 * @author Mateusz
 * 
 */

public class HallsTablePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private ArrayList<Hall> hallList;
	final JTable table;
	private ManageHallsFrame frame;

	public HallsTablePanel(ManageHallsFrame parentFrame, ArrayList<Hall> list) {
		super();
		setLayout(new BorderLayout());
		hallList = list;
		frame = parentFrame;

		// tworzenie danych do tabeli
		String[] columnNames = { Strings.HEADER_HALL_ID,
				Strings.HEADER_HALL_MAX };
		int size = hallList.size();
		Object[][] data = new Object[size][2];
		for (int i = 0; i < size; i++) {
			data[i][0] = hallList.get(i).getHallId();
			data[i][1] = "" + hallList.get(i).getRows()
					* hallList.get(i).getSeatsInRow();
		}

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

		// nasluchuj klikania na elementy tabeli
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel rowSM = table.getSelectionModel();
		rowSM.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				ListSelectionModel lsm = (ListSelectionModel) e.getSource();
				if (lsm.isSelectionEmpty()) {
					Log.post("No rows are selected.");
					frame.hideSeatGridButton();
					frame.setSelectedRow(-1);
				} else {
					int selectedRow = lsm.getMinSelectionIndex();
					Log.post("Row " + selectedRow + " is now selected.");
					frame.setDetailText(selectedRow);
					frame.showSeatGridButton();
					frame.setSelectedRow(selectedRow);
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);

		setVisible(true);
	}

}
