package grid;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class ButtonPanel extends JPanel{
	
	private static final long serialVersionUID = -5359362332203269684L;
	
	private GridPanel gridPanel;
	private ImagePanel imagePanel;
	
	private JSpinner rowsSpin;
	private JSpinner columnsSpin;
	private JLabel rowsLabel;
	private JLabel columnsLabel;
	
	private JButton addPointsButton;
	private JButton generateButton;
	private JButton okButton;
	private JButton cancelButton;
	
	private Dimension spinSize = new Dimension(80,20);
	private Dimension smallRigidArea = new Dimension(0,5);
	private Dimension mediumRigidArea = new Dimension(0,15);
	private Dimension bigRigidArea = new Dimension(0,20);
	
	
	public ButtonPanel(GridPanel _gridPanel, ImagePanel imgPanel){
		gridPanel = _gridPanel;
		imagePanel = imgPanel;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setSize(new Dimension(100,50));	
		
		add(Box.createRigidArea(bigRigidArea));
		
		rowsLabel = new JLabel("Ilość rzędów");
		rowsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(rowsLabel);
		add(Box.createRigidArea(smallRigidArea));
		SpinnerModel rowModel = new SpinnerNumberModel(10,1,50,1);
		rowsSpin = new JSpinner(rowModel);
		rowsSpin.setMaximumSize(spinSize);
		rowsSpin.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(rowsSpin);
		add(Box.createRigidArea(mediumRigidArea));
		
		columnsLabel = new JLabel("Ilość kolumn");
		columnsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(columnsLabel);
		add(Box.createRigidArea(smallRigidArea));
		SpinnerModel colModel = new SpinnerNumberModel(10,1,50,1);
		columnsSpin = new JSpinner(colModel);
		columnsSpin.setMaximumSize(spinSize);
		columnsSpin.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(columnsSpin);
		add(Box.createRigidArea(mediumRigidArea));
		
		addPointsButton = new JButton("Dodaj punkty");
		addPointsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				imagePanel.addPoints();
			}
		});
		addPointsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(addPointsButton);
		add(Box.createRigidArea(mediumRigidArea));
		
		generateButton = new JButton("Generuj siatkę");
		generateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (gridPanel.getDataModel().getPointList().size()!=4){
					JOptionPane.showMessageDialog(gridPanel, "Zła ilość punktów.");
				}
				else{
					gridPanel.getDataModel().setRowsAndCols(rowsSpin.getValue(), columnsSpin.getValue());
					gridPanel.getDataModel().calculatePoints();
					imagePanel.generateGrid();
				}
			}
		});
		generateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(generateButton);
		add(Box.createRigidArea(mediumRigidArea));
		
		Box okCancelBox = Box.createHorizontalBox();
		okButton = new JButton("Ok");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gridPanel.getDataModel().setRowsAndCols(rowsSpin.getValue(), columnsSpin.getValue());
				gridPanel.getDataModel().calculatePoints();
				gridPanel.getDataModel().printPoints();
				gridPanel.getDataModel().saveToDb();
				System.out.println("Ok");
			}
		});
		okCancelBox.add(okButton);
		okCancelBox.add(Box.createRigidArea(new Dimension(5,0)));
		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Cancel");
			}
		});
		okCancelBox.add(cancelButton);
		okCancelBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(okCancelBox);
	}

}
