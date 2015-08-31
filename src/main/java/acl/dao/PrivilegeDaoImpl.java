package acl.dao;

import acl.domain.PrivilegeDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Sergei on 22.06.2015.
 */
public class PrivilegeDaoImpl extends BasicDaoImpl {
    private static final Logger LOG = LoggerFactory.getLogger(PrivilegeDaoImpl.class);
    public static final String ENTITY_NAME = "Privileges";

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public PrivilegeDO save(PrivilegeDO dObj) {
        return (PrivilegeDO) super.save(dObj, ENTITY_NAME);
    }
}
