package jdbc.connections;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTmConnection implements ConnectionTM {

    private static ConnectionTM factory;

    private static SessionFactory sessionFactory;

    private HibernateTmConnection() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static ConnectionTM getInstance() {
        if (factory == null) {
            synchronized (HibernateTmConnection.class) {
                if (factory == null) {
                    factory = new HibernateTmConnection();
                }
            }
        }
        return factory;
    }

    @Override
    public Object connect() {
        return sessionFactory.openSession();
    }
}
