/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.IEntryService;
import business.impl.EntryService;
import entity.Entry;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Camer
 */
@ManagedBean
@RequestScoped
public class HomeController implements Serializable{
    private final IEntryService entryService;
    public HomeController(){
        entryService = new EntryService();
    }
    public List<Entry> getTopPosts(){
        return  entryService.getTopPosts();
    }
}
