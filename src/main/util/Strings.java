package main.util;

public class Strings {

	/**
	 * Tutaj pakujemy wsyztskie teksty wyswietlane w programie. Pakowanie
	 * stringow w jednym miejscu ulatwi potem ewentulna konwersje na inny jezyk
	 * i pozwoli szybko znalezc literowki lub wprowadzic zmiany jelsi komus sie
	 * nie spodoba wyswietlany tekst.
	 */

	// tytuly frame'ow
	public static final String TITLE_MAIN = "Menu główne";
	public static final String TITLE_EVENTS = "Zarządzaj eventami";
	public static final String TITLE_HALLS = "Zarzązaj salami";
	public static final String TITLE_SEAT_GRID = "Siatka sali";
    public static final String TITLE_NEW_EVENT = "Nowy event";
    public static final String TITLE_NEW_HALL = "Nowa sala";

	// buttons
	public static final String BUTTON_EVENTS = "Zarządzaj eventami";
	public static final String BUTTON_HALLS = "Zarządzaj salami";
	public static final String BUTTON_ADD = "Dodaj";
	public static final String BUTTON_REMOVE = "Usuń";
	public static final String BUTTON_EDIT = "Edytuj";
	public static final String BUTTON_LOAD = "Załaduj dane";
	public static final String BUTTON_SEAT_GRID = "Użytkowanie miejsc";
	public static final String BUTTON_GRID = "Siatka";
	public static final String BUTTON_HISTOGRAM = "Histogram";

	// naglowki tabeli
	public static final String HEADER_HALL_ID = "ID sali";
	public static final String HEADER_HALL_MAX = "Max. miejsc";
	public static final String HEADER_EVENT_ID = "ID wydarzenia";
	public static final String HEADER_EVENT_DATE = "Data";
	public static final String HEADER_EVENT_ADMINISTRATOR = "Administrator";

	// szczegoly sali/eventow
	public static final String DETAIL_HALL_TITLE = "Szczegóły sali";
	public static final String DETAIL_EVENT_TITLE = "Szczegóły eventu";
	public static final String DETAIL_HALL_ID = "ID sali:\t\t";
	public static final String DETAIL_HALL_MAX = "Max ilość miejsc:\t";
	public static final String DETAIL_EVENT_ADMINISTRATOR = "Administrator sali:\t";
	public static final String DETAIL_HALL_NUM_OF_EVENTS = "Liczba eventów sali:\t";
	public static final String DETAIL_EVENT_ID = "ID eventu:\t\t";
	public static final String DETAIL_EVENT_DATE = "Data:\t\t";

   // nowy event/sala
    public static final String LABEL_NEW_EVENT_EVENTID = "ID eventu";
    public static final String LABEL_NEW_EVENT_HALLID = "ID sali";
    public static final String LABEL_NEW_EVENT_ADMINISTRATOR = "Administrator";
    public static final String LABEL_NEW_EVENT_DATE = "Data";
    public static final String LABEL_NEW_HALL_ID = "ID sali";
    public static final String LABEL_NEW_HALL_ROWS = "Liczba rzędów";
    public static final String LABEL_NEW_HALL_SEATS_IN_ROW = "Liczba miejsc w rzędzie";

    // HallHistogramPanel
    public final static String HISTOGRAM_FRAME_TITLE = "Widok histogramu";
    public final static String HISTOGRAM_TITLE = "Ilość zajętych miejsc";
    public final static String HISTOGRAM_X_AXIS = "Czas";
    public final static String HISTOGRAM_Y_AXIS = "Zajęte miejsca";
    public final static String DETAILED_LABEL_SET_NAME = "Co do minuty";
    public final static String NORMAL_LABEL_SET_NAME = "Co do dnia";
    public final static String BIG_PERIODS_LABEL_SET_NAME = "Co do miesiąca";
    public final static String BUTTON_GENERATE_HISTOGRAM = "Generuj wykres";
    public final static String LABEL_HORIZONTAL_AXIS_SCALING = "Skalowanie osi poziomej";

}
