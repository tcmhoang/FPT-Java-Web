/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal.impl;

import dal.AbstractBaseDAO;
import dal.IEntryDAO;
import entity.Entry;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;

/**
 *
 * @author Camer
 */
public class EntryDAO extends AbstractBaseDAO implements IEntryDAO {

    private Map<Integer, String> categoryMap;

    public EntryDAO() {
        super(FacesContext.getCurrentInstance().getExternalContext().getInitParameter("jdbc-url"));
        categoryMap = new HashMap<>();

    }

    private String getCategoryNameById(int categoryId) {
        if (categoryMap.containsKey(categoryId)) {
            return categoryMap.get(categoryId);
        }
        String query = "Select CategoryName from Categories where CategoryID = ?";
        try (Connection tempConnection = createNewConnection()) {
            try (PreparedStatement tempStm = tempConnection.prepareStatement(query)) {
                tempStm.setInt(1, categoryId);
                try (ResultSet tempRs = tempStm.executeQuery()) {
                    tempRs.next();
                    categoryMap.put(categoryId, tempRs.getString("CategoryName"));
                    return categoryMap.get(categoryId);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EntryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private Entry pack(ResultSet rs) {
        try {
            int entryId = rs.getInt("EntryID");
            String heading = rs.getString("Heading");
            Date published = rs.getDate("Published");
            String imgName = rs.getString("ImageName");
            String imgCaption = rs.getString("ImageCaption");
            String author = rs.getString("author");
            String content = rs.getString("content");
            String categoryName = getCategoryNameById(rs.getInt("CategoryID"));
            return new Entry(entryId, categoryName, heading, published, imgName, imgCaption, author, content);
        } catch (SQLException ex) {
            Logger.getLogger(EntryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public List<Entry> fetchAll() {
        List<Entry> entries = new LinkedList<>();
        String sql = "Select * FROM Entries\n"
                + "ORDER BY Published DESC";

        try {
            openConnection();
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                entries.add(pack(rs));
            }

        } catch (SQLException ex) {
            Logger.getLogger(EntryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(EntryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return entries;
    }

    @Override
    public Entry selectByEntryID(int entryID) {
        String sql = "Select * FROM Entries\n"
                + "WHERE EntryID= ?";
        Entry res = null;
        try {
            openConnection();
            stm = connection.prepareStatement(sql);
            stm.setInt(1, entryID);
            rs = stm.executeQuery();
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(EntryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(EntryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return res;
    }

}
