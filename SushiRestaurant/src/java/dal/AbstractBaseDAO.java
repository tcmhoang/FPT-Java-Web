/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
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

    public AbstractBaseDAO(String url) {
        try {
            this.url = url;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AbstractBaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void openConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url);
            } catch (SQLException ex) {
                Logger.getLogger(AbstractBaseDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException ex) {
                Logger.getLogger(AbstractBaseDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
