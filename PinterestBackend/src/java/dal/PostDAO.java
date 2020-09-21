/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import beans.Post;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Camer
 */

public class PostDAO extends BaseDAO {
    
    public PostDAO(String url){
        super(url);
    }
    
    public List<Post> fetchAll() {
        List<Post> result = new LinkedList<>();
        String query = "select src,caption from Post";
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = connection.prepareStatement(query);
            rs = stm.executeQuery();
            while (rs.next()) {
                String src = rs.getString("src");
                String caption = rs.getString("caption");
                result.add(new Post(src, caption));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if(connection != null )connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return result;
    }
   

}
