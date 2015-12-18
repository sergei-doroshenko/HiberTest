package acl.dao;

import acl.domain.DomainObject;
import acl.domain.GroupDO;
import org.hibernate.*;
import org.hibernate.stat.Statistics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

/**
 * Created by Sergei on 22.06.2015.
 */
public class BasicDaoImpl<DO extends DomainObject> {
    private static final Logger LOG = LoggerFactory.getLogger(BasicDaoImpl.class);

    @Autowired
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
            session.flush();
            return dObj;
        } catch (HibernateException e) {
            String errorMessage = "Error when saving entity. id=" + dObj.getId() + " entityName=" + entityName;
            LOG.error(errorMessage);
            throw new RuntimeException(errorMessage, e);
        }
    }

    public List<DO> getAll(String entityName) {
        try {
            Session session = getSessionFactory().getCurrentSession();
            List<DO> res;
            Criteria crit = session.createCriteria(entityName).setCacheable(true);
            res = crit.list();

            /*Query query = session.createQuery("from " + entityName);
            res = query.list();*/
            return res;
        } catch (HibernateException e) {
            String errorMessage = "Error when executing FindAll. entityName=" + entityName;
            LOG.error(errorMessage);
            throw new RuntimeException(errorMessage, e);
        } finally {
            printStatictics();
        }
    }

    public void printStatictics() {
        Statistics stat = getSessionFactory().getStatistics();
        System.out.println("******************************************************");
        System.out.println("Cache Hit Count: " + stat.getSecondLevelCacheHitCount());
        System.out.println("Cache Miss Count: " + stat.getSecondLevelCacheMissCount());
        System.out.println("Cache Put Count: " + stat.getSecondLevelCachePutCount());
        System.out.println("******************************************************");
    }
}