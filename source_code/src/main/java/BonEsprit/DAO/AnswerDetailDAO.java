package BonEsprit.DAO;

import BonEsprit.DAO.Hibernate.HibernateUtils;
import BonEsprit.Model.Answer;
import BonEsprit.Model.AnswerDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class AnswerDetailDAO {
    static SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    public static void create(AnswerDetail answerDetail) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(answerDetail);
            transaction.commit();
        } catch(Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    public static void create(List<AnswerDetail> answerDetails) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        for (AnswerDetail answer : answerDetails) {
            create(answer);
        }
    }
}
