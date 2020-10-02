/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import bean.Article;
import dal.IArticleDAO;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.faces.context.FacesContext;
import service.IArticleService;

/**
 *
 * @author Camer
 */
@Stateless
@Local
@Alternative
public class ArticleService implements IArticleService {

    private int maxPage;
    private int pageSize;

    
    @EJB
    private IArticleDAO articleDAO;
    
    @PostConstruct
    private void init() {
        pageSize = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getInitParameter("pageSize"));
        int totArticle = articleDAO.getQuantityOfArticle();

        if (totArticle % pageSize == 0) {
            maxPage = totArticle / pageSize;
        } else {
            maxPage = totArticle / pageSize + 1;
        }
    }


    @Override
    public List<Article> getArticleAt(int page) {

        if (page > maxPage || page <= 0) {
            return Collections.<Article>emptyList();
        } else {
            return articleDAO.getArticlesAt(page, pageSize);
        }

    }

    @Override
    public int getMaxPage() {
        return maxPage;
    }

    @Override
    public Article getArticleByID(int id) {
        return articleDAO.getArticleById(id);
    }

}
