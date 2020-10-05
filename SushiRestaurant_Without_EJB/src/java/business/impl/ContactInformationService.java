/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.impl;

import bean.Information;
import dal.IContractInformationDAO;
import dal.impl.ContactInformationDAO;
import java.util.List;

import business.IContactInformationService;

/**
 *
 * @author Camer
 */
public class ContactInformationService implements IContactInformationService {

    private IContractInformationDAO contactInformationDAO;

    public ContactInformationService() {
        contactInformationDAO = new ContactInformationDAO();
    }

    @Override
    public String getJumbotronName() {
        return contactInformationDAO.getInfoOf("imgCover").get(0).getContent();
    }

    @Override
    public String getAddress() {
        return contactInformationDAO.getInfoOf("address").get(0).getContent();
    }

    @Override
    public String getPhoneNumber() {
        return contactInformationDAO.getInfoOf("tel").get(0).getContent();
    }

    @Override
    public String getEmail() {
        return contactInformationDAO.getInfoOf("mail").get(0).getContent();
    }

    @Override
    public List<Information> getWorkingHours() {
        return contactInformationDAO.getInfoOf("work");
    }

}
