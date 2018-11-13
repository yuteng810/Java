package edu.uitl;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class HibernateUitl {

    private static final Configuration cfg;
    private static final SessionFactory sessionFactory;

    static {
        cfg = new Configuration();
        cfg.configure();
        sessionFactory = cfg.buildSessionFactory();
    }

    //提供返回与本地线程帮的session的方法
    public static Session getSessionobject() {
        return sessionFactory.getCurrentSession();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
