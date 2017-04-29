package ru.reeson2003.diystore.model.service;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Date: 27.04.2017.
 * Time: 22:58.
 *
 * @author Pavel Gavrilov.
 */
public class ArtisanManagerTest {
    private ArtisanManager manager;

    @Before
    public void initTest() {
        ApplicationContext context =
                new FileSystemXmlApplicationContext("/src/main/resources/spring_config.xml");
        manager = (ArtisanManager) context.getBean("artisanManager");
        Class clazz = manager.getClass();
        String name = clazz.getName().substring(clazz.getPackage().getName().length()+1);
        System.out.println(">>>Class name: " + name);
    }
}
