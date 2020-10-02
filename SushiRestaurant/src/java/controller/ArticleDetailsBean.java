/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Article;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import service.IArticleService;

/**
 *
 * @author Camer
 */
@ManagedBean
@ViewScoped
public class ArticleDetailsBean implements Serializable {

    private int id;
    private String title;
    private String imgsrc;
    private String content;
    private String summary;

    @EJB
    private IArticleService articleService;

    public void loadData() {
        Article tmp = articleService.getArticleByID(id);
        title = tmp.getTitle();
        content = tmp.getContent();
        imgsrc = tmp.getImgsrc();
        summary = tmp.getSummary();
    }
    

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public String getContent() {
        return content;
    }

    public String getSummary() {
        return summary;
    }

    public IArticleService getArticleService() {
        return articleService;
    }

    public void setId(int id) {
        this.id = id;
    }

}
