package edu.test;

import edu.entity.User;
import edu.uitl.HibernateUitl;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;

public class HibernateTest {

    @Test
    public void testGet() {
//        创建sessionFactory对象
        SessionFactory sessionFactory = HibernateUitl.getSessionFactory();
//        创建session对象
        Session session = sessionFactory.openSession();
//        开启事务
        Transaction tx = session.beginTransaction();

        User user = session.get(User.class, 0);
        System.out.println(user);

//        提交事务
        tx.commit();
//        关闭资源
        session.close();

    }

    @Test
    public void testUpdate() {
//        创建sessionFactory对象
        SessionFactory sessionFactory = HibernateUitl.getSessionFactory();
//        创建session对象
        Session session = sessionFactory.openSession();
//        开启事务
        Transaction tx = session.beginTransaction();

        User user = session.get(User.class, 2);
        user.setUsername("令狐冲");
        session.saveOrUpdate(user);
        session.flush();
        //        提交事务
        tx.commit();
//        关闭资源
        session.close();

    }

    @Test
    public void tesDel() {
//        创建sessionFactory对象
        SessionFactory sessionFactory = HibernateUitl.getSessionFactory();
//        创建session对象
        Session session = sessionFactory.openSession();
//        开启事务
        Transaction tx = session.beginTransaction();

//        User user = session.get(User.class, 7);
//        session.delete(user);
        /**
         * 不常用
         * User user = new User();
         * user.setU_id(3);
         * session.delete(user);
         */
        for (int i = 1; i < 1000000; i += 2) {
            User user = new User();
            user.setU_id(i);
            session.delete(user);
            if (i % 1000 == 0) {
                session.flush();
                session.clear();
            }

        }

//        提交事务
        tx.commit();
//        关闭资源
        session.close();

    }

    @Test
    public void testAdd() {


        //        创建sessionFactory对象
        SessionFactory sessionFactory = HibernateUitl.getSessionFactory();
//        创建session对象
        Session session = sessionFactory.openSession();
//        开启事务
        Transaction tx = session.beginTransaction();


        for (int i = 0; i < 100000; i++) { //插入10万条数据
            User user = new User();
            user.setUsername("name" + i);
            user.setPassword("pwd" + i);
            user.setAddress("add" + i);
            session.saveOrUpdate(user);
            if (i % 1000 == 0) {
                session.flush();
                session.clear();
            }
        }
        tx.commit();
//        关闭资源
        session.close();

    }

    @Test
    public void testFormat() {

        Session session = null;
        Transaction tx = null;
        try {
//            与本地线程绑定的session
            session=HibernateUitl.getSessionobject();
//            开启事务
            tx = session.beginTransaction();
            User user = new User();
            user.setUsername("王二麻子");
            user.setPassword("7357");
            user.setAddress("中国");
            session.saveOrUpdate(user);
//            提交事务
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
//            session.close();
        }

    }


}
