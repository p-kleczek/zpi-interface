package main.util;

import java.text.SimpleDateFormat;

/**
 * Ustawienia.
 */
public class Settings {

    public static final Character TAKEN = 'x';
    public static final Character FREE = 'o';
    public static final Character UNAVAILABLE = '.';
    /**
     * Pole używane przez metodę {@link main.model.Event#getDateString()}
     */
    public static final SimpleDateFormat EVENT_DATE_FORMAT =
                                         new SimpleDateFormat("d-M-yyyy");
}
