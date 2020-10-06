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
import java.sql.Date;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
    
    @Override
    public Entries getEntryById(int id) {
        return EntryDAO.selectByEntryID(id);
    }
    
    @Override
    public List<List<Entries>> getListsPostSortedByMonthAndYear() {
        List<Entries> rawData = EntryDAO.fetchAll();
        Map<YearMonth, List<Entries>> processedData = rawData.stream().collect(Collectors.groupingBy(m -> getYearMonth(m.getPublished()), Collectors.toList()));
        List<YearMonth> sortedByYearMonth = processedData.keySet().stream().sorted().collect(Collectors.toList());
        return sortedByYearMonth.stream().map(ym -> processedData.get(ym)).collect(Collectors.toList());
    }
    
    private YearMonth getYearMonth(Date date) {
        LocalDate localDate = date.toLocalDate();
        return YearMonth.of(localDate.getYear(), localDate.getMonthValue());
    }
    
}
