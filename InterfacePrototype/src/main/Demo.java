package main;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import main.data.Event;
import main.data.Hall;
import main.graphics.MainFrame;

/**
 * Klasa demostracyjna. Posiada tylko metode main, by uruchomic pokaz dzialania
 * pozostalych klas. W mainie tworzymy sale, dodajemy do niej sztuczne eventy i
 * uruchamiamy GridFrame, ktory wizualizuje sale oraz jej uzycie na przestrzeni
 * eventow.
 */

public class Demo {

	public static void main(String[] args) {

		// basic setup
		
		ArrayList<Hall> hallList = new ArrayList<Hall>();
		Hall testHall = new Hall("H24", 5, 10);
		Event event;
		ArrayList<String> seatLayout;
		int eventId = 1;

		// generate fake data
		seatLayout = new ArrayList<String>();
		seatLayout.add("oooooxoooo");
		seatLayout.add("ooooxooooo");
		seatLayout.add("ooxooxxooo");
		seatLayout.add("xxxxooxoxx");
		seatLayout.add("xoxxxoxxxx");
		event = new Event(eventId++, seatLayout);
		event.setDate(new GregorianCalendar(2013, 10, 1, 10, 0));
		testHall.addEvent(event);

		seatLayout = new ArrayList<String>();
		seatLayout.add("oxxooxoooo");
		seatLayout.add("oxooooooxo");
		seatLayout.add("xxoooxxooo");
		seatLayout.add("xxxxxoxoxx");
		seatLayout.add("xoooooxxxx");
		event = new Event(eventId++, seatLayout);
		event.setDate(new GregorianCalendar(2013, 10, 1, 11, 30));
		testHall.addEvent(event);

		seatLayout = new ArrayList<String>();
		seatLayout.add("xxxxxxoooo");
		seatLayout.add("ooooxoooox");
		seatLayout.add("ooxooooooo");
		seatLayout.add("xxxxxxxxxx");
		seatLayout.add("xoxxxoxxxx");
		event = new Event(eventId++, seatLayout);
		event.setDate(new GregorianCalendar(2013, 10, 1, 13, 0));
		testHall.addEvent(event);

		seatLayout = new ArrayList<String>();
		seatLayout.add("oooooxxxxx");
		seatLayout.add("ooooxooooo");
		seatLayout.add("ooxooxxoox");
		seatLayout.add("xxxxooxoxx");
		seatLayout.add("ooooooooox");
		event = new Event(eventId++, seatLayout);
		event.setDate(new GregorianCalendar(2013, 10, 1, 14, 30));
		testHall.addEvent(event);

		seatLayout = new ArrayList<String>();
		seatLayout.add("oooooxoooo");
		seatLayout.add("ooooxooooo");
		seatLayout.add("ooxooxxooo");
		seatLayout.add("xxxxxxxxxx");
		seatLayout.add("xoxxxoxxxx");
		event = new Event(eventId++, seatLayout);
		event.setDate(new GregorianCalendar(2013, 10, 8, 10, 0));
		testHall.addEvent(event);

		seatLayout = new ArrayList<String>();
		seatLayout.add("oooooooooo");
		seatLayout.add("ooooxooooo");
		seatLayout.add("oooooooooo");
		seatLayout.add("oooooooooo");
		seatLayout.add("ooooooooox");
		event = new Event(eventId++, seatLayout);
		event.setDate(new GregorianCalendar(2013, 10, 8, 11, 30));
		testHall.addEvent(event);

		seatLayout = new ArrayList<String>();
		seatLayout.add("oooooxoooo");
		seatLayout.add("xxxxxxxxxx");
		seatLayout.add("ooxooxxooo");
		seatLayout.add("xxxxxxxxxx");
		seatLayout.add("xoxxxoxxxx");
		event = new Event(eventId++, seatLayout);
		event.setDate(new GregorianCalendar(2013, 10, 8, 13, 00));
		testHall.addEvent(event);

		seatLayout = new ArrayList<String>();
		seatLayout.add("oooooxxxxx");
		seatLayout.add("ooooxooooo");
		seatLayout.add("ooxooxxoox");
		seatLayout.add("oooooooooo");
		seatLayout.add("ooooooooox");
		event = new Event(eventId++, seatLayout);
		event.setDate(new GregorianCalendar(2013, 10, 1, 14, 30));
		testHall.addEvent(event);
		
		hallList.add(testHall);

		// run test
		new MainFrame(hallList);
		
	}

}
