package acl.dao;

import acl.domain.badge.ResourceBadge;
import acl.domain.badge.ResourceBadgeData;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.stat.Statistics;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Sergei on 16.07.2015.
 */
@Repository(value = "resourceBadgeDao")
public class ResourceBadgeDaoImpl extends BasicDaoImpl<ResourceBadge> {

    private static final Logger LOG = LoggerFactory.getLogger(ResourceBadgeDaoImpl.class);
    public static final String ENTITY_NAME = "ResourceBadge";

    @Transactional
    public ResourceBadge save(ResourceBadge dObj) {
        return super.save(dObj, ENTITY_NAME);
    }

    @Transactional
    public List<ResourceBadge> findAll() {
        printStatictics();
        return super.getAll(ENTITY_NAME);
    }

    @Transactional
    public List<ResourceBadgeData> getResourceBadgeData() {
//        printStatictics();
        String entityName = "ResourceBadgeData";

        try {
            Session session = getSessionFactory().getCurrentSession();
            List<ResourceBadgeData> result;
            Criteria criteria = session.createCriteria(entityName);
            result = criteria.list();

            /*Query query = session.createQuery("from " + entityName);
            res = query.list();*/
            return result;
        } catch (HibernateException e) {
            String errorMessage = "Error when executing FindAll. entityName=" + entityName;
            LOG.error(errorMessage);
            throw new RuntimeException(errorMessage, e);
        } finally {
//            printStatictics();
        }


    }

    @Transactional
    public List<ResBadgeDataShort> getResourceBadgeData2() {

        try {
            Session session = getSessionFactory().getCurrentSession();
            List<ResBadgeDataShort> result;
            Criteria criteria = session.createCriteria(ENTITY_NAME);
            criteria.createCriteria("badge", "b", CriteriaSpecification.LEFT_JOIN);

            criteria.add(Restrictions.sqlRestriction(" effective_period > 5"));

            criteria.setProjection(Projections.projectionList()
            .add(Projections.property("id"))
            .add(Projections.property("b.id"), "badgeId")
            ).setResultTransformer(Transformers.aliasToBean(ResBadgeDataShort.class));
            result = criteria.list();

            return result;
        } catch (HibernateException e) {
            String errorMessage = "Error when executing FindAll. entityName=" + ENTITY_NAME;
            LOG.error(errorMessage);
            throw new RuntimeException(errorMessage, e);

        } finally {

        }

    }

    @Transactional
    public List<ResourceBadgeData> getResourceBadgeData3() {

        try {
            Session session = getSessionFactory().getCurrentSession();
            List<ResourceBadgeData> result;

            String sql = "select rb.id, rb.badge_id, rb.resource_badge_date from resource_badge rb " +
                    "left join badge b on rb.badge_id=b.id " +
                    "where b.effective_period > 5";
            SQLQuery sqlQuery = session.createSQLQuery(sql);
            sqlQuery.addEntity("ResourceBadgeData");
            result = sqlQuery.list();

            return result;
        } catch (HibernateException e) {
            String errorMessage = "Error when executing FindAll. entityName=" + ENTITY_NAME;
            LOG.error(errorMessage);
            throw new RuntimeException(errorMessage, e);

        } finally {
            printStatictics();
        }

    }
}
