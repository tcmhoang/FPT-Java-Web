/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.impl;

import business.IInformationService;
import dal.IInfoDAO;
import dal.impl.InfoDAO;
import entity.Info;

/**
 *
 * @author Camer
 */
public class InformationService implements IInformationService{

    private IInfoDAO infoDAO;
    public InformationService() {
        infoDAO = new InfoDAO();
    }

    
    
    @Override
    public Info getPersonalInformation() {
        return infoDAO.getPersonalInformation().get(0);
    }
    
}
