package main.view.grid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import main.dao.Executable;

/**
 * Klasa odpowiedzialna za zapis danych z modelu do bazy
 *
 * @author Gaxit
 */
public class SaveToDb implements Executable {

    private DataModel dataModel;

    /**
     * Tworzy klasę odpowiedzialną za zapis danych z modelu do bazy danych
     *
     * @param dataM Model, którego dane mają być zapisane do bazy danych
     */
    public SaveToDb(DataModel dataM) {
        dataModel = dataM;
    }

    /**
     * Zapisuje dane do bazy danych
     *
     * @param con Obiekt odpowiedzialny za połączenie do bazy danych
     * @param st Obiekt odpowiedzialny za wykonywaną operację na bazie danych
     * @param rs Obiekt ze zbiorem zwróconym przez bazę danych
     * @param params Lista parametrów bazy danych
     */
    @Override
    public Object execute(Connection con, PreparedStatement st, ResultSet rs,
                          List<Object> params) throws SQLException {
        System.out.println("Image: ");
        System.out.println("Rows: " + dataModel.getRows());
        System.out.println("Cols: " + dataModel.getCols());
        System.out.println(
                "Left top point: " + dataModel.getLeftTopPoint().x + ":" + dataModel.getLeftTopPoint().y);
        System.out.println(
                "Left bottom point: " + dataModel.getLeftBottomPoint().x + ":" + dataModel.getLeftBottomPoint().y);
        System.out.println(
                "Right top point: " + dataModel.getRightTopPoint().x + ":" + dataModel.getRightTopPoint().y);
        System.out.println(
                "Right bottom poiny: " + dataModel.getRightBottomPoint().x + ":" + dataModel.getRightBottomPoint().y);
        System.out.println("WSP: " + dataModel.getWSP());
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
