/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal.impl;

import dal.AbstractBaseDAO;
import dal.IInfoDAO;
import entity.Info;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;

/**
 *
 * @author Camer
 */
public class InfoDAO extends AbstractBaseDAO implements IInfoDAO {

    public InfoDAO() {
        super(FacesContext.getCurrentInstance().getExternalContext().getInitParameter("jdbc-url"));

    }

    @Override
    public List<Info> getPersonalInformation() {
        String sql = "select * FROM Information";
        List<Info> res = new LinkedList<>();
        try{
            openConnection();
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String img = rs.getString("img");
                String des = rs.getString("description");
                res.add(new Info(id,name,age,img,des));
            }
        } catch (SQLException ex) {
            Logger.getLogger(InfoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

}
