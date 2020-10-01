/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import bean.Article;
import bean.Dish;
import dal.IDishDAO;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.enterprise.inject.Alternative;
import javax.faces.context.FacesContext;
import service.IDishService;

/**
 *
 * @author Camer
 */
@Stateful
@Local
@Alternative
public class DishService implements IDishService {

    private int maxPage;
    private int pageSize;

    @EJB
    private IDishDAO dishDAO;

    @PostConstruct
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
