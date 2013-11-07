package main.graphics;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import main.data.Hall;
import main.util.Log;
import main.util.Strings;

/**
 * Klasa glowna widoku. Program zaczyna od tego frame'a.
 * @author Mateusz
 *
 */

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	ArrayList<Hall> hallList;
	JButton eventsButton;
	JButton hallsButton;

	public MainFrame(ArrayList<Hall> list) {
		super();
		Log.post("Initialize MainFrame");
		this.hallList = list;
		
		setSize(600, 300);
		setTitle("MainFrame");
		setLayout(null);
		//setLocationRelativeTo(null);
		
		//initialize buttons
		eventsButton = new JButton(Strings.BUTTON_EVENTS);
		eventsButton.setSize(200, 50);
		add(eventsButton);
		eventsButton.setLocation(50, 100);
		eventsButton.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Log.post("events button clicked");
				new ManageEventsFrame(hallList);
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
		
		hallsButton = new JButton(Strings.BUTTON_HALLS);
		hallsButton.setSize(200, 50);
		add(hallsButton);
		hallsButton.setLocation(350, 100);
		hallsButton.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Log.post("halls button clicked");
				new ManageHallsFrame(hallList);
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
		
		
		//add grid
		//grid = new GridPanel(hall);
		//add(grid);
		//grid.setLocation(0, 0);
		
		setResizable(false);
		setVisible(true);
	}

}