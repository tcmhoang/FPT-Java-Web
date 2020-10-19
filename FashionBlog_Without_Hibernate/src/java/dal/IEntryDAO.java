/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import entity.Entry;
import java.util.List;
import java.io.Serializable;

/**
 *
 * @author Camer
 */
public interface IEntryDAO extends Serializable {

    List<Entry> fetchAll();

    Entry selectByEntryID(int entryID);

}
