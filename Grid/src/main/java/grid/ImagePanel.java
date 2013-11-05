package grid;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{
	
	private static final long serialVersionUID = -8296011972436092336L;
	
	private GridPanel gridPanel;
	private DataModel dataModel;
	
	private BufferedImage img;
	
	private boolean addPoints;
	private boolean drawGrid;

	public ImagePanel(GridPanel _gridPanel){
		addPoints = false;
		drawGrid = false;
		gridPanel = _gridPanel;
		dataModel = gridPanel.getDataModel();
		img = (BufferedImage) dataModel.getImage();
		addMouseListener(new MouseListener() {			
			public void mouseReleased(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseClicked(MouseEvent e) {
				if (addPoints==true){
					dataModel.getPointList().add(new Point(e.getX(), e.getY()));
					gridPanel.revalidate();
					gridPanel.repaint();
				}
				if (gridPanel.getDataModel().getPointList().size()==4){
					addPoints = false;
				}
			}
		});
	}
	
	public void addPoints(){
		addPoints = true;
		drawGrid = false;
		dataModel.newPointList();
		gridPanel.revalidate();
		gridPanel.repaint();
	}
	
	public void generateGrid(){
		drawGrid = true;
		gridPanel.revalidate();
		gridPanel.repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paintComponents(g);
		g.drawImage(img, 10, 10, this);
		for (int i=0;i<dataModel.getPointList().size();i++){
			g.fillOval(dataModel.getPointList().get(i).x, dataModel.getPointList().get(i).y, 10, 10);
		}
		if (drawGrid==true){
			drawGrid(g);
		}
	}
	
	private void drawGrid(Graphics g){
		int rows = dataModel.getRows();
		int cols = dataModel.getCols();
		System.out.println("Rysowanie siatki na " + rows + " wierszy i " + cols + " kolumn");
	}

}
