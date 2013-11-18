package main.view.grid;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

import javax.swing.JPanel;

/**
 * Komponent nadrzędny, zawierający komponent z przyciskami, komponent wyświetlający zdjęcie sali oraz model danych
 *
 * @author gaxit
 */
public class GridPanel extends JPanel {

	private static final long serialVersionUID = -5704384804939469341L;
	
	private DataModel dataModel;
	
        /**
        * Tworzy komponenty oraz model danych
        * 
        * @param frame Obiekt okna, w którym wyświetlany jest komponent
        */
	public GridPanel(JFrame frame){
		setLayout(new BorderLayout());
		
		dataModel = new DataModel();
		
		ImagePanel imagePanel = new ImagePanel(this);
		add(imagePanel, BorderLayout.CENTER);
		
		ButtonPanel grid = new ButtonPanel(this, imagePanel, frame);
		grid.setMaximumSize(new Dimension(100,100));
		add(grid, BorderLayout.LINE_START);
	}
	
	public DataModel getDataModel(){
		return dataModel;
	}

}
