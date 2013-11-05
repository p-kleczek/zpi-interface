package grid;

import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

public class DataModel {
	private List<Point> pointList;
	private Image image;
	private int rows;
	private int cols;
	
	public DataModel(){
		newPointList();
		loadImage();
		rows = 0;
		cols = 0;
	}
	
	private void loadImage(){
		try {
		    image = ImageIO.read(new File("C:/Sala.png"));
		} catch (IOException e) {
		}
	}
	
	public void saveToDb(){
		System.out.println("Zapisywanie danych do bazy");
	}
	
	public void setRowsAndCols(Object row, Object col){
		rows = (Integer)row;
		cols = (Integer)col;
	}
	
	public void setRowsAndCols(int row, int col){
		rows = row;
		cols = col;
	}
	
	//--Settery i gettery ponizej
	
	public List<Point> getPointList(){
		return pointList;
	}
	
	public void newPointList(){
		pointList = new LinkedList<Point>();
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

}
