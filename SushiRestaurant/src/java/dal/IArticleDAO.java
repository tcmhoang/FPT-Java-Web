/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import bean.Article;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Camer
 */
@Local
public interface IArticleDAO {

    List<Article> getArticlesAt(int atPage, int qual);

    Article getArticleById(int id);

    int getQuantityOfArticle();

}
