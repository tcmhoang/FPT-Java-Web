/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import bean.Information;
import dal.IContractInformationDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import service.IContactInformationService;

/**
 *
 * @author Camer
 */
@Stateless
@Local
@Alternative
public class ContactInformationService implements IContactInformationService{
    
    @EJB
    private IContractInformationDAO contactInformationDAO;

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
