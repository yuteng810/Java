package edu.hibernate.test;

import edu.hibernate.entity.Customer;
import edu.hibernate.entity.LinkMan;
import edu.hibernate.utils.HibernateUitls;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

public class HibernateOnetoMany {

    @Test
    public void testAddDemo1() {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            //得到sessionFactory
            sessionFactory = HibernateUitls.getSessionFactory();
            //得到session
            session = sessionFactory.openSession();
            //开启事务
            tx = session.beginTransaction();

            //添加一个客户,为这个客户添加联系人
//           1.创建客户和联系人对象
            Customer customer = new Customer();
            customer.setCustName("Oracle");
            customer.setCustLevel("普通客户");
            customer.setCustSource("email");
            customer.setCustMobile("123");
            customer.setCustPhone("1234567");

            LinkMan linkMan = new LinkMan();
            linkMan.setLkm_name("Mary");
            linkMan.setLkm_gender("female");
            linkMan.setLkm_phone("121123");

            /**
             * 2.在客户表示所有联系人,在联系人中表示客户
             * 建立客户对象和联系人对象关系
             */
//            2.1把联系人对象放到客户对象的set集合中
            customer.getSetLinkMan().add(linkMan);
//            2.2把客户对象放到联系人对象中
            linkMan.setCustomer(customer);
//            保存到数据库
            session.save(customer);
            session.save(linkMan);
//            提交事务
            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    @Test
    public void TestAddDemo2() {

        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            sessionFactory = HibernateUitls.getSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            Customer customer = new Customer();
            customer.setCustName("Google");
            customer.setCustLevel("common");
            customer.setCustSource("email");
            customer.setCustMobile("135");
            customer.setCustPhone("167789");

            LinkMan linkMan = new LinkMan();
            linkMan.setLkm_name("Jhon");
            linkMan.setLkm_gender("male");
            linkMan.setLkm_phone("156123");

            customer.getSetLinkMan().add(linkMan);

            session.save(customer);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }


    }

    @Test
    public void TestDelDemo() {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            //得到sessionFactory
            sessionFactory = HibernateUitls.getSessionFactory();
            //得到session
            session = sessionFactory.openSession();
            //开启事务
            tx = session.beginTransaction();

            //添加一个客户,为这个客户添加联系人
            //1.创建客户和联系人对象

            Customer customer = session.get(Customer.class, 3);
            session.delete(customer);

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    @Test
    public void TestUpdateDemo() {

        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            //得到sessionFactory
            sessionFactory = HibernateUitls.getSessionFactory();
            //得到session
            session = sessionFactory.openSession();
            //开启事务
            tx = session.beginTransaction();

            Customer google = session.get(Customer.class, 1);
            LinkMan mary = session.get(LinkMan.class, 4);
            google.getSetLinkMan().add(mary);
            mary.setCustomer(google);

            //提交事务
            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

}
