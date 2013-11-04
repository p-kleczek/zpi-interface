package main.graphics;

import javax.swing.JFrame;

import main.data.Hall;
import main.util.Log;

public class HallFrame extends JFrame {

	/**
	 * Klasa glowna do ladowania widoku sali.
	 */
	
	private Hall hall;
	private GridPanel grid;
	private static final long serialVersionUID = 1L;

	public HallFrame(Hall hall) {
		super();
		Log.post("Initialize HallFrame");
		
		this.hall = hall;
		setSize(800, 400);
		setTitle("HallFrame");
		setLocationRelativeTo(null);
		
		//add grid
		grid = new GridPanel(hall);
		add(grid);
		grid.setLocation(0, 0);
		
		setVisible(true);
	}

}
