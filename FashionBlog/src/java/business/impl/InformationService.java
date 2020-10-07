/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.impl;

import business.IInformationService;
import dal.InformationDAO;
import domain.Information;

/**
 *
 * @author Camer
 */
public class InformationService implements IInformationService{

    @Override
    public Information getPersonalInformation() {
        return InformationDAO.getPersonalInformation();
    }
    
}
