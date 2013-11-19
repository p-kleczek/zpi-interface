package main.view.grid;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import main.util.Log;

/**
 * Dostarcza panel z przyciskami oraz spinerami do wyznaczania parametrów sali
 *
 * @author Zbigniew Pieprzak
 */
public class ButtonPanel extends JPanel{
	
	private static final long serialVersionUID = -5359362332203269684L;
	
	private GridPanel gridPanel;
	private ImagePanel imagePanel;
	
	private JLabel rowsLabel;
	private JLabel columnsLabel;
	private JLabel wspLabel;
	
	private JSpinner rowsSpin;
	private JSpinner columnsSpin;
	private JSpinner wspSpin;
	
	private JButton addPointsButton;
	private JButton generateButton;
	private JButton okButton;
	private JButton cancelButton;
        private JButton imageButton;
	
	private Dimension spinSize = new Dimension(80,20);
	private Dimension smallRigidArea = new Dimension(0,5);
	private Dimension mediumRigidArea = new Dimension(0,15);
	private Dimension bigRigidArea = new Dimension(0,20);
        
        private JFrame frame;
	
	/**
        * Tworzy panel z przyciskami do zarządzania wyznaczaniem siatki
        *
        * @param _gridPanel Komponent nadrzędny
        * @param imgPanel Komponent wyświetlający zdjęcie sali
        */
	public ButtonPanel(GridPanel _gridPanel, ImagePanel imgPanel, JFrame _frame){
		gridPanel = _gridPanel;
		imagePanel = imgPanel;
                frame = _frame;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setSize(new Dimension(100,50));	
		
		add(Box.createRigidArea(bigRigidArea));
                
                imageButton = new JButton("Dodaj zdjęcie");
                imageButton.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFileChooser fileChooser = new JFileChooser();
				int wynik = fileChooser.showOpenDialog(null);
				if (wynik == 0) {
					Image image = null;
					try {
						image = ImageIO.read(new File(fileChooser.getSelectedFile().getAbsolutePath()));
                                        } catch (IOException es) {
						Log.post(es.getMessage());
					}
                                        if (image==null){
                                            JOptionPane.showMessageDialog(gridPanel, "Wybierz plik ze zdjęciem");
                                        }
                                        else{
                                           gridPanel.getDataModel().setImage(image);
                                           gridPanel.revalidate();
                                           gridPanel.repaint();
                                        }
				}
                    }
                });
                imageButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                add(imageButton);
                add(Box.createRigidArea(mediumRigidArea));
                
		
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
		
		wspLabel = new JLabel("Współczynnik skalowania");
		wspLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(wspLabel);
		add(Box.createRigidArea(smallRigidArea));
		SpinnerModel wspModel = new SpinnerNumberModel(0.9, 0.1, 1.0, 0.01);
		wspSpin = new JSpinner(wspModel);
		wspSpin.setMaximumSize(spinSize);
		wspSpin.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(wspSpin);
		add(Box.createRigidArea(mediumRigidArea));
		
		addPointsButton = new JButton("Dodaj punkty");
		addPointsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            if (gridPanel.getDataModel().getImage()==null){
                                JOptionPane.showMessageDialog(gridPanel, "Nie dodano zdjęcia");
                            }
                            else{
				imagePanel.addPoints();
				gridPanel.getDataModel().setWSP(wspSpin.getValue());
                            }
			}
		});
		addPointsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(addPointsButton);
		add(Box.createRigidArea(mediumRigidArea));
		
		generateButton = new JButton("Generuj siatkę");
		generateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (gridPanel.getDataModel().getImage()==null){
					JOptionPane.showMessageDialog(gridPanel, "Nie dodano zdjęcia");
				}
				else{
                                    if (gridPanel.getDataModel().getPointList().size()!=4){
                                        JOptionPane.showMessageDialog(gridPanel, "Zła ilość punktów.");
                                    }
                                    else{
					gridPanel.getDataModel().setRowsAndCols(rowsSpin.getValue(), columnsSpin.getValue());
					gridPanel.getDataModel().setWSP(wspSpin.getValue());
					gridPanel.getDataModel().calculatePoints();
					imagePanel.generateGrid();
                                    }
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
                            if (gridPanel.getDataModel().getImage()==null){
					JOptionPane.showMessageDialog(gridPanel, "Nie dodano zdjęcia");
				}
				else{
                                    if (gridPanel.getDataModel().getPointList().size()!=4){
                                        JOptionPane.showMessageDialog(gridPanel, "Zła ilość punktów.");
                                    }
                                    else{
                                    gridPanel.getDataModel().setRowsAndCols(rowsSpin.getValue(), columnsSpin.getValue());
                                    gridPanel.getDataModel().calculatePoints();
                                    gridPanel.getDataModel().setWSP(wspSpin.getValue());
                                    gridPanel.getDataModel().saveToDb();
                                    frame.dispose();
                                    System.out.println("Ok");
                                    }
                                }
			}
		});
		okCancelBox.add(okButton);
		okCancelBox.add(Box.createRigidArea(new Dimension(5,0)));
		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            frame.dispose();
                            System.out.println("Cancel");
			}
		});
		okCancelBox.add(cancelButton);
		okCancelBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(okCancelBox);
	}

}
