/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.IEntryService;
import business.impl.EntryService;
import java.io.Serializable;
import entity.Entry;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Camer
 */
@ManagedBean
@RequestScoped
public class PostDetailController implements Serializable {

    private final IEntryService entryService;

    private int entryId;
    private String categoryName;
    private Entry data;

    public PostDetailController() {
        entryService = new EntryService();
    }

    public void loadData() {
        data = entryService.getEntryById(entryId);
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getEntryId() {
        return entryId;
    }

    public Entry getData() {
        return data;
    }

    
}
