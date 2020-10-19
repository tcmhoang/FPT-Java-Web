/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entity.Info;
import java.io.Serializable;


/**
 *
 * @author Camer
 */
public interface IInformationService extends Serializable{
    Info getPersonalInformation();
}
