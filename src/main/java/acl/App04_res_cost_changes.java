package acl;

import acl.dao.ResourceDaoImpl2;
import acl.domain.resource.Resource2;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Sergei on 31.08.2015.
 */
public class App04_res_cost_changes {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        ResourceDaoImpl2 dao = (ResourceDaoImpl2) context.getBean("resourceDao2");

        List<Object[]> reportData = dao.getResourceCostChages01();

        reportData.stream()
                .map(d -> d[0] + "-" + d[1] + "-" + d[2] + "-" + d[3] + "-" + d[4] + "-" + d[5] + "-" + d[6])
                .forEach(System.out::println);

        List<Resource2> resources = dao.findAll();
        resources.forEach(System.out::println);

        context.close();
    }
}
