package BonEsprit.DAO;

import BonEsprit.DAO.Hibernate.HibernateUtils;
import BonEsprit.Model.Certificate;
import BonEsprit.Model.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CertificateDAO {
    static SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    public static void create(Certificate certificate) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(certificate);
            transaction.commit();
        } catch(Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    public static void create(List<Certificate> certificates) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        for (Certificate certificate : certificates) {
            create(certificate);
        }
    }

    public List<Certificate> readByUser(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            List<Certificate> certificates = session.createQuery("FROM Certificate C WHERE C.therapist = :id")
                    .setParameter("id", id)
                    .list();
            transaction.commit();
            return certificates;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public boolean update(Certificate certificate) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(certificate);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }
    }

    public boolean delete(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {

            Query deleteQuery = session.createQuery("DELETE FROM Certificate C WHERE C.ID  = :id")
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
