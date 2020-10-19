/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.impl;

import business.IContactService;
import dal.IContactDAO;
import dal.impl.ContactDAO;
import entity.Contact;

/**
 *
 * @author Camer
 */
public class ContactService implements IContactService {

    private IContactDAO contactDAO;

    public ContactService() {
        contactDAO = new ContactDAO();
    }

    @Override
    public void save(Contact contact) {
        contactDAO.insert(contact);
    }

}
