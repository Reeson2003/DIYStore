package ru.reeson2003.diystore.model.service;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertNotNull;

/**
 * Date: 13.05.2017.
 * Time: 11:56.
 *
 * @author Pavel Gavrilov.
 */
public class MessageManagerTest {
    private static MessageManager manager;

    @BeforeClass
    public static void initClass() {
        manager = new ClassPathXmlApplicationContext("spring_config.xml").
                getBean(MessageManager.class);
    }

    @Test
    public void managerNotNull() {
        assertNotNull(manager);
    }
}