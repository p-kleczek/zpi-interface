package main.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import main.util.Settings;

/**
 * Odpowiada za przekonwertowanie danych sali oraz wyników analizy
 * zarejestrowanych wydarzeń, które w niej miały miejsce do postaci
 * umożliwiającą dalszą, wygodną ich obróbkę.
 *
 * @author bargosc
 */
public class HallEventsDataModel {

    private final ArrayList<Event> eventList;
    private final int eventCount;
    private final String hallId;
    private final HashMap<Date, Double> data;

    /**
     * Tworzy obiekt reprezentujące dane sali oraz wydarzeń na podstawie
     * przekazanego w argumencie obiektu klasy {@link main.data.Hall}.
     *
     * @param hall Sala, której dane zostaną poddane obróbce
     */
    public HallEventsDataModel(Hall hall) {
        this.eventList = hall.getEventList();
        this.eventCount = eventList.size();
        this.hallId = hall.getHallId();
        this.data = new HashMap<>(eventCount);

        prepareData();
    }

    /**
     * Zapisuje sumaryczną ilość zajętych miejsc dla danego wydarzenia w
     * wewnętrznym kontenerze (HashMapie).
     */
    private void prepareData() {
        for (Event event : eventList) {
            /* 
             * FIXME - getDate powinno zwracać date, a getDateString czy coś
             * stringa ;f Ewentualnie powinien być dostęp do jakiegoś obiektu
             * DateFormat żeby dało się tego stringa sparsować normalnie a nie
             * zgadując formatD
             */
            String dateString = event.getDate().toString();
            SimpleDateFormat format = new SimpleDateFormat("d-M-yyyy");
            try {
                Date date = format.parse(dateString);
            } catch (ParseException ex) {
                // pusty catch, bo to musi być zrefactorowane... tak nie pojedzie
            }
                
//                data.put(event.getDate().getTime(),
//                        new Double(getTakenSeatsCount(event)));
        }
    }

    /**
     * Oblicza sumę zajętych miejsc dla danego wydarzenia.
     *
     * @param event Reprezentuje wydarzenie dla którego zostanie obliczona ilość
     * zajętych miejsc
     * @return Suma zajętych miejsc dla danego wydarzenia
     */
    private int getTakenSeatsCount(Event event) {
        int sum = 0;

        for (String row : event.getSeatLayout()) {
            char[] seats = row.toCharArray();

            for (int seatNo = seats.length - 1; seatNo >= 0; seatNo--) {
                if (Settings.TAKEN.equals(seats[seatNo])) {
                    sum++;
                }
            }
        }

        return sum;
    }

    /*
     * Getters & setters
     */
    public int getEventCount() {
        return eventCount;
    }

    public String getHallId() {
        return hallId;
    }

    public HashMap<Date, Double> getData() {
        return data;
    }
}
