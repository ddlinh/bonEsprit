package BonEsprit.DAO;

import BonEsprit.DAO.Hibernate.HibernateUtils;
import BonEsprit.Model.Problem;
import BonEsprit.Model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ProblemDAO {
    static SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    public void create(Problem problem)  {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            SymptomDAO.create(problem.getSymptoms());
            TreatmentDAO.create(problem.getTreatments());
            session.save(problem);
            transaction.commit();
        } catch(Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    public Problem readByID(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            List<Problem> problems = session.createQuery("FROM Problem P WHERE P.ID = :id")
                    .setParameter("id", id)
                    .list();
            transaction.commit();
            if(problems.size() > 0)
                return problems.get(0);
            return new Problem(0L);
        } catch(Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public List<Problem> readByName(String name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            List<Problem> problems = session.createQuery("FROM Problem P WHERE P.name LIKE :name")
                    .setParameter("name", '%' + name + '%')
                    .list();
            transaction.commit();
            return problems;
        } catch(Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public List<Problem> readByUser(Long user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            List<Problem> problems = session.createQuery("FROM Problem P WHERE P.author = :id")
                    .setParameter("id", user)
                    .list();
            transaction.commit();
            return problems;
        } catch(Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public List<Problem> sortByDate(int limit, String order) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            String query = "FROM Problem P ORDER BY P.date " + order;
            List<Problem> problems = session.createQuery(query)
                    .setMaxResults(limit)
                    .list();
            transaction.commit();
            return problems;
        } catch(Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public boolean update(Problem newProblem) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(newProblem);
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

            Query deleteQuery = session.createQuery("DELETE FROM Problem P WHERE P.ID  = :id")
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
