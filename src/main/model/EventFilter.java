package main.model;

import java.util.HashSet;

/**
 * Pozwala na łatwe filtrowanie wydarzeń wg ich identyfikatorów.
 *
 * @author bargosc
 */
public class EventFilter {

    private final HashSet<Integer> validIds;

    /**
     * Tworzy obiekt inicjalizując jego pola.
     */
    public EventFilter() {
        validIds = new HashSet<>();
    }

    /**
     * Pozwala na dodanie identyfikatora wydarzenia które nie powinno być
     * odfiltrowane.
     *
     * @param id Identyfikator wydarzenia
     * @return {@code true} jeżeli zbiór {@link main.model.EventFilter#validIds}
     * nie zawierał wcześniej elementu {@code id}
     */
    public boolean addValidId(Integer id) {
        return validIds.add(id);
    }

    /**
     * Sprawdza czy {@code event} spełnia wymagania (czy jego identyfikator
     * zawiera się w zbiorze poprawnych).
     *
     * @param event Wydarzenie które ma zostać przetestowane
     * @return {@code true} gdy {@code event} pomyślnie przejdzie test
     */
    public boolean isValid(Event event) {
        return validIds.contains(event.getEventId());
    }
}
