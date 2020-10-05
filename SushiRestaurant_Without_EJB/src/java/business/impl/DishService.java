/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.impl;

import bean.Dish;
import dal.IDishDAO;
import dal.impl.DishDAO;
import java.util.Collections;
import java.util.List;
import javax.faces.context.FacesContext;
import business.IDishService;

/**
 *
 * @author Camer
 */

public class DishService implements IDishService {

    private int maxPage;
    private int pageSize;

    private final IDishDAO dishDAO;

    public DishService(){
        dishDAO = new DishDAO();
        init();
    }
    private void init() {
        pageSize = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getInitParameter("pageSize"));
        int totDish = dishDAO.getNumberOfMenu();

        if (totDish % pageSize == 0) {
            maxPage = totDish / pageSize;
        } else {
            maxPage = totDish / pageSize + 1;
        }
    }

    @Override
    public List<Dish> getDishAt(int page) {
        if (page > maxPage || page <= 0) {
            return Collections.<Dish>emptyList();
        } else {
            return dishDAO.getMenusAt(page, pageSize);
        }
    }

    @Override
    public int getMaxPage() {
        return maxPage;
    }

}
