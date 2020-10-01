/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import bean.Dish;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Camer
 */
@Local
public interface IDishDAO {

    List<Dish> getMenusAt(int page, int qual);
    
    int getNumberOfMenu();
    

}