package BonEsprit.DAO;

import BonEsprit.DAO.Hibernate.HibernateUtils;
import BonEsprit.Model.Symptom;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class SymptomDAO {
    static SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    public static void create(Symptom symptom) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(symptom);
            transaction.commit();
        } catch(Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    public static void create(List<Symptom> symptoms) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        for (Symptom s : symptoms) {
            create(s);
        }
    }

    public static boolean update(Symptom symptom) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.saveOrUpdate(symptom);
            transaction.commit();
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        } finally {
            session.close();
        }
    }

    public static int update(List<Symptom> symptoms) {
        Session session = sessionFactory.openSession();
        int count = 0;
        Transaction transaction = session.beginTransaction();
        for (Symptom s : symptoms) {
            if(update(s))
                count++;
        }
        return count;
    }

    public static boolean delete(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {

            Query deleteQuery = session.createQuery("DELETE FROM Symptom S WHERE S.ID  = :id")
                    .setParameter("id", id);

            int result = deleteQuery.executeUpdate();
            transaction.commit();

            if(result > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }
    }

}
