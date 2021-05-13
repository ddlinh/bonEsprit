package BonEsprit.DAO;

import BonEsprit.DAO.Hibernate.HibernateUtils;
import BonEsprit.Model.Answer;
import BonEsprit.Model.Problem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class AnswerDAO {
    static SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    public void create(Answer answer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            AnswerDetailDAO.create(answer.getDetails());
            session.save(answer);
            transaction.commit();
        } catch(Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    public List<Answer> readByQuiz(Long quiz) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            List<Answer> answers = session.createQuery("FROM Answer A WHERE A.quiz = :id")
                    .setParameter("id", quiz)
                    .list();
            transaction.commit();
            return answers;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public List<Answer> readByUser(Long user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            List<Answer> answers = session.createQuery("FROM Answer A WHERE A.user = :id")
                    .setParameter("id", user)
                    .list();
            transaction.commit();
            return answers;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public List<Answer> readByUserAndQuiz(Long user, Long quiz) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            List<Answer> answers = session.createQuery("FROM Answer A WHERE A.user = :user AND A.quiz = :quiz")
                    .setParameter("user", user)
                    .setParameter("quiz", quiz)
                    .list();
            transaction.commit();
            return answers;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        } finally {
            session.close();
        }
    }
}
