package util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public enum HibernateUtils {
    INSTANCE;
    private static ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
    private static SessionFactory sessionFactory;

    static {
        try {
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
            sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Session getSession() {
        //从当前的threadLocal取出session
        Session session = threadLocal.get();
        //判断session是否为空，如果是空就创建一个
        if (session == null || !session.isOpen()) {
            session = sessionFactory.openSession();
            //要把session放在当前线程中
            threadLocal.set(session);
        }
        return session;
    }

}
