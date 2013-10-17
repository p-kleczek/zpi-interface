package main.graphics;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import main.data.Event;
import main.data.Hall;
import main.util.Log;

/**
 * Klasa wizualizujaca sale. Pobiera sale i na podstawie eventow w tej sali
 * generuje siatke miejsc oraz ich uzytkowanie na przestrzeni tych eventow.
 * 
 * Obecna kalkulacja uzytkowania jest uproszczona, bo operuje na zwyklej
 * podwojnej tabeli. Jesli rozszerzymy uzytkowanie na nieregularne sale,
 * usprawnie kalkulacje na bardziej uniwersalna.
 * 
 * Do zrobienia: Oznaczenie gdzie jest przod/tyl sali, wypisywanie numerow
 * miejsc, zrobienie jakiegos menu. Nie robilem tego, bo chce zobaczyc, czy
 * takie podejscie jest wogole wedlug Was sensowne.
 */
public class GridFrame extends JFrame {

	ArrayList<Event> eventList;
	int rows;
	int maxSeatsInRow;
	private static final long serialVersionUID = 1L;
	float usageTable[][];
	int timesSeatTaken[][];

	public GridFrame(Hall hall) {
		super();
		Log.post("Initialize GridFrame");

		// save parameters
		eventList = hall.getEventList();
		rows = hall.getRows();
		maxSeatsInRow = hall.getSeatsInRow();
		Log.post("rows = " + rows);
		Log.post("maxSeatsInRow = " + maxSeatsInRow);

		// generate grid
		calculateUsage();
		setupGrid();

		// show
		setTitle("GridFrame");
		setSize(800, 400);
		setVisible(true);
	}

	public void calculateUsage() {
		timesSeatTaken = new int[rows][maxSeatsInRow];
		int numberOfEvents = eventList.size();
		Log.post("numberOfEvents = " + numberOfEvents);
		// check how many times each seat was used
		for (Event event : eventList) {
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < maxSeatsInRow; j++) {
					Character seat = event.getSeat(i, j);
					if (seat == 'x')
						timesSeatTaken[i][j]++;
				}
			}
		}

		printTimesSeatTaken();

		// generate usageTable (from 0.0 to 1.0 values)
		usageTable = new float[rows][maxSeatsInRow];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < maxSeatsInRow; j++) {
				usageTable[i][j] = (float) timesSeatTaken[i][j]
						/ numberOfEvents;
			}
		}
		
		printUsageTable();
	}

	public void setupGrid() {
		//add all the seats
		setLayout(new GridLayout(rows, maxSeatsInRow));
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < maxSeatsInRow; j++) {
				add(new SeatPanel(usageTable[i][j]));
			}
		}

	}

	public void printUsageTable() {
		Log.post("Usage Table:");
		for (int i = 0; i < rows; i++) {
			String row = "";
			for (int j = 0; j < maxSeatsInRow; j++) {
				row = row + usageTable[i][j] + "  ";
			}
			Log.post(row);
		}
	}

	public void printTimesSeatTaken() {
		Log.post("Times seat taken:");
		for (int i = 0; i < rows; i++) {
			String row = "";
			for (int j = 0; j < maxSeatsInRow; j++) {
				row = row + timesSeatTaken[i][j] + "  ";
			}
			Log.post(row);
		}
	}
}
