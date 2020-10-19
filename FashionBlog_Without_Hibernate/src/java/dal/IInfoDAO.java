/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import entity.Info;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Camer
 */
public interface IInfoDAO extends Serializable{


    List<Info> getPersonalInformation();
}
