package BonEsprit.DAO;

import BonEsprit.DAO.Hibernate.HibernateUtils;
import BonEsprit.Model.Answer;
import BonEsprit.Model.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class QuestionDAO {
    static SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    public static void create(Question question) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            ChoiceDAO.create(question.getChoices());
            session.save(question);
            transaction.commit();
        } catch(Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    public static void create(List<Question> questions) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        for (Question q : questions) {
            create(q);
        }
    }

    public List<Question> readByQuiz(Long quiz) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            List<Question> questions = session.createQuery("FROM Question Q WHERE Q.quiz = :id")
                    .setParameter("id", quiz)
                    .list();
            transaction.commit();
            return questions;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        } finally {
            session.close();
        }
    }
    
    public boolean update(Question question) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(question);
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

            Query deleteQuery = session.createQuery("DELETE FROM Question Q WHERE Q.ID  = :id")
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
