package main.graphics;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import main.data.Event;
import main.data.Hall;
import main.util.Log;
import main.util.Strings;

public class ManageEventsFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Event> eventList;
	private ArrayList<Hall> hallList;
	JButton addButton;
	JButton removeButton;
	JButton editButton;
	JButton loadButton;
	EventsTablePanel tablePanel;

	public ManageEventsFrame(ArrayList<Hall> list) {
		super();
		eventList = new ArrayList<Event>();
		hallList = list;
		Log.post("Initialize ManageEventsFrame");

		setSize(800, 600);
		setTitle("Manage Events");
		setLayout(null);

		eventList = new ArrayList<Event>();
		for (Hall hall : hallList) {
			eventList.addAll(hall.getEventList());
		}

		// dodaj przyciski
		// trzeba dodac MouseListenery do kazdego
		addButton = new JButton(Strings.BUTTON_ADD);
		addButton.setSize(100, 50);
		add(addButton);
		addButton.setLocation(50, 50);

		removeButton = new JButton(Strings.BUTTON_REMOVE);
		removeButton.setSize(100, 50);
		add(removeButton);
		removeButton.setLocation(200, 50);

		editButton = new JButton(Strings.BUTTON_EDIT);
		editButton.setSize(100, 50);
		add(editButton);
		editButton.setLocation(350, 50);

		loadButton = new JButton(Strings.BUTTON_LOAD);
		loadButton.setSize(250, 50);
		add(loadButton);
		loadButton.setLocation(500, 50);
		
		//dodanie tabeli
		tablePanel = new EventsTablePanel(eventList);
		tablePanel.setOpaque(true);
		tablePanel.setSize(500,400);
		add(tablePanel);
		tablePanel.setLocation(50, 150);

		setResizable(false);
		setVisible(true);
	}

}
