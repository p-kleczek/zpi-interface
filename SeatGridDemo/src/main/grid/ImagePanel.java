package main.grid;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

public class ImagePanel extends JPanel {

	private static final long serialVersionUID = -8296011972436092336L;

	private GridPanel gridPanel;
	private DataModel dataModel;

	private BufferedImage img;

	private boolean addPoints;
	private boolean drawGrid;

	private List<Point> leftBorder;
	private List<Point> topBorder;
	private List<Point> rightBorder;
	private List<Point> bottomBorder;

	public ImagePanel(GridPanel _gridPanel) {
		addPoints = false;
		drawGrid = false;
		gridPanel = _gridPanel;
		dataModel = gridPanel.getDataModel();
		img = (BufferedImage) dataModel.getImage();
		leftBorder = new LinkedList<Point>();
		topBorder = new LinkedList<Point>();
		rightBorder = new LinkedList<Point>();
		bottomBorder = new LinkedList<Point>();
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
				if (addPoints == true) {
					dataModel.getPointList().add(new Point(e.getX(), e.getY()));
					gridPanel.revalidate();
					gridPanel.repaint();
					System.out.println("Points added: " + e.getX() + ":"
							+ e.getY());
				}
				if (gridPanel.getDataModel().getPointList().size() == 4) {
					addPoints = false;
				}
			}
		});
	}

	public void addPoints() {
		addPoints = true;
		drawGrid = false;
		dataModel.newPointList();
		gridPanel.revalidate();
		gridPanel.repaint();
	}

	public void generateGrid() {
		drawGrid = true;

		leftBorder = new LinkedList<Point>();
		topBorder = new LinkedList<Point>();
		rightBorder = new LinkedList<Point>();
		bottomBorder = new LinkedList<Point>();

		Point leftTop = gridPanel.getDataModel().getLeftTopPoint();
		Point leftBottom = gridPanel.getDataModel().getLeftBottomPoint();
		Point rightTop = gridPanel.getDataModel().getRightTopPoint();
		Point rightBottom = gridPanel.getDataModel().getRightBottomPoint();
		int rows = gridPanel.getDataModel().getRows();
		int cols = gridPanel.getDataModel().getCols();

//		final double WSP = 0.9;
		double WSP = gridPanel.getDataModel().getWSP();

		// lewo
		int leftHeight = Math.abs(leftTop.y - leftBottom.y);
		int leftWidth = Math.abs(leftTop.x - leftBottom.x);
		
		double lewy_wsp = 0;
		double lewy_stara_wartosc = 1;
		for (int i = 0; i < rows; i++) {
			lewy_wsp += lewy_stara_wartosc;
			lewy_stara_wartosc = lewy_stara_wartosc * WSP;
		}
		double dodaj = leftHeight / lewy_wsp;
		double suma = 0;
		
		double lewy_wsp_x = 0;
		double lewy_stara_wartosc_x = 1;
		for (int i=0;i<rows;i++){
			lewy_wsp_x += lewy_stara_wartosc_x;
			lewy_stara_wartosc_x = lewy_stara_wartosc_x* WSP;
		}
		double dodajX = leftWidth / lewy_wsp_x;
		double sumaX = 0;
		
		for (int i = 0; i < rows; i++) {
			if (leftTop.x < leftBottom.x) {
				leftBorder.add(new Point((int)(leftBottom.x - sumaX), (int) (leftBottom.y - suma)));
			} else {
				leftBorder.add(new Point((int)(leftBottom.x + sumaX),
						(int) (leftBottom.y - suma)));
			}
			suma = suma + dodaj;
			dodaj = dodaj * WSP;
			sumaX = sumaX + dodajX;
			dodajX = dodajX * WSP;
		}
		leftBorder.add(leftTop);

		// prawo
		int rightHeight = Math.abs(rightTop.y - rightBottom.y);
		int rightWidth = Math.abs(rightTop.x - rightBottom.x);
		
		double prawy_wsp = 0;
		double prawy_stara_wart = 1;
		for (int i = 0; i < rows; i++) {
			prawy_wsp += prawy_stara_wart;
			prawy_stara_wart = prawy_stara_wart * WSP;
		}
		dodaj = rightHeight / prawy_wsp;
		suma = 0;
		
		double prawy_wsp_x = 0;
		double prawy_stara_wart_x = 1;
		for (int i=0;i<rows;i++){
			prawy_wsp_x += prawy_stara_wart_x;
			prawy_stara_wart_x = prawy_stara_wart_x * WSP;
		}
		dodajX = rightWidth / prawy_wsp_x;
		sumaX = 0;
		
		for (int i = 0; i < rows; i++) {
			if (rightTop.x < rightBottom.x) {
				rightBorder.add(new Point(
						(int)(rightBottom.x - sumaX),
						(int) (rightBottom.y - suma)));
			} else {
				rightBorder.add(new Point(
						(int)(rightBottom.x + i * sumaX),
						(int) (rightBottom.y - suma)));
			}
			suma = suma + dodaj;
			dodaj = dodaj * WSP;
			sumaX = sumaX + dodajX;
			dodajX = dodajX * WSP;
		}
		rightBorder.add(rightTop);

		// //lewo
		// int leftHeight = Math.abs(leftTop.y-leftBottom.y);
		// int leftWidth = Math.abs(leftTop.x-leftBottom.x);
		// double lewy_wsp = 0;
		// double lewy_stara_wartosc = 1;
		// for (int i=0;i<rows;i++){
		// lewy_wsp += lewy_stara_wartosc;
		// lewy_stara_wartosc = lewy_stara_wartosc * WSP;
		// }
		// double dodaj = leftHeight / lewy_wsp;
		// double suma = 0;
		// for (int i=0;i<rows;i++){
		// if (leftTop.x<leftBottom.x){
		// leftBorder.add(new Point(leftBottom.x-i*leftWidth/rows,
		// (int)(leftBottom.y-suma)));
		// }
		// else{
		// leftBorder.add(new Point(leftBottom.x+i*leftWidth/rows,
		// (int)(leftBottom.y-suma)));
		// }
		// suma = suma + dodaj;
		// dodaj = dodaj * WSP;
		// }
		// leftBorder.add(leftTop);

		// //prawo
		// int rightHeight = Math.abs(rightTop.y-rightBottom.y);
		// int rightWidth = Math.abs(rightTop.x-rightBottom.x);
		// double prawy_wsp = 0;
		// double prawy_stara_wart = 1;
		// for (int i=0;i<rows;i++){
		// prawy_wsp += prawy_stara_wart;
		// prawy_stara_wart = prawy_stara_wart * WSP;
		// }
		// dodaj = rightHeight / prawy_wsp;
		// suma = 0;
		// for (int i=0;i<rows;i++){
		// if (rightTop.x<rightBottom.x){
		// rightBorder.add(new Point(rightBottom.x-i*rightWidth/rows,
		// (int)(rightBottom.y-suma)));
		// }
		// else{
		// rightBorder.add(new Point(rightBottom.x+i*rightWidth/rows,
		// (int)(rightBottom.y-suma)));
		// }
		// suma = suma + dodaj;
		// dodaj = dodaj * WSP;
		// }
		// rightBorder.add(rightTop);

		// gora
		int topHeight = Math.abs(leftTop.y - rightTop.y);
		int topWidth = Math.abs(leftTop.x - rightTop.x);
		for (int i = 0; i < cols; i++) {
			if (leftTop.y < rightTop.y) {
				topBorder.add(new Point(leftTop.x + i * topWidth / cols,
						leftTop.y + i * topHeight / cols));
			} else {
				topBorder.add(new Point(leftTop.x + i * topWidth / cols,
						leftTop.y - i * topHeight / cols));
			}
		}
		topBorder.add(rightTop);

		// dół
		int bottomHeight = Math.abs(leftBottom.y - rightBottom.y);
		int bottomWidth = Math.abs(leftBottom.x - rightBottom.x);
		for (int i = 0; i < cols; i++) {
			if (leftBottom.y < rightBottom.y) {
				bottomBorder.add(new Point(leftBottom.x + i * bottomWidth
						/ cols, leftBottom.y + i * bottomHeight / cols));
			} else {
				bottomBorder.add(new Point(leftBottom.x + i * bottomWidth
						/ cols, leftBottom.y - i * bottomHeight / cols));
			}
		}
		bottomBorder.add(rightBottom);

		gridPanel.revalidate();
		gridPanel.repaint();
	}

	// stara wersja
	// public void generateGrid(){
	// drawGrid = true;
	//
	// leftBorder = new LinkedList<Point>();
	// topBorder = new LinkedList<Point>();
	// rightBorder = new LinkedList<Point>();
	// bottomBorder = new LinkedList<Point>();
	//
	// Point leftTop = gridPanel.getDataModel().getLeftTopPoint();
	// Point leftBottom = gridPanel.getDataModel().getLeftBottomPoint();
	// Point rightTop = gridPanel.getDataModel().getRightTopPoint();
	// Point rightBottom = gridPanel.getDataModel().getRightBottomPoint();
	// int rows = gridPanel.getDataModel().getRows();
	// int cols = gridPanel.getDataModel().getCols();
	//
	// int leftHeight = Math.abs(leftTop.y-leftBottom.y);
	// int leftWidth = Math.abs(leftTop.x-leftBottom.x);
	// for (int i=0;i<rows;i++){
	// if (leftTop.x<leftBottom.x){
	// leftBorder.add(new Point(leftTop.x+i*leftWidth/rows,
	// leftTop.y+i*leftHeight/rows));
	// }
	// else{
	// leftBorder.add(new Point(leftTop.x-i*leftWidth/rows,
	// leftTop.y+i*leftHeight/rows));
	// }
	// }
	// leftBorder.add(leftBottom);
	//
	// int rightHeight = Math.abs(rightTop.y-rightBottom.y);
	// int rightWidth = Math.abs(rightTop.x-rightBottom.x);
	// for (int i=0;i<rows;i++){
	// if (rightTop.x<rightBottom.x){
	// rightBorder.add(new Point(rightTop.x+i*rightWidth/rows,
	// rightTop.y+i*rightHeight/rows));
	// }
	// else{
	// rightBorder.add(new Point(rightTop.x-i*rightWidth/rows,
	// rightTop.y+i*rightHeight/rows));
	// }
	// System.out.println("Right border: " + rightBorder.get(i).x + ":" +
	// rightBorder.get(i).y);
	// }
	// rightBorder.add(rightBottom);
	//
	//
	// int topHeight = Math.abs(leftTop.y-rightTop.y);
	// int topWidth = Math.abs(leftTop.x-rightTop.x);
	// for (int i=0;i<cols;i++){
	// if (leftTop.y<rightTop.y){
	// topBorder.add(new Point(leftTop.x+i*topWidth/cols,
	// leftTop.y+i*topHeight/cols));
	// }
	// else{
	// topBorder.add(new Point(leftTop.x+i*topWidth/cols,
	// leftTop.y-i*topHeight/cols));
	// }
	// }
	// topBorder.add(rightTop);
	//
	// int bottomHeight = Math.abs(leftBottom.y-rightBottom.y);
	// int bottomWidth = Math.abs(leftBottom.x-rightBottom.x);
	// for (int i=0;i<cols;i++){
	// if (leftBottom.y<rightBottom.y){
	// bottomBorder.add(new Point(leftBottom.x+i*bottomWidth/cols,
	// leftBottom.y+i*bottomHeight/cols));
	// }
	// else{
	// bottomBorder.add(new Point(leftBottom.x+i*bottomWidth/cols,
	// leftBottom.y-i*bottomHeight/cols));
	// }
	// }
	// bottomBorder.add(rightBottom);
	//
	// gridPanel.revalidate();
	// gridPanel.repaint();
	// }

	@Override
	public void paint(Graphics g) {
		super.paintComponents(g);
		g.drawImage(img, 10, 10, this);
		for (int i = 0; i < dataModel.getPointList().size(); i++) {
			g.fillOval(dataModel.getPointList().get(i).x, dataModel
					.getPointList().get(i).y, 10, 10);
		}
		if (drawGrid == true) {
			drawGrid(g);
		}
	}

	private void drawGrid(Graphics g) {
		for (int i = 0; i < leftBorder.size(); i++) {
			g.drawLine(leftBorder.get(i).x, leftBorder.get(i).y,
					rightBorder.get(i).x, rightBorder.get(i).y);
		}
		for (int i = 0; i < topBorder.size(); i++) {
			g.drawLine(topBorder.get(i).x, topBorder.get(i).y,
					bottomBorder.get(i).x, bottomBorder.get(i).y);
		}
	}

}
