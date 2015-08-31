package acl.dao;

import acl.domain.DomainObject;
import acl.domain.GroupDO;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Sergei on 22.06.2015.
 */
public class GroupDaoImpl extends BasicDaoImpl<GroupDO> {

    private static final Logger LOG = LoggerFactory.getLogger(GroupDaoImpl.class);
    public static final String ENTITY_NAME = "Groups";

    @Transactional
    public GroupDO save(GroupDO dObj) {
        return super.save(dObj, ENTITY_NAME);
    }

    @Transactional(readOnly = true)
    public List<GroupDO> getAll() {
        List<GroupDO> result = super.getAll(ENTITY_NAME);
        for (GroupDO groupDO : result) {
            Hibernate.initialize(groupDO.getPrivileges());
            System.out.println(groupDO.getPrivileges());
        }
        return result;
    }
}
