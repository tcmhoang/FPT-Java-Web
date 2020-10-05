/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal.impl;

import bean.Dish;
import dal.AbstractBaseDAO;
import dal.IDishDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;

/**
 *
 * @author Camer
 */

public class DishDAO extends AbstractBaseDAO implements IDishDAO {


    public DishDAO() {
        super(FacesContext.getCurrentInstance().getExternalContext().getInitParameter("jdbc-url"));
    }


    @Override
    public List<Dish> getMenusAt(int atPage, int qual) {
        int str = atPage * qual - (qual - 1);
        int end = atPage * qual;
        List<Dish> menus = new LinkedList<>();
        String query = "select * from ("
                + "select *, ROW_NUMBER() over (order by id) as rownumber from Dish"
                + ") as dishes "
                + "where rownumber between ? and ?;";

        try {
            openConnection();
            stm = connection.prepareStatement(query);
            stm.setInt(1, str);
            stm.setInt(2, end);
            rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String des = rs.getString("description");
                double price = rs.getFloat("price");
                menus.add(new Dish(id, name, des, price));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DishDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DishDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return menus;
    }

    @Override
    public int getNumberOfMenu() {
        int size = 0;

        String query = "select count(*) as count from Dish";

        try {
            openConnection();
            stm = connection.prepareStatement(query);
            rs = stm.executeQuery();
            rs.next();
            size = rs.getInt("count");

        } catch (SQLException ex) {
            Logger.getLogger(DishDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DishDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return size;
    }

}
