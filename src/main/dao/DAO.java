package main.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * klasa warstwy dostepu do danych Data Access Object
 *
 * @author piotrek pieprzyk
 *
 */
public class DAO {

    /**
     * Mapa zawier�jca parametry po��czenia w postaci (klucz, wartosc): "host",
     * <jdbc url>
     * "username", <username>
     * "password", <password>
     */
    private Properties settings;
    /**
     * Mapa operacji
     */
    private Map<String, Executable> operations = new HashMap<String, Executable>();
    /**
     * Pole zawieraj�ce informacje o w pe�ni kwalifikowanej nazwie klasy
     * sterownika JDBC.
     */
    private String fQDriverClassName = "org.postgresql.Driver";

    public DAO(Properties settings) {
        setSettings(settings);
    }

    public DAO(Properties settings, String fQDriverClassName) {
        this(settings);
        setFQDriverClassName(fQDriverClassName);
    }

    public DAO(String username, String password, String host) {
        settings = new Properties();

        settings.put("username", username);
        settings.put("password", password);
        settings.put("host", host);
    }

    public DAO(String username, String password, String host,
               String fQDriverClassName) {
        this(username, password, host);
        setFQDriverClassName(fQDriverClassName);
    }

    public Properties getSettings() {
        return settings;
    }

    public void setSettings(Properties settings) {
        this.settings = settings;
    }

    public String getFQDriverClassName() {
        return fQDriverClassName;
    }

    /**
     * Metoda ustawia nazw� klasy sterownika oraz j� �aduje.
     *
     * @param fQDriverClassName
     */
    public void setFQDriverClassName(String fQDriverClassName) {
        this.fQDriverClassName = fQDriverClassName;
        loadDriverClass(fQDriverClassName);
    }

    /**
     * Metoda pomocnicza do �adowania nowej klasy sterownika JDBC.
     *
     * @param fqClassName
     */
    private void loadDriverClass(final String fqClassName) {
        try {
            Class.forName(fqClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda s�u��ca do utworzenia po��czenia.
     *
     * @return
     * @throws SQLException
     */
    private Connection createConnection() throws SQLException {
        Connection con = null;
        try {

            con = DriverManager.getConnection((String) settings.get("host"),
                                              (String) settings.get("username").toString(),
                                              (String) settings.get("password"));

        } catch (SQLException e) {
            throw new SQLException(e);
            //e.printStackTrace();
        }

        return con;
    }

    /**
     * Metoda s�u��ca do zamkni�cia po��czenia.
     *
     * @param rs
     * @param stmt
     * @param con
     */
    private void close(ResultSet rs, Statement stmt, Connection con) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Wykonuje metod� interfejsu Executable. Odci��a implementatora interfejsu
     * od obs�ugi wyj�tk�w, tworzenia potrzebnych referencji i zamykania
     * po��czenia. Je�li u�ytkownik chce odebra� wynik zapytania, robi to w
     * implementacji interfejsu Executable.
     *
     * @param ex
     * @throws SQLException
     */
    public Object executeQuery(Executable ex, List<Object> params) throws
            SQLException {
        Connection con = createConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Object result = null;

        try {
            result = ex.execute(con, stmt, rs, params);
        } catch (SQLException e) {
            throw new SQLException(e);
            //e.printStackTrace();
        } finally {
            close(rs, stmt, con);
        }

        return result;

    }

    public Object executeQuery(String operationName, List<Object> params) throws
            SQLException {
        return this.executeQuery(operations.get(operationName), params);
    }

    public Object executeQuery(String operationName) throws SQLException {
        return this.executeQuery(operations.get(operationName), null);
    }

    public Object executeQuery(Executable ex) throws SQLException {
        return this.executeQuery(ex, null);
    }

    public Executable get(final String operationName) {
        return operations.get(operationName);
    }

    public void add(final String operationName, Executable ex) {
        operations.put(operationName, ex);
    }

    public void remove(final String operationName) {
        operations.remove(operationName);
    }
}
