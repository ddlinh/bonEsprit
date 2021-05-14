package BonEsprit.DAO;

import BonEsprit.DAO.Hibernate.HibernateUtils;
import BonEsprit.Exception.InvalidInfoException;
import BonEsprit.Exception.LogInException;
import BonEsprit.Exception.SignUpException;
import BonEsprit.Exception.UserNameExistedException;
import BonEsprit.Model.User;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    static SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    //create an user in database
    public void create(User user)  {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            CertificateDAO.create(user.getCertificates());
            session.save(user);
            transaction.commit();
        } catch(Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    //read users
    public User readByUsername(String username) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            List<User> users = session.createQuery("FROM User U WHERE U.userName = :username")
                    .setParameter("username", username)
                    .list();
            transaction.commit();
            if(users.size() > 0) {
                return users.get(0);
            }
            return new User(0L);
        } catch(Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public List<User> readByName(String name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            List<User> users = session.createQuery("FROM User U WHERE U.firstName LIKE :name OR U.lastName LIKE :name")
                    .setParameter("name", '%' + name + '%')
                    .list();
            transaction.commit();
            return users;
        } catch(Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        } finally {
            session.close();
        }
    }

    private static void swapUser(List<User> users, int i, int j) {
        User swap = new User(users.get(i));
        users.set(i, users.get(j));
        users.set(j, swap);
    }

    public List<User> mostCertificates(int limit) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            List<User> users = session.createQuery("FROM User U")
                    .list();

            if(users.size() <= limit)
                return users;

            int maxOfCertificates = 0;
            int maxIndex = -1;
            int count = 0;

            while(count < limit) {
                for(int i = 0; i < users.size(); i++)
                {
                    int tempCertificates = users.get(i).getCertificates().size();
                    if (tempCertificates > maxOfCertificates) {
                        maxOfCertificates = tempCertificates;
                        maxIndex = i;
                    }
                }
                swapUser(users, count, maxIndex);
                count++;
            }
            return (ArrayList)users.subList(0, limit);
        } catch(Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        }
    }

    public User logIn(String username, String password) throws InvalidInfoException, LogInException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            List<User> users = session.createQuery("FROM User U WHERE U.userName =: username AND U.passWord =: password")
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .list();
            transaction.commit();
            if(users.size() > 0) {
                return users.get(0);
            }
            throw new InvalidInfoException();
        } catch (InvalidInfoException e) {
            throw new InvalidInfoException();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            throw new LogInException();
        } finally {
            session.close();
        }
    }

    public boolean update(User newUser) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(newUser);
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

            Query deleteQuery = session.createQuery("DELETE FROM User U WHERE U.ID  = :id")
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
