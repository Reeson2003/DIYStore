package ru.reeson2003.diystore.model.service;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertNotNull;

/**
 * Date: 22.04.2017.
 * Time: 23:00.
 *
 * @author Pavel Gavrilov.
 */
public class ProductManagerTest {
    private static ProductManager manager;

    @BeforeClass
    public static void initClass() {
        manager = new ClassPathXmlApplicationContext("spring_config.xml").
                getBean(ProductManager.class);
    }


    @Test
    public void managerNotNull() {
        assertNotNull(manager);
    }
}
