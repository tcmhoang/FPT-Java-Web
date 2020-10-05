/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Article;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import service.IArticleService;
import service.IContactInformationService;

/**
 *
 * @author Camer
 */
@ManagedBean
@ViewScoped
public class HomeController implements Serializable{

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

    public List<Article> getArticles() {
        return articleService.getArticleAt(currPage);
    }

    public String getJumpotron() {
        return "img/" + contactInformationService.getJumbotronName();
    }

    public List<Integer> getPages() {
        return IntStream.rangeClosed(1, articleService.getMaxPage()).boxed().collect(Collectors.toList());
    }

}
