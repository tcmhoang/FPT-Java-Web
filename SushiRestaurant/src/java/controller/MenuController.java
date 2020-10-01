/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Dish;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import service.IDishService;

/**
 *
 * @author Camer
 */
@ManagedBean
@ViewScoped
public class MenuController {

    private int currPage;

    @EJB
    private IDishService dishService;

    public MenuController() {
        currPage = 1;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public List<Dish> getDishes() {
        return dishService.getDishAt(currPage);
    }

    public List<Integer> getPages() {
        return IntStream.rangeClosed(1, dishService.getMaxPage()).boxed().collect(Collectors.toList());
    }

}
