package BonEsprit.DAO;

import BonEsprit.DAO.Hibernate.HibernateUtils;
import BonEsprit.Model.Treatment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class TreatmentDAO {
    static SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    public static void create(Treatment treatment) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(treatment);
            transaction.commit();
        } catch(Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    public static void create(List<Treatment> treatments) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        for (Treatment s : treatments) {
            create(s);
        }
    }

    public static boolean update(Treatment treatment) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.saveOrUpdate(treatment);
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

    public static int update(List<Treatment> treatments) {
        Session session = sessionFactory.openSession();
        int count = 0;
        Transaction transaction = session.beginTransaction();
        for (Treatment s : treatments) {
            if(update(s))
                count++;
        }
        return count;
    }

    public static boolean delete(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {

            Query deleteQuery = session.createQuery("DELETE FROM Treatment S WHERE S.ID  = :id")
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
