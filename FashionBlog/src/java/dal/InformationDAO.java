/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import domain.Information;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Camer
 */
public class InformationDAO {

    private static Session session = null;

    public static Information getPersonalInformation() {
        String sql = "FROM Information";
        Information res = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery(sql);
            res = (Information) query.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
            session = null;
        }
        return res;
    }
}
