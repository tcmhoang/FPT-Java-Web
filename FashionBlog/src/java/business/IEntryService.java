/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import domain.Entries;
import java.util.List;

/**
 *
 * @author Camer
 */
public interface IEntryService {
    List<Entries> getTopPosts();
    String getCategoryName(Entries en);
}
