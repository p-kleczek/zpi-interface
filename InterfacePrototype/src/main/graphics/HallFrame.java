package main.graphics;

import javax.swing.JFrame;

import main.data.Hall;
import main.util.Log;
import main.util.Strings;

public class HallFrame extends JFrame {

	/**
	 * Klasa glowna do ladowania widoku sali. Tutaj pakowane sa wsyztskie
	 * kolorowe kwadraciki reprezentujace uzytkowanie sali.
	 * 
	 * Ogolny koncept pakowania grafiki uzyty w tym programie:
	 * 
	 * Klasy typu "Frame" (dziedziczace po JFrame) sluza jako pojemniki na klasy
	 * typu "Panel" (dziedziczace po JPanel). Panele z kolei moga posiadac
	 * JTabel, ScrollPane, JTextArea, lub inne pierdoly. DO FRAME'A WKLADAMY
	 * TYLKO PANELE. Jesli chcecie dodac cos innego (tabela lub zwykle pole
	 * tekstwowe), najpierw tworzycie JPanel, ktory takie elementy w sobie
	 * zawiera,a dopiero potem dodajecie ten panel do frame'a.
	 * 
	 * Jesli kto bedzie tworzyl nowe Frame'y, polecam uzywac metody
	 * setLayout(null) dla kazdego frame'a. Dzieki temu mozna ustawiac recznie
	 * pozycje poszczegolnych elementow (paneli), co jest zbawienne biorac pod
	 * uwage kretynskie dzialanie wiekszosci automatycznych layoutow.
	 */

	private Hall hall;
	private SeatGridPanel grid;
	private static final long serialVersionUID = 1L;

	public HallFrame(Hall hall) {
		super();
		Log.post("Initialize HallFrame");

		this.setHall(hall);
		setSize(800, 400);
		setTitle(Strings.TITLE_SEAT_GRID);
		setLocationRelativeTo(null);

		// add grid
		grid = new SeatGridPanel(hall);
		add(grid);
		grid.setLocation(0, 0);

		setVisible(true);
	}

	public Hall getHall() {
		return hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

}
