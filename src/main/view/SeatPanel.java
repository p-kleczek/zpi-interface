package main.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

/**
 * Klasa zajmujaca sie wyswietlaniem pojedynczego miejsca oraz kolorowaniem go
 * odpowiednio od stopnia uzytkowania
 */
public class SeatPanel extends JPanel implements MouseListener {

	float usage; // wartosc od 0.0 do 1.0
	private static final long serialVersionUID = 1L;

	public SeatPanel(float usage) {
		super();
		if (usage > 1.0) {
			this.usage = (float) 1.0;
		} else {
			this.usage = usage;
		}

	}

	@Override
	public void paintComponent(Graphics g) {
		if (usage < 0.5) {
			g.setColor(new Color(usage * 2, (float) 1.0, 0));
		} else {
			g.setColor(new Color((float) 1.0, (1 - usage) * 2, 0));
		}
		int width = getWidth();
		int height = getHeight();
		g.fillRect(0, 0, width, height);

		g.setColor(Color.BLACK);
		g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

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

}
