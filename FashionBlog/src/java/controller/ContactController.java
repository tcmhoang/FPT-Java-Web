/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.IContactService;
import business.impl.ContactService;
import domain.Contact;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Camer
 */
@ManagedBean
@ViewScoped
public class ContactController {

    private IContactService contactService;
    private Contact contact;

    private boolean isSent;

    public ContactController() {
        contactService = new ContactService();
        contact = new Contact();
        isSent = false;
    }

    public String getName() {
        return contact.getName();
    }

    public void setName(String name) {
        contact.setName(name);
    }

    public String getEmail() {
        return contact.getEmail();
    }

    public void setEmail(String email) {
        contact.setEmail(email);
    }

    public String getMessage() {
        return contact.getMessage();
    }

    public void setMessage(String message) {
        contact.setMessage(message);
    }

    public boolean isIsSent() {
        return isSent;
    }

    public void setIsSent(boolean isSent) {
        this.isSent = isSent;
    }

    public void sent() {
        isSent = true;
        contactService.save(contact);
        contact = new Contact();
    }

}
