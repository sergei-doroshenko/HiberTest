package acl.dao;

import acl.domain.Message;
import org.hibernate.*;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergei on 23.06.2015.
 */
public class MessageDaoImpl {
    private static final String ENTITY_NAME = "Message";
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Long save(Message message) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Long messageID = null;
        try{
            tx = session.beginTransaction();
            messageID = (Long) session.save(message);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return messageID;
    }

    public Message save2(Message message) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            session.saveOrUpdate(message);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return message;
    }

    public List<Message> findAll() {
        Session session = getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from " + ENTITY_NAME);
            List<Message> res = query.list();
            tx.commit();
            return res;
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            String errorMessage = "Error when executing FindAll. entityName=" + ENTITY_NAME;
            e.printStackTrace();
            throw new RuntimeException(errorMessage, e);
        }finally {
            session.close();
        }
    }

    public List<String> findByCritera(){
        Session session = getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            Criteria criteria = session.createCriteria(Message.class)
                    .add(Restrictions.gt("id", 20L))
                    .setProjection(Projections.projectionList()
                                    .add(Projections.property("id"))
                                    .add(Projections.property("text"))
                    );

            List<Message> results = criteria.list();

            List<String> list = new ArrayList<>();
            for (Object item : results) {
                Object[] columns = (Object[]) item;
                if(columns[0] instanceof Long && columns[1] instanceof String) {
                    Long id = (Long) columns[0];
                    String text = (String) columns[1];
                    list.add(id + ", " + text);
                }
                else {
                    throw new IllegalArgumentException("Invalid columns, DB schema might have changed");
                }
            }
            tx.commit();
            return list;
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            String errorMessage = "Error when executing FindByCriteria. entityName=" + ENTITY_NAME;
            e.printStackTrace();
            throw new RuntimeException(errorMessage, e);
        }finally {
            session.close();
        }

    }
}
