/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Article;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Camer
 */
@Local
public interface IArticleService {
    List<Article> getArticleAt(int page);
}
