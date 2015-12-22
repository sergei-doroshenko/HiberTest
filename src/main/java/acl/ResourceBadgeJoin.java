package acl;

import acl.dao.BadgeDaoImpl;
import acl.dao.ResBadgeDataShort;
import acl.dao.ResourceBadgeDaoImpl;
import acl.domain.badge.Badge;
import acl.domain.badge.ResourceBadge;
import acl.domain.badge.ResourceBadgeData;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Date;
import java.util.List;

/**
 * Created by sergei on 12/17/15.
 */
public class ResourceBadgeJoin {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        BadgeDaoImpl dao = (BadgeDaoImpl) context.getBean("badgeDao");
        ResourceBadgeDaoImpl rbDao = (ResourceBadgeDaoImpl) context.getBean("resourceBadgeDao");

        Badge b_0 = new Badge();
        b_0.setName("hello");
        b_0.setEffectivePeriod((short) 5);
        dao.save(b_0);

        Badge b_1 = new Badge();
        b_1.setName("goodbye");
        b_1.setEffectivePeriod((short) 10);
        dao.save(b_1);

        List<Badge> badges = dao.findAll();
        print(badges);

        ResourceBadge rb_0 = new ResourceBadge();
        rb_0.setName("test_0");
        rb_0.setBadge(b_0);
        rb_0.setDate(new Date());
        rbDao.save(rb_0);

        ResourceBadge rb_1 = new ResourceBadge();
        rb_1.setName("test_1");
        rb_1.setBadge(b_1);
        rb_1.setDate(new Date());
        rbDao.save(rb_1);

        List<ResourceBadge> resourceBadges = rbDao.findAll();
        print(resourceBadges);

        List<ResourceBadgeData> resourceBadgeData = rbDao.getResourceBadgeData();
        print(resourceBadgeData);

        List<ResBadgeDataShort> badgeDataShort = rbDao.getResourceBadgeData2();
        print(badgeDataShort);

        badges = dao.findAll();
        print(badges);

        List<ResourceBadgeData> data = rbDao.getResourceBadgeData3();
        print(data);
        context.close();
    }

    public static <T> void print(List<T> list) {
        list.stream().forEach(System.out::println);
        System.out.println();
    }
}
