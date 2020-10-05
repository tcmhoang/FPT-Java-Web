/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Information;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import business.IContactInformationService;
import business.impl.ContactInformationService;

/**
 *
 * @author Camer
 */
@ManagedBean
@ApplicationScoped
public class ContactController implements Serializable{

    private String address;
    private String tel;
    private String mail;

    private List<Information> workingHours;

    private IContactInformationService contactInformationService;

    public ContactController(){
        contactInformationService = new ContactInformationService();
        init();
    }
    
    public void init() {
        address = contactInformationService.getAddress();
        tel = contactInformationService.getPhoneNumber();
        mail = contactInformationService.getEmail();
        workingHours = contactInformationService.getWorkingHours();
        
        contactInformationService = new ContactInformationService();
    }

    public String getAddress() {
        return address;
    }

    public String getTel() {
        return tel;
    }

    public String getMail() {
        return mail;
    }

    public List<Information> getWorkingHours() {
        return workingHours;
    }

    public IContactInformationService getContactInformationService() {
        return contactInformationService;
    }

}
