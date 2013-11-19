package main.graphics;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ListSelectionModel;

import main.data.Hall;
import main.util.Log;
import main.util.Strings;

/**
 * Glowny frame dla widoku sal.
 * 
 * @author Mateusz
 * 
 */
public class ManageHallsFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private ArrayList<Hall> hallList;
	private JButton addButton;
	private JButton removeButton;
	private JButton editButton;
	private JButton loadButton;
	private JButton gridButton;
	private HallsTablePanel tablePanel;
	private HallDetailPanel detailsPanel;
	private int selectedRow;

	public ManageHallsFrame(ArrayList<Hall> list) {
		super();
		this.hallList = list;
		selectedRow = -1;
		Log.post("Initialize ManageHallsFrame");

		setSize(800, 600);
		setTitle(Strings.TITLE_HALLS);
		setLayout(null);

		// buttony
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

		// button na wyswietlanie siatki sali
		gridButton = new JButton(Strings.BUTTON_SEAT_GRID);
		gridButton.setSize(200, 50);
		add(gridButton);
		gridButton.setLocation(575, 500);
		gridButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (selectedRow != -1)
					new HallFrame(hallList.get(selectedRow));
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
		hideSeatGridButton();

		// dodanie tabeli
		tablePanel = new HallsTablePanel(this, hallList);
		tablePanel.setOpaque(true);
		tablePanel.setSize(475, 450);
		add(tablePanel);
		tablePanel.setLocation(25, 100);

		// dodaj pole szczegolow
		detailsPanel = new HallDetailPanel();
		detailsPanel.setOpaque(true);
		detailsPanel.setSize(250, 325);
		add(detailsPanel);
		detailsPanel.setLocation(525, 100);

		setResizable(false);
		setVisible(true);
	}

	public void setDetailText(int hallIndex) {
		detailsPanel.setupText(hallList.get(hallIndex));
		repaint();
	}

	public void showSeatGridButton() {
		gridButton.setVisible(true);
	}

	public void hideSeatGridButton() {
		gridButton.setVisible(false);
	}

	public int getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(int selectedRow) {
		this.selectedRow = selectedRow;
	}

	public void setMouseListenersOnButtons() {

		addButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				new NewHallFrame();
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
				// tutaj kod
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
				// tutaj kod
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
				// tutaj kod
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
