package ru.reeson2003.diystore.model.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;
import static ru.reeson2003.diystore.model.service.EntityTestUtils.*;

/**
 * Date: 22.04.2017.
 * Time: 23:00.
 *
 * @author Pavel Gavrilov.
 */
public class ProductManagerTest {
    private ProductManager manager;

    @Before
    public void initTest() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring_config.xml");
        manager = context.getBean(ProductManager.class);
        Class clazz = manager.getClass();
        String name = clazz.getName().substring(clazz.getPackage().getName().length()+1);
        System.out.println(">>>Class name: " + name);
    }

    @Test
    public void managerNotNull() {
        assertNotNull(manager);
    }
}
