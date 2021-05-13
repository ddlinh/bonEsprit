package BonEsprit.DAO;

import BonEsprit.DAO.Hibernate.HibernateUtils;
import BonEsprit.Model.Choice;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ChoiceDAO {
    static SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    public static void create(Choice choice) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(choice);
            transaction.commit();
        } catch(Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    public static void create(List<Choice> choices) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        for (Choice choice : choices) {
            create(choice);
        }
    }
}
