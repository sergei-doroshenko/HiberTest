package acl.dao;

import acl.domain.DomainObject;
import acl.domain.GroupDO;
import org.hibernate.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;

/**
 * Created by Sergei on 22.06.2015.
 */
public class BasicDaoImpl<DO extends DomainObject> {
    private static final Logger LOG = LoggerFactory.getLogger(BasicDaoImpl.class);

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public DO save(DO dObj, String entityName) {
        try {
            Session session = getSessionFactory().getCurrentSession();
            session.saveOrUpdate(entityName, dObj);
            return dObj;
        } catch (HibernateException e) {
            String errorMessage = "Error when saving entity. id=" + dObj.getId() + " entityName=" + entityName;
            LOG.error(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
    }

    public List<DO> getAll(String entityName) {
        try {
            List<DO> res;
            Session session = getSessionFactory().getCurrentSession();
            Criteria crit = session.createCriteria(entityName);
            res = crit.list();

            /*Query query = session.createQuery("from " + entityName);
            res = query.list();*/

            return res;
        } catch (HibernateException e) {
            String errorMessage = "Error when executing FindAll. entityName=" + entityName;
            LOG.error(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
    }
}