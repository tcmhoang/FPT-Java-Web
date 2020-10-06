/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.IEntryService;
import business.impl.EntryService;
import domain.Entries;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Camer
 */
@ManagedBean
public class HomeController {
    private IEntryService entryService;
    public HomeController(){
        entryService = new EntryService();
    }
    public List<Entries> getTopPosts(){
        return  entryService.getTopPosts();
    }
    
    public String getCategoryName(Entries en){
        return entryService.getCategoryName(en);
    }
}
