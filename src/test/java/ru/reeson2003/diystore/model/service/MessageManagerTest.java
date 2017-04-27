package ru.reeson2003.diystore.model.service;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Date: 27.04.2017.
 * Time: 22:42.
 *
 * @author Pavel Gavrilov.
 */
public class MessageManagerTest {
    private MessageManager manager;
    
    @Before
    void initTest() {
        ApplicationContext context =
                new FileSystemXmlApplicationContext("/src/main/webapp/WEB-INF/configs/spring_config.xml");
        manager = (MessageManager) context.getBean("messageManager");
        Class clazz = manager.getClass();
        String name = clazz.getName().substring(clazz.getPackage().getName().length()+1);
        System.out.println(">>>Class name: " + name);
    }
}
