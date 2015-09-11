package acl.dao;

import acl.domain.resource.Resource2;
import org.hibernate.*;
import org.hibernate.exception.DataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Sergei on 16.07.2015.
 */
@Component(value = "resourceDao2")
public class ResourceDaoImpl2 {

    private static final Logger LOG = LoggerFactory.getLogger(ResourceDaoImpl2.class);
    public static final String ENTITY_NAME = "Resource_Full";

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(value = "txm", readOnly = true)
    public List<Object[]> getResourceCostChages01() {
        Session session = sessionFactory.openSession();

        Query query = session.getNamedQuery("resource.cost.changes");


        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            query.setDate("fromDate", dateFormat.parse("2015-01-01"));
            query.setDate("toDate", dateFormat.parse("2015-06-01"));

            List<Object[]> arr = query.list();
            return arr;
        } catch (HibernateException | ParseException e) {
            String errorMessage = "Error when executing getResourceCostChages01 entityName=" + ENTITY_NAME;
            LOG.debug(errorMessage);
            e.printStackTrace();
            throw new RuntimeException(errorMessage, e);
        } finally {
            session.close();
        }
    }

    public List<Resource2> findAll() {
        Session session = sessionFactory.openSession();

        try {
            Criteria criteria = session.createCriteria(ENTITY_NAME);
            return criteria.list();
        } finally {
            session.close();
        }
    }
}
