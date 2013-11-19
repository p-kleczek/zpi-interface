package main.graphics;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import main.util.Log;
import main.util.Strings;

public class NewHallFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	JTextField hallId;
	JTextField rows;
	JTextField seatsInRow;
	JButton addButton;

	public NewHallFrame() {
		super();
		Log.post("Initialize NewEventFrame");

		setSize(800, 600);
		setTitle(Strings.TITLE_NEW_EVENT);
		setLayout(null);

		JLabel label;

		// setup hallId
		label = new JLabel(Strings.LABEL_NEW_HALL_ID);
		label.setSize(200, 50);
		label.setVisible(true);
		add(label);
		label.setLocation(100, 100);
		hallId = new JTextField();
		hallId.setSize(100, 50);
		add(hallId);
		hallId.setLocation(300, 100);

		// setup administrator
		label = new JLabel(Strings.LABEL_NEW_HALL_ROWS);
		label.setSize(200, 50);
		label.setVisible(true);
		add(label);
		label.setLocation(100, 200);
		rows = new JTextField();
		rows.setSize(100, 50);
		add(rows);
		rows.setLocation(300, 200);

		// setup date
		label = new JLabel(Strings.LABEL_NEW_HALL_SEATS_IN_ROW);
		label.setSize(200, 50);
		label.setVisible(true);
		add(label);
		label.setLocation(100, 300);
		seatsInRow = new JTextField();
		seatsInRow.setSize(100, 50);
		add(seatsInRow);
		seatsInRow.setLocation(300, 300);

		// setup button
		addButton = new JButton(Strings.BUTTON_ADD);
		add(addButton);
		addButton.setVisible(true);
		addButton.setSize(100, 50);
		addButton.setLocation(100, 500);
		
		//set listener
		addButton.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				//tutaj dodac kod dodania do bazy danych, stringi gotowe
				String sHallId = hallId.getText();
				String sRows = rows.getText();
				String sSeatsInRow = seatsInRow.getText();
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
