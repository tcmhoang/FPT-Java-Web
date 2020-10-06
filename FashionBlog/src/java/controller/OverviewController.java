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
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Camer
 */
@ManagedBean
@ViewScoped
public class OverviewController {

    private IEntryService entryService;

    public OverviewController() {
        entryService = new EntryService();
    }

    public List<List<Entries>> getListsPostSortedByMonthAndYear() {
        return entryService.getListsPostSortedByMonthAndYear();
    }
}
