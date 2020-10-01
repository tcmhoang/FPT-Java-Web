/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal.impl;

import bean.Article;
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

import dal.IArticleDAO;

/**
 *
 * @author Camer
 */
@Stateless
@Local
@Alternative
public class ArticleDAO extends AbstractBaseDAO implements IArticleDAO {

    public ArticleDAO() {
        super(FacesContext.getCurrentInstance().getExternalContext().getInitParameter("jdbc-url"));
    }

    @Override
    public List<Article> getArticlesAt(int atPage, int qual) {
        int str = atPage * qual - (qual - 1);
        int end = atPage * qual;
        List<Article> articles = new LinkedList<>();
        String query = "select * from ("
                + "select *, ROW_NUMBER() over (order by id) as rownumber from Article"
                + ") as articles "
                + "where articles.rownumber between ? and ?;";
        try {
            openConnection();
            stm = connection.prepareStatement(query);
            stm.setInt(1, str);
            stm.setInt(2, end);
            rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String img = "img/" + rs.getString("img");
                String sum = rs.getString("summary");
                String content = rs.getString("content");
                articles.add(new Article(id, title, img, content, sum));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return articles;
    }

    @Override
    public Article getArticleById(int id) {
        String query = "select * from Article where id = ?";
        Article article = new Article();
        try {
            openConnection();
            stm = connection.prepareStatement(query);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                article.setId(rs.getInt("id"));
                article.setTitle(rs.getString("title"));
                article.setImgsrc("img/" + rs.getString("img"));
                article.setSummary(rs.getString("sum"));
                article.setContent(rs.getString("content"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return article;
    }

    @Override
    public int getQuantityOfArticle() {
        int size = 0;

        String query = "select count(*) as count from Article";

        try {
            openConnection();
            stm = connection.prepareStatement(query);
            rs = stm.executeQuery();
            rs.next();
            size = rs.getInt("count");
        } catch (SQLException ex) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return size;
    }

}
