package acl;

import acl.dao.MessageDaoImpl;
import acl.domain.Message;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Sergei on 21.06.2015.
 */
public class App_Message {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        MessageDaoImpl dao = (MessageDaoImpl) context.getBean("messageDao");


        Message message0 = new Message("Hello!", "Author 1");
        dao.save(message0);

        Message message1 = new Message("How are you!", "Author 2");
        dao.save2(message1);

        Message message2 = new Message("Good buy!", "Author 3");
        dao.save(message2);

//        List<Message> messages = dao.findAll();
        List<String> messages = dao.findByCritera();

        messages.forEach(System.out::println);
        context.close();
    }

}
