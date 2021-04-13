package jdbc.connections;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTmConnection {

    private static SessionFactory factory;

    private HibernateTmConnection() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    public static SessionFactory getInstance() {
        if (factory == null) {
            synchronized (HibernateTmConnection.class) {
                if (factory == null) {
                    new HibernateTmConnection();
                }
            }
        }
        return factory;
    }

    public Session openSession() {
        return factory.openSession();
    }

}
