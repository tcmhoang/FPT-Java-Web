/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import bean.Article;
import java.util.List;

/**
 *
 * @author Camer
 */
public interface IArticleService {
    List<Article> getArticleAt(int page);
    int getMaxPage();
    Article getArticleByID(int id);
}
