/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.impl;

import business.IContactService;
import dal.ContactDAO;
import domain.Contact;

/**
 *
 * @author Camer
 */
public class ContactService implements IContactService{

    @Override
    public void save(Contact contact) {
        ContactDAO.insert(contact);
    }
        
}
