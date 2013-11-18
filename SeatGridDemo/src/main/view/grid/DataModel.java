package main.view.grid;

import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import main.dao.DAO;
import main.util.Log;

/**
 * Dostarcza model danych, na których operują komponenty odpowiedzialne za wyznaczanie siatki na zdjęciu sali
 *
 * @author gaxit
 */
public class DataModel {
	private List<Point> pointList;
	private Image image;
	private int rows;
	private int cols;
	private Point leftTopPoint;
	private Point leftBottomPoint;
	private Point rightTopPoint;
	private Point rightBottomPoint;
	private double WSP;
	
        /**
        * Tworzy model oraz inicjalizuje podstawowe zmienne
        */
	public DataModel(){
		newPointList();
		rows = 0;
		cols = 0;
		WSP = 0;
	}
	
        /**
        * Zapisuje wyznaczone dane do bazy danych
        */
	public void saveToDb(){
            System.out.println("Zapisywanie danych do bazy");
            SaveToDb db = new SaveToDb(this);
            try {
                DAO dao = new DAO("postgres", "postgre", "jdbc:postgresql://localhost:5432/zpi_db");
                dao.executeQuery(db);
            } catch (SQLException ex) {
                Log.post(ex.getMessage());
            }
	}
	
	public void setRowsAndCols(Object row, Object col){
		rows = (Integer)row;
		cols = (Integer)col;
	}
	
	public void setRowsAndCols(int row, int col){
		rows = row;
		cols = col;
	}
	
        /**
        * Wyznacza, który punkt leży w którym rogu sali
        */
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

	public double getWSP() {
		return WSP;
	}

	public void setWSP(Object wSP) {
		WSP = (Double)wSP;
	}

}
