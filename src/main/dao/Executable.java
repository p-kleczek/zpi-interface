package main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface Executable {

    Object execute(Connection con, PreparedStatement st, ResultSet rs,
                   List<Object> params) throws SQLException;
}
