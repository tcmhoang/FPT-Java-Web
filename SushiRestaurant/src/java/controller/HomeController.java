/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Article;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import service.IArticleService;
import service.IContactInformationService;

/**
 *
 * @author Camer
 */
@ManagedBean
public class HomeController {

    private int currPage;

    @EJB
    private IContactInformationService contactInformationService;

    @EJB
    private IArticleService articleService;

    public HomeController() {
        currPage = 1;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public IContactInformationService getContactInformationService() {
        return contactInformationService;
    }

    public void setContactInformationService(IContactInformationService contactInformationService) {
        this.contactInformationService = contactInformationService;
    }

    public List<Article> getArticles() {
        return articleService.getArticleAt(currPage);
    }

    public String getJumpotron() {
        return "img/" + contactInformationService.getJumbotronName();
    }
}
