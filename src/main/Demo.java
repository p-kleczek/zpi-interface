package main;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.swing.SwingUtilities;

import main.model.Event;
import main.model.Hall;
import main.view.MainFrame;

/**
 * Klasa demostracyjna. Posiada tylko metode main, by uruchomic pokaz dzialania
 * pozostalych klas.
 *
 * Pokazuje tez mniej wiecej proces tworzenia nowych sal i eventow. Osoby
 * odpowiedzialne za baze danych powinny zobaczyc jak tworze eventy/sale zeby
 * moc przekonwertowac dane z bazy do interfejsu. Lub wymyslic jakis lepszy
 * sposob skladowania/dostepu danych do wizualizacji.
 *
 */
public class Demo {

    public static void main(String[] args) {

        // basic setup

        final ArrayList<Hall> hallList = new ArrayList<Hall>();
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

        // run menu
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame(hallList);
            }
        });

        // run grid
        // new HallFrame(testHall);

    }
}
