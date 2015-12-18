package acl.dao;

import acl.domain.badge.Badge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Sergei on 16.07.2015.
 */
@Repository(value = "badgeDao")
public class BadgeDaoImpl extends BasicDaoImpl<Badge> {

    private static final Logger LOG = LoggerFactory.getLogger(BadgeDaoImpl.class);
    public static final String ENTITY_NAME = "Badge";

    @Transactional
    public Badge save(Badge dObj) {
        return super.save(dObj, ENTITY_NAME);
    }

    @Transactional
    public List<Badge> findAll() {
        return super.getAll(ENTITY_NAME);
    }
}
