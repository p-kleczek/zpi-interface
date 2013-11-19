package main.view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import main.util.Log;
import main.util.Strings;

public class NewEventFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    JTextField eventId;
    JTextField hallId;
    JTextField administrator;
    JTextField date;
    JButton addButton;

    public NewEventFrame() {
        super();
        Log.post("Initialize NewEventFrame");

        setSize(800, 600);
        setTitle(Strings.TITLE_NEW_EVENT);
        setLayout(null);

        JLabel label;

        // setup eventId
        label = new JLabel(Strings.LABEL_NEW_EVENT_EVENTID);
        label.setSize(100, 50);
        label.setVisible(true);
        add(label);
        label.setLocation(100, 100);
        eventId = new JTextField();
        eventId.setSize(100, 50);
        add(eventId);
        eventId.setLocation(200, 100);

        // setup hallId
        label = new JLabel(Strings.LABEL_NEW_EVENT_HALLID);
        label.setSize(100, 50);
        label.setVisible(true);
        add(label);
        label.setLocation(100, 200);
        hallId = new JTextField();
        hallId.setSize(100, 50);
        add(hallId);
        hallId.setLocation(200, 200);

        // setup administrator
        label = new JLabel(Strings.LABEL_NEW_EVENT_ADMINISTRATOR);
        label.setSize(100, 50);
        label.setVisible(true);
        add(label);
        label.setLocation(100, 300);
        administrator = new JTextField();
        administrator.setSize(100, 50);
        add(administrator);
        administrator.setLocation(200, 300);

        // setup date
        label = new JLabel(Strings.LABEL_NEW_EVENT_DATE);
        label.setSize(100, 50);
        label.setVisible(true);
        add(label);
        label.setLocation(100, 400);
        date = new JTextField();
        date.setSize(100, 50);
        add(date);
        date.setLocation(200, 400);

        // setup button
        addButton = new JButton(Strings.BUTTON_ADD);
        add(addButton);
        addButton.setVisible(true);
        addButton.setSize(100, 50);
        addButton.setLocation(100, 500);

        //set listener
        addButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                //tutaj dodac kod dodania do bazy danych, stringi gotowe
                String sEventId = eventId.getText();
                String sHallId = hallId.getText();
                String sAdministrator = administrator.getText();
                String sDate = date.getText();
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

        setResizable(false);
        setVisible(true);
    }
}