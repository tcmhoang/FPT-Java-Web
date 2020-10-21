/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal.impl;

import dal.AbstractBaseDAO;
import dal.IContactDAO;
import entity.Contact;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;

/**
 *
 * @author Camer
 */
public class ContactDAO extends AbstractBaseDAO implements IContactDAO {

    public ContactDAO() {
        super(FacesContext.getCurrentInstance().getExternalContext().getInitParameter("jdbc-url"));
    }

    @Override
    public void insert(Contact contact) {
        String sql = "Insert into Contact (Name,Email,Message) values(?,?,?)";
        try {
          openConnection();
          stm = connection.prepareStatement(sql);
          stm.setString(1, contact.getName());
          stm.setString(2, contact.getEmail());
          stm.setString(3, contact.getMessage());          
          stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally{
            try {
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
