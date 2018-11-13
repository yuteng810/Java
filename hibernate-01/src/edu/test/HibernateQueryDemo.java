package edu.test;

import edu.entity.User;
import edu.uitl.HibernateUitl;
import org.hibernate.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class HibernateQueryDemo {
    @Test
    public void testQuery() {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            sessionFactory = HibernateUitl.getSessionFactory();
//            与本地线程绑定的session
            session = sessionFactory.openSession();
//            开启事务
            tx = session.beginTransaction();
//            使用hql
//            1.创建Query对象
            Query query = session.createQuery("from User");

            List<User> list = query.list();

            for (User user : list) {
                System.out.println(user);
            }
//            提交事务
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }


    @Test
    public void testCriteria() {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            sessionFactory = HibernateUitl.getSessionFactory();
//            与本地线程绑定的session
            session = sessionFactory.openSession();
//            开启事务
            tx = session.beginTransaction();
//            使用hql
//            1.创建criteria对象
            Criteria criteria = session.createCriteria(User.class);
//            2
            List<User> list = criteria.list();
            for (User user : list) {
                System.out.println(user);
            }

//            提交事务
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    @Test
    public void testSQLQuery() {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            sessionFactory = HibernateUitl.getSessionFactory();
//            与本地线程绑定的session
            session = sessionFactory.openSession();
//            开启事务
            tx = session.beginTransaction();
//            使用hql
            /**
             *           1创建对象
             *          SQLQuery sqlQuery = session.createSQLQuery("SELECT * FROM t_user");
             *           List<Object[]> list = sqlQuery.list();
             *
             *           for (Object[] object : list) {
             *              System.out.println(Arrays.toString(object));
             *          }
             */
            SQLQuery sqlQuery = session.createSQLQuery("SELECT * FROM t_user");
//            设置数据
            sqlQuery.addEntity(User.class);
            List<User> list = sqlQuery.list();
            for (User user : list) {
                System.out.println(user);
            }

//            提交事务
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }


}
