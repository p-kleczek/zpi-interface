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
	private Point leftTopPoint;
	private Point leftBottomPoint;
	private Point rightTopPoint;
	private Point rightBottomPoint;
	
	public DataModel(){
		newPointList();
		loadImage();
		rows = 0;
		cols = 0;
	}
	
	private void loadImage(){
		try {
		    image = ImageIO.read(new File("img/Sala.png"));
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
	
	public void calculatePoints(){
		List<Point> localList = new LinkedList<Point>();
		for (int i=0;i<pointList.size();i++){
			localList.add(pointList.get(i));
		}
		
		Point min1 = localList.get(0);
		for (int i=1;i<localList.size();i++){
			if (localList.get(i).x<=min1.x){
				min1=localList.get(i);
			}
		}
		localList.remove(min1);
		
		Point min2 = localList.get(0);
		for (int i=1;i<localList.size();i++){
			if (localList.get(i).x<=min2.x){
				min2 = localList.get(i);
			}
		}
		localList.remove(min2);
		
		if (min1.y>min2.y){
			leftBottomPoint = min1;
			leftTopPoint = min2;
		}
		else{
			leftBottomPoint = min2;
			leftTopPoint = min1;
		}
		
		if (localList.get(0).y>localList.get(1).y){
			rightBottomPoint = localList.get(0);
			rightTopPoint = localList.get(1);
		}
		else{
			rightBottomPoint = localList.get(1);
			rightTopPoint = localList.get(0);
		}
	}
	
	public void printPoints(){
		System.out.println("Left top: " + leftTopPoint.x + ":" + leftTopPoint.y);
		System.out.println("Left bottom: " + leftBottomPoint.x + ":" + leftBottomPoint.y);
		System.out.println("Right top: " + rightTopPoint.x + ":" + rightTopPoint.y);
		System.out.println("Right bottom: " + rightBottomPoint.x + ":" + rightBottomPoint.y);
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

	public Point getLeftTopPoint() {
		return leftTopPoint;
	}

	public Point getLeftBottomPoint() {
		return leftBottomPoint;
	}

	public Point getRightTopPoint() {
		return rightTopPoint;
	}

	public Point getRightBottomPoint() {
		return rightBottomPoint;
	}

}
