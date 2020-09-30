/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dal.IContractInformationDAO;
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
        return contactInformationDAO.getContact("imgCover").get(0).getContent();
    }
    
    
}
