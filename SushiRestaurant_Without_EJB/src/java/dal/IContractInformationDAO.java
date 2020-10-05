/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import bean.Information;
import java.util.List;

/**
 *
 * @author Camer
 */
public interface IContractInformationDAO {

    List<Information> getInfoOf(String type);
}
