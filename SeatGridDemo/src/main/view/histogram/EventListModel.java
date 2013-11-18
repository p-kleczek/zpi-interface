package main.view.histogram;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import main.model.Event;
import main.model.Hall;

/**
 *
 * @author bargosc
 */
public final class EventListModel extends DefaultListModel {

    private final HashMap<Integer, Event> events;

    public EventListModel() {
        events = new HashMap<>();
    }

    public EventListModel(Hall h) {
        this();

        ArrayList<Event> eventList = h.getEventList();
        for (Event event : eventList) {
            addEvent(event);
        }
    }

    public Event getEvent(int id) {
        return events.get(id);
    }

    public ArrayList<Event> getAllEvents() {
        return new ArrayList(events.values());
    }

    public void addEvent(Event element) {
        super.addElement(String.valueOf(element.getEventId()));
        events.put(element.getEventId(), element);
    }

    public void addEvents(Event... elements) {
        for (Event event : elements) {
            addEvent(event);
        }
    }

    @Override
    public void removeAllElements() {
        super.removeAllElements();
        events.clear();
    }
}
