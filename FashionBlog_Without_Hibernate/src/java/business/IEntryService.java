/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entity.Entry;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Camer
 */
public interface IEntryService extends Serializable{

    List<Entry> getTopPosts();

    Entry getEntryById(int id);

    List<List<Entry>> getListsPostSortedByMonthAndYear();

}
