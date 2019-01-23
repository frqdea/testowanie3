package repository;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DbConnection {

    private static DbConnection ourInstance = new DbConnection();
    public static DbConnection getInstance() {
        return ourInstance;
    }

    final private SessionFactory sessionFactory
            = new Configuration().configure().buildSessionFactory();

    private DbConnection() {
    }

    /**
     *
     * @return zwraca session factory
     */

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void close() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
