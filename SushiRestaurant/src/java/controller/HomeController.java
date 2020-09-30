/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import service.IContactInformationService;

/**
 *
 * @author Camer
 */
@ManagedBean
public class HomeController {

    @EJB
    private IContactInformationService contactInformationService;

    public String getJumpotron() {
        return "img/" +  contactInformationService.getJumbotronName();
    }
}
