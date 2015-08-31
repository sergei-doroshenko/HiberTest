package acl;

import acl.dao.GroupDaoImpl;
import acl.dao.PrivilegeDaoImpl;
import acl.domain.DomainObject;
import acl.domain.Group;
import acl.domain.GroupDO;
import acl.domain.PrivilegeDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import javax.activation.DataSource;
import java.util.*;

/**
 * Created by Sergei on 21.06.2015.
 */
public class App0 {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        GroupDaoImpl dao = (GroupDaoImpl) context.getBean("groupDao");
        PrivilegeDaoImpl privilegeDao = (PrivilegeDaoImpl) context.getBean("privilegeDao");


        GroupDO dObj = new GroupDO();
        dObj.setId(1L);
        dObj.setName("second");
        Set<PrivilegeDO> privilegeDOSet = new HashSet<>();
        Set<GroupDO> groupDOSet = new HashSet<>();
        groupDOSet.add(dObj);

        PrivilegeDO privilegeDO = new PrivilegeDO(null, "test", "test priv", groupDOSet);
        privilegeDao.save(privilegeDO);
        privilegeDOSet.add(privilegeDO);

        dObj.setPrivileges(privilegeDOSet);
        List<String> resources = new ArrayList<>();
        resources.add("New Resource");
        dObj.setResourcesIds(resources);

        dao.save(dObj);

        GroupDO dObj_2 = new GroupDO(null, "test", null, Collections.EMPTY_SET, Collections.EMPTY_LIST);
        dao.save(dObj_2);

        List<GroupDO> groups = dao.getAll();
        groups.forEach(System.out::println);
        context.close();
    }

}
