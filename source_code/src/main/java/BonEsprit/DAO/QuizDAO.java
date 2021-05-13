package BonEsprit.DAO;

import BonEsprit.DAO.Hibernate.HibernateUtils;
import BonEsprit.Model.Quiz;
import BonEsprit.Model.User;
import BonEsprit.Model.Problem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class QuizDAO {
    static SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    public void create(Quiz quiz)  {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            QuestionDAO.create(quiz.getQuestions());
            session.save(quiz);
            transaction.commit();
        } catch(Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    public Quiz readByID(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            List<Quiz> quizzes = session.createQuery("FROM Quiz Q WHERE Q.ID = :id")
                    .setParameter("id", id)
                    .list();
            transaction.commit();
            if(quizzes.size() > 0)
                return quizzes.get(0);
            return new Quiz(0L);
        } catch(Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public List<Quiz> readByName(String name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            List<Quiz> quizzes = session.createQuery("FROM Quiz Q WHERE Q.name LIKE :name")
                    .setParameter("name", '%' + name + '%')
                    .list();
            transaction.commit();
            return quizzes;
        } catch(Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public List<Quiz> readByUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            List<Quiz> quizzes = session.createQuery("FROM Quiz Q WHERE Q.author = :id")
                    .setParameter("id", user.getID())
                    .list();
            transaction.commit();
            return quizzes;
        } catch(Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public List<Quiz> sortByDate(int limit, String order) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            String query = "FROM Quiz Q ORDER BY Q.date " + order;
            List<Quiz> quizzes = session.createQuery(query)
                    .setMaxResults(limit)
                    .list();
            transaction.commit();
            return quizzes;
        } catch(Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public boolean update(Quiz newQuiz) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(newQuiz);
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

            Query deleteQuery = session.createQuery("DELETE FROM Quiz Q WHERE Q.ID  = :id")
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
