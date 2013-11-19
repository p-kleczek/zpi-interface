package main.view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import main.model.Event;
import main.model.Hall;
import main.util.Log;
import main.util.Strings;

/**
 * Glowny frame dla widoku eventow.
 *
 * @author Mateusz
 *
 */
public class ManageEventsFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private ArrayList<Event> eventList;
    private ArrayList<Hall> hallList;
    JButton addButton;
    JButton removeButton;
    JButton editButton;
    JButton loadButton;
    EventsTablePanel tablePanel;
    EventDetailPanel detailsPanel;

    public ManageEventsFrame(ArrayList<Hall> list) {
        super();
        eventList = new ArrayList<Event>();
        hallList = list;
        Log.post("Initialize ManageEventsFrame");

        setSize(800, 600);
        setTitle(Strings.TITLE_EVENTS);
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
        addButton.setLocation(25, 25);

        removeButton = new JButton(Strings.BUTTON_REMOVE);
        removeButton.setSize(100, 50);
        add(removeButton);
        removeButton.setLocation(150, 25);

        editButton = new JButton(Strings.BUTTON_EDIT);
        editButton.setSize(100, 50);
        add(editButton);
        editButton.setLocation(275, 25);

        loadButton = new JButton(Strings.BUTTON_LOAD);
        loadButton.setSize(200, 50);
        add(loadButton);
        loadButton.setLocation(575, 25);

        //dodaj listenery do buttonow
        setMouseListenersOnButtons();

        // dodanie tabeli
        tablePanel = new EventsTablePanel(this, eventList);
        tablePanel.setOpaque(true);
        tablePanel.setSize(475, 450);
        add(tablePanel);
        tablePanel.setLocation(25, 100);

        // dodaj pole szczegolow
        detailsPanel = new EventDetailPanel();
        detailsPanel.setOpaque(true);
        detailsPanel.setSize(250, 325);
        add(detailsPanel);
        detailsPanel.setLocation(525, 100);

        setResizable(false);
        setVisible(true);
    }

    public void setDetailText(int eventIndex) {
        detailsPanel.setupText(eventList.get(eventIndex));
        repaint();
    }

    public void setMouseListenersOnButtons() {

        addButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                new NewEventFrame();
            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mousePressed(MouseEvent arg0) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseReleased(MouseEvent arg0) {
                // TODO Auto-generated method stub
            }
        });

        removeButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                //tutaj kod
            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mousePressed(MouseEvent arg0) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseReleased(MouseEvent arg0) {
                // TODO Auto-generated method stub
            }
        });

        editButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                //tutaj kod
            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mousePressed(MouseEvent arg0) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseReleased(MouseEvent arg0) {
                // TODO Auto-generated method stub
            }
        });

        loadButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                //tutaj kod
            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mousePressed(MouseEvent arg0) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseReleased(MouseEvent arg0) {
                // TODO Auto-generated method stub
            }
        });
    }
}
