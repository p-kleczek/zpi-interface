package main.model;

import java.util.HashSet;

/**
 *
 * @author bargosc
 */
public class EventFilter {

    private final HashSet<Integer> validIds;

    public EventFilter() {
        validIds = new HashSet<>();
    }

    public boolean addValidId(Integer e) {
        return validIds.add(e);
    }

    public boolean isValid(Event event) {
        return validIds.contains(event.getEventId());
    }
}
