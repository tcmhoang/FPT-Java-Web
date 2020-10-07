/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.IInformationService;
import business.impl.InformationService;
import domain.Information;
import java.io.Serializable;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Camer
 */
@ManagedBean
@ApplicationScoped
public class AboutController implements Serializable {

    private Information info;

    public AboutController() {
        IInformationService informationService = new InformationService();
        info = informationService.getPersonalInformation();
    }

    public String getName() {
        return info.getName();
    }

    public int getAge() {
        return info.getAge();
    }

    public String getImg() {
        return info.getImg();
    }

    public String getDescription() {
        return info.getDescription();
    }

}
