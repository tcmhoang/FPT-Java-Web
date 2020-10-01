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

    @EJB
    private IArticleDAO articleDAO;

    @Override
    public List<Article> getArticleAt(int page) {
        int pageSize = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getInitParameter("pageSize"));
        int totalPage = articleDAO.getQuantityOfArticle();

        if (totalPage % pageSize == 0) {
            totalPage = totalPage / pageSize;
        } else {
            totalPage = totalPage / pageSize + 1;
        }

        if (page > totalPage || page <= 0) {
            return Collections.EMPTY_LIST;
        } else {
            return articleDAO.getArticlesAt(page, pageSize);
        }

    }

}
