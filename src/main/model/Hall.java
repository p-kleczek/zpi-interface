package main.model;

import java.util.ArrayList;

/**
 * Klasa reprezentujaca sale wykladowa. Zawiera liste eventow oraz podstawowe
 * info o ilosci rzedow i liczbie miejsc w rzedach. Na razie podejscie
 * uproszczone, trzeba bedzie rozszerzyc jesli zrobimy nieregularny uklad sali.
 * 
 */

public class Hall {

	private String hallId;
	private ArrayList<Event> eventList;
	private int rows;
	private int seatsInRow;

	public Hall(String hallId, int rows, int seatsInRow) {
		this.setHallId(hallId);
		this.rows = rows;
		this.seatsInRow = seatsInRow;
		eventList = new ArrayList<Event>();
	}

	public ArrayList<Event> getEventList() {
		return eventList;
	}

	public void addEvent(Event event) {
		event.setHallId(hallId);
		eventList.add(event);
	}

	public int getSeatsInRow() {
		return seatsInRow;
	}

	public void setSeatsInRow(int seatsInRow) {
		this.seatsInRow = seatsInRow;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getHallId() {
		return hallId;
	}

	public void setHallId(String hallId) {
		this.hallId = hallId;
	}

}
