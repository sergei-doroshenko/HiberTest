package acl;

import acl.dao.ResourceDaoImpl;
import acl.domain.resource.Resource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Sergei on 31.08.2015.
 */
public class App04_res_cost_changes {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        ResourceDaoImpl dao = (ResourceDaoImpl) context.getBean("resourceDao");

        List<Resource> resources = dao.getResourceCostChages01();

        resources.forEach(System.out::println);
        context.close();
    }
}
