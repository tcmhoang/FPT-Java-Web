/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import domain.Categories;
import domain.Entries;
import java.util.List;
import java.util.Optional;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Camer
 */
public class CategoryDAO {

    private static Session session = null;

    public static String getCategoryName(Entries en) {
        List<Categories> cateList = null;
        String res = "";
        String sql = "FROM Categories";
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery(sql);
            cateList = query.list();
            Optional<Categories> tmp = cateList.stream().filter(c -> c.getEntrieses().contains(en)).findAny();
            if (tmp.isPresent()) {
                res = tmp.get().getCategoryName();
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
                session = null;
            }
        }
        return res;
    }
}
