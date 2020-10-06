/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.util.List;
import domain.Entries;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Camer
 */
public class EntryDAO {

    private static Session session = null;
    private static Transaction transaction = null;

    public static List<Entries> selectTop(int top) {
        List<Entries> entries = null;
        String sql = "FROM Entries\n"
                + "ORDER BY Published DESC";

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery(sql);
            entries = query.setMaxResults(top).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
                session = null;
            }
        }
        return entries;
    }

    public static List<Entries> fetchAll() {
        List<Entries> entries = null;
        String sql = "FROM Entries ORDER BY Published DESC";
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery(sql);
            entries = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
            session = null;
        }
        return entries;
    }

    public static Entries selectByEntryID(int entryID) {
        String sql = "FROM Entries\n"
                + "WHERE EntryID= :entryid";
                Entries res = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery(sql);
            query.setParameter("entryid", entryID);
            res = (Entries) query.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
            session = null;
        }
        return res;
    }

}
