/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Article;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 *
 * @author Camer
 */
@Stateless
@Local
public interface IArticleService {

    List<Article> getArticles(int page, int qual);

    Article getArticleById(int id);

    int getQuantityOfArticle();

}
