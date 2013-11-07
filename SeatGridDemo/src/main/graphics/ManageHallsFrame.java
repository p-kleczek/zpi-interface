package main.graphics;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import main.data.Hall;
import main.util.Log;
import main.util.Strings;

public class ManageHallsFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Hall> hallList;
	JButton addButton;
	JButton removeButton;
	JButton editButton;
	JButton loadButton;
	HallsTablePanel tablePanel;
	
	public ManageHallsFrame(ArrayList<Hall> list) {
		super();
		this.hallList = list;
		Log.post("Initialize ManageHallsFrame");
		
		setSize(800, 600);
		setTitle("Manage Halls");
		setLayout(null);
		
		//dodaj przyciski
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
		
		
        
		tablePanel = new HallsTablePanel(hallList);
		tablePanel.setOpaque(true);
		tablePanel.setSize(500,400);
		add(tablePanel);
		tablePanel.setLocation(50, 150);
		
		
		setResizable(false);
		setVisible(true);
	}

}
