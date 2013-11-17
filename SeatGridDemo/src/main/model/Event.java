package main.model;

import java.util.ArrayList;

import java.util.Calendar;
import main.util.Log;
import main.util.Settings;

/**
 * Klasa reprezentujaca wydarzenie na sali. W podejsiu do skladowania danych o
 * umiejscowieniu ludzi na sali mialem kilka pomyslow:
 * 
 * 1) boolean[][] - latwy odczyt, ale ciezko potem rozszerzyc dzialanie aby
 * uwzglednialo nieregularny ksztalt sali
 * 
 * 2) ArrayList<ArrayList<Character>> - podwojna lista znakow, gdzie kazdy
 * oznaczalby zajete/wolne/niedostepne. Nie lubie podwojnych list, robia
 * niepotrzebne zamieszanie
 * 
 * 3) ArrayList<String> - tutaj kazdy rzad to jeden string. Latwy dostep do
 * konkretnych rzedow i rzedy moga byc roznej szerokosci, wiec mozna kiedys
 * rozszerzyc do obslugi nieregularnych ksztaltow sal
 * 
 * Wybralem opcje 3.
 */

public class Event {

	private String hallId;
	private int eventId;
	private String date;
	private String administrator;
	private ArrayList<String> seatLayout;

	public Event(int eventId, ArrayList<String> seats) {
		super();
		this.setEventId(eventId);
		this.seatLayout = seats;
	}

	public Character getSeat(int row, int seatNumber) {
		return seatLayout.get(row).charAt(seatNumber);
	}

	public boolean isSeatTaken(int row, int seatNumber) {
		if (getSeat(row, seatNumber).equals(Settings.TAKEN))
			return true;
		else if (getSeat(row, seatNumber).equals(Settings.FREE))
			return false;
		else
			return false;
	}

	public void printSeatLayout() {
		Log.post("seatLayout:");
		for (String s : seatLayout) {
			Log.post(s);
		}
	}

	// zwykle settery i gettery

	public ArrayList<String> getSeatLayout() {
		return seatLayout;
	}

	public String getHallId() {
		return hallId;
	}

	public void setHallId(String hallId) {
		this.hallId = hallId;
	}

	public String getAdministrator() {
		return administrator;
	}

	public void setAdministrator(String administrator) {
		this.administrator = administrator;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = "" + date.get(Calendar.DAY_OF_MONTH) + "-"
				+ (date.get(Calendar.MONTH) + 1) + "-"
				+ date.get(Calendar.YEAR);
	}

}
