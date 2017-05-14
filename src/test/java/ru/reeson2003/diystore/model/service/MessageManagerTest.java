package ru.reeson2003.diystore.model.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertNotNull;
import static ru.reeson2003.diystore.model.service.EntityTestUtils.className;
import static ru.reeson2003.diystore.model.service.EntityTestUtils.methodName;

/**
 * Date: 13.05.2017.
 * Time: 11:56.
 *
 * @author Pavel Gavrilov.
 */
public class MessageManagerTest {
    private static final Logger logger = LogManager.getLogger("TEST");
    private MessageManager manager;

    @Before
    public void initTest() {
        manager = new ClassPathXmlApplicationContext("spring_config.xml").
                getBean(MessageManager.class);
    }

    @Test
    public void managerNotNull() {
        logger.info("Testing method: " + className() +"." + methodName());
        assertNotNull(manager);
    }
}