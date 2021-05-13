package BonEsprit.DAO.Hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static SessionFactory SESSION_FACTORY;

    private static void buildSessionFactory() {
        if(SESSION_FACTORY != null)
            return;
        try {
            SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
        }catch(Throwable e){
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        if(SESSION_FACTORY == null)
            buildSessionFactory();
        return SESSION_FACTORY;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}
