/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal.impl;

import bean.Information;
import dal.AbstractBaseDAO;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.faces.context.FacesContext;
import dal.IContractInformationDAO;

/**
 *
 * @author Camer
 */
@Stateless
@Local
@Alternative
public class ContactInformationDAO extends AbstractBaseDAO implements IContractInformationDAO {

    public ContactInformationDAO() {
        super(FacesContext.getCurrentInstance().getExternalContext().getInitParameter("jdbc-url"));
    }

    @Override
    public List<Information> getInfoOf(String type) {
        String sql = "SELECT * FROM Information WHERE type = (?)";

        List<Information> listInfo = new LinkedList<>();
        try {
            openConnection();
            stm = connection.prepareStatement(sql);
            stm.setString(1, type);
            rs = stm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String typeContact = rs.getString("type");
                String sum = rs.getString("summary");
                String content = rs.getString("content");

                Information contact = new Information(id, typeContact, content, sum);
                listInfo.add(contact);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ContactInformationDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ContactInformationDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listInfo;
    }

}
