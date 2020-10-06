/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.impl;

import business.IEntryService;
import dal.CategoryDAO;
import dal.EntryDAO;
import domain.Entries;
import java.util.List;
import javax.faces.context.FacesContext;

/**
 *
 * @author Camer
 */
public class EntryService implements IEntryService {

    @Override
    public List<Entries> getTopPosts() {
        int totEntries = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getInitParameter("DisplayEntries"));
        return EntryDAO.selectTop(totEntries);
    }

    @Override
    public String getCategoryName(Entries en) {
        return CategoryDAO.getCategoryName(en);
                
    }

}
