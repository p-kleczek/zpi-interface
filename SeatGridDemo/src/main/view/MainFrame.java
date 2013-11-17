package main.view;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import main.controller.HallHistogramFactory;
import main.model.Hall;
import main.view.grid.GridPanel;
import main.util.Log;
import main.util.Strings;

/**
 * Klasa glowna widoku. Program zaczyna od tego frame'a. Tylko dwie opcje: widok
 * sal i eventow.
 * 
 * @author Mateusz
 * 
 */

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	ArrayList<Hall> hallList;
	JButton eventsButton;
	JButton hallsButton;

	public MainFrame(ArrayList<Hall> list) {
		super();
		Log.post("Initialize MainFrame");
		this.hallList = list;

		setTitle(Strings.TITLE_MAIN);
		setLayout(new FlowLayout());

		// initialize buttons
		JButton histogramButton = new JButton(Strings.BUTTON_HISTOGRAM);
		add(histogramButton);
		histogramButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				Log.post("histogram button clicked");

				// TODO
				JFrame histogramFrame = HallHistogramFactory.createFrame(hallList.get(0));
				histogramFrame.setVisible(true);
			}

		});
		
		// initialize buttons
		JButton gridButton = new JButton(Strings.BUTTON_GRID);
		add(gridButton);
		gridButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				Log.post("grid button clicked");
				
				JFrame frame = new JFrame("Grid");
				frame.setSize(800, 530);
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.add(new GridPanel());
				frame.revalidate();
			}

		});

		// initialize buttons
		eventsButton = new JButton(Strings.BUTTON_EVENTS);
		add(eventsButton);
		eventsButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Log.post("events button clicked");
				new ManageEventsFrame(hallList);
			}

		});

		hallsButton = new JButton(Strings.BUTTON_HALLS);
		add(hallsButton);
		hallsButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Log.post("halls button clicked");
				new ManageHallsFrame(hallList);
			}

		});

		setResizable(false);
		setVisible(true);
		pack();
	}

}