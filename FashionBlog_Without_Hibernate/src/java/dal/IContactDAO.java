/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import entity.Contact;
import java.io.Serializable;

/**
 *
 * @author Camer
 */
public interface IContactDAO extends Serializable{
    void insert(Contact contact);
}
