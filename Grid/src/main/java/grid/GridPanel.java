package grid;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

public class GridPanel extends JPanel {

	private static final long serialVersionUID = -5704384804939469341L;
	
	private DataModel dataModel;
	
	public GridPanel(){
		setLayout(new BorderLayout());
		
		dataModel = new DataModel();
		
		ImagePanel imagePanel = new ImagePanel(this);
		add(imagePanel, BorderLayout.CENTER);
		
		ButtonPanel grid = new ButtonPanel(this, imagePanel);
		grid.setMaximumSize(new Dimension(100,100));
		add(grid, BorderLayout.LINE_START);
	}
	
	public DataModel getDataModel(){
		return dataModel;
	}

}
