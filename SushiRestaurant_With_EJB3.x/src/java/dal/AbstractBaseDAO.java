/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Camer
 */
public abstract class AbstractBaseDAO {

    protected Connection connection;
    protected String url;
    protected PreparedStatement stm;
    protected ResultSet rs;

    public AbstractBaseDAO(String url) {
        try {
            this.url = url;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AbstractBaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void openConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(url);
        }
    }

    public void closeConnection() throws SQLException {
        if (rs != null || !rs.isClosed()) {
            rs.close();
            rs = null;
        }
        if (stm != null || !stm.isClosed()) {
            stm.close();
            stm = null;
        }
        if (connection != null || !connection.isClosed()) {
            connection.close();
            connection = null;
        }
    }
}
