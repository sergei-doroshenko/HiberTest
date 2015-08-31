package acl;

import acl.dao.ResourceDaoImpl;
import acl.domain.filter.ResFilter;
import acl.domain.resource.Resource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergei on 21.06.2015.
 */
public class App03_resources {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        ResourceDaoImpl dao = (ResourceDaoImpl) context.getBean("resourceDao");

        /*dao.getAll().forEach(r -> System.out.println(r));
        System.out.println();*/

        ResFilter filter = new ResFilter();

        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        filter.setIds(ids);

        List<Long> skills = new ArrayList<>();
        skills.add(2L);
        filter.setSkills(skills);

        List<Resource> resources = dao.getForReport(filter);

        resources.forEach(System.out::println);
        context.close();
    }

}
