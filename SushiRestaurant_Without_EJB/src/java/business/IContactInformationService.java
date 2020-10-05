/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import bean.Information;
import java.util.List;

/**
 *
 * @author Camer
 */
public interface IContactInformationService {
    String getJumbotronName();
    
    String getAddress();
    
    String getPhoneNumber();
    
    String getEmail();
    
    List<Information> getWorkingHours();
}
