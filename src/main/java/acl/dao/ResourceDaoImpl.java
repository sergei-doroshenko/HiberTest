package acl.dao;

import acl.domain.filter.ResFilter;
import acl.domain.resource.Resource;
import acl.domain.resource.Skill;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by Sergei on 16.07.2015.
 */
public class ResourceDaoImpl {

    private static final Logger LOG = LoggerFactory.getLogger(ResourceDaoImpl.class);
    public static final String ENTITY_NAME = "Resource";

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(value = "txm")
    public List<Resource> getAllResources() {
        Session session = getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(ENTITY_NAME);

        try {
            List<Resource> res;

            res = criteria.list();

            /*Query query = session.createQuery("from " + ENTITY_NAME);
            res = query.list();*/

            return res;
        } catch (HibernateException e) {
            String errorMessage = "Error when executing FindByCriteria. entityName=" + ENTITY_NAME;
            e.printStackTrace();
            throw new RuntimeException(errorMessage, e);
        }
    }

    @Transactional(readOnly = true)
    public List<Resource> getForReport(ResFilter filter) {
        Session session = getSessionFactory().openSession();
//        Query query = session.createQuery("from " + ENTITY_NAME);
// select resource.name, skill.type
        Query query = session.createQuery("from Resource as resource, Skill_ent as skill"

        + " where resource.id = skill.resourceId"
        + " and (skill.type.id = 1 or skill.type.id = 2)");


        try {
            List<Object[]> arr = query.list();
            Map<Resource, List<Skill>> map = new HashMap<>();

            for (Object[] o : arr) {
                if (map.get(o[0]) == null) {
                    map.put((Resource) o[0], new ArrayList<>());
                    for (int i = 1; i < o.length; i++) {
                        map.get(o[0]).add((Skill) o[i]);
                    }
                }
            }

            List<Resource> res = new ArrayList<>();

            for (Map.Entry<Resource, List<Skill>> e : map.entrySet()) {
                e.getKey().setSkills(e.getValue());
                res.add(e.getKey());
            }

            return res;
        } catch (HibernateException e) {
            String errorMessage = "Error when executing FindByCriteria. entityName=" + ENTITY_NAME;
            e.printStackTrace();
            throw new RuntimeException(errorMessage, e);
        }
    }

    @Transactional(readOnly = true)
    public List<Resource> getForReportCrit(ResFilter filter) {
        Session session = getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(ENTITY_NAME, "res")
                .createCriteria("skills", "sk")
                .createCriteria("type", "st")
                .add(Restrictions.disjunction()
                                .add(Restrictions.eq("id", 1L))
                                .add(Restrictions.eq("id", 3L))
                ).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);




        /*Disjunction disjunction = Restrictions.disjunction();
        disjunction.add(Restrictions.eq("id", filter.getIds().get(0)));
        disjunction.add(Restrictions.eq("id", filter.getIds().get(1)));
        criteria.add(disjunction);
*/
        /*Criteria skillsFilter = criteria.createCriteria("skills", Criteria.LEFT_JOIN);
        Disjunction disjunction2 = Restrictions.disjunction();
        if (filter.getSkills() != null) {
            for (Long skill : filter.getSkills()) {
                Conjunction conjunction = Restrictions.conjunction();
                conjunction.add(Restrictions.eq("id", skill));
                disjunction2.add(conjunction);
            }
        }
        skillsFilter.add(disjunction2);*/

        /*Disjunction disjunction = Restrictions.disjunction();
        disjunction.add(Restrictions.in("skills", filter.getSkills()));
        criteria.add(disjunction);*/

       /* DetachedCriteria skillCriteria = DetachedCriteria.forEntityName("Skill", "sk");
        Conjunction conjunction = Restrictions.conjunction();
        conjunction.add(Property.forName("resourceId").eqProperty(Property.forName("resb.id")));
        skillCriteria.add(conjunction);
        criteria.add(Subqueries.exists(skillCriteria.setProjection(Projections.property("sk.id"))));*/

        /*Conjunction conjunction = Restrictions.conjunction();
        conjunction.add(Restrictions.eq("id", filter.getIds().get(0)));
        conjunction.add(Restrictions.eq("id", filter.getIds().get(1)));
        criteria.add(conjunction);*/

        try {

            List<Resource> res = criteria.list();
            return res;
        } catch (HibernateException e) {
            String errorMessage = "Error when executing FindByCriteria. entityName=" + ENTITY_NAME;
            e.printStackTrace();
            throw new RuntimeException(errorMessage, e);
        }
    }

    public List<Resource> getAll() {
        Session session = getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List<Resource> res;
            Criteria crit = session.createCriteria(ENTITY_NAME);
            res = crit.list();

            /*Query query = session.createQuery("from " + entityName);
            res = query.list();*/
            tx.commit();
            return res;
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
