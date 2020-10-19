/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.impl;

import business.IEntryService;
import dal.IEntryDAO;
import dal.impl.EntryDAO;
import entity.Entry;
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

    private IEntryDAO entryDAO;

    public EntryService() {
        entryDAO = new EntryDAO();
    }

    @Override
    public List<Entry> getTopPosts() {
        int totEntries = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getInitParameter("DisplayEntries"));
        List<Entry> data = entryDAO.fetchAll();
        return data.subList(0, totEntries > data.size() ? data.size() : totEntries);
    }

    @Override
    public Entry getEntryById(int id) {
        return entryDAO.selectByEntryID(id);
    }

    @Override
    public List<List<Entry>> getListsPostSortedByMonthAndYear() {
        List<Entry> rawData = entryDAO.fetchAll();
        Map<YearMonth, List<Entry>> processedData = rawData.stream().collect(Collectors.groupingBy(m -> getYearMonth(m.getPublished()), Collectors.toList()));
        List<YearMonth> sortedByYearMonth = processedData.keySet().stream().sorted().collect(Collectors.toList());
        return sortedByYearMonth.stream().map(ym -> processedData.get(ym)).collect(Collectors.toList());
    }

    private YearMonth getYearMonth(Date date) {
        LocalDate localDate = date.toLocalDate();
        return YearMonth.of(localDate.getYear(), localDate.getMonthValue());
    }

}
