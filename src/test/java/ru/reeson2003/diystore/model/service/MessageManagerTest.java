package ru.reeson2003.diystore.model.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import ru.reeson2003.diystore.model.dao.MessageDao;
import ru.reeson2003.diystore.model.dao.spring_jpa_dao.MessageJpaDao;
import ru.reeson2003.diystore.model.domain.Message;

import static org.junit.Assert.*;
import static ru.reeson2003.diystore.model.service.EntityTestUtils.className;
import static ru.reeson2003.diystore.model.service.EntityTestUtils.methodName;
import static ru.reeson2003.diystore.model.service.EntityTestUtils.*;

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

    @Test
    public void managerAddMessageSimpleTest() {
        logger.info("Testing method: " + className() +"." + methodName());
        String expectedString = "Simple test add message";
        Message expectedMessage = getMessage(expectedString);
        manager.add(expectedMessage);
        Message resultingMessage = manager.getById(expectedMessage.getId());
        assertTrue(expectedMessage.equals(resultingMessage));
    }

    @Test
    public void managerAddMessageDefault() {
        logger.info("Testing method: " + className() +"." + methodName());
        Message expectedMessage = new Message();
        manager.add(expectedMessage);
        Message resultingMessage = manager.getById(expectedMessage.getId());
        assertTrue(expectedMessage.equals(resultingMessage));
    }

    @Test(expected = InvalidDataAccessApiUsageException.class)
    public void managerAddMessageNull() {
        logger.info("Testing method: " + className() +"." + methodName());
        Message expectedMessage = null;
        manager.add(expectedMessage);
    }
    @Test
    public void removeTestOnMessageSimple() {
        logger.info("Testing method: " + className() +"." + methodName());
        String expectedString = "Simple test remove message by obj";
        Message expectedMessage = getMessage(expectedString);
        Long idExpectedMessage;

        manager.add(expectedMessage);
        idExpectedMessage = expectedMessage.getId();
        manager.remove(expectedMessage);
        assertNull(manager.getById(idExpectedMessage));
    }

    @Test
    public void removeTestOnMessageDefault() {
        logger.info("Testing method: " + className() +"." + methodName());
        Message expectedMessage = new Message();
        Long idExpectedMessage;
        manager.add(expectedMessage);
        idExpectedMessage = expectedMessage.getId();
        manager.remove(expectedMessage);
        assertNull(manager.getById(idExpectedMessage));
    }

    @Test(expected = InvalidDataAccessApiUsageException.class)
    public void removeTestOnMessageNull() {
        logger.info("Testing method: " + className() +"." + methodName());
        Message expectedMessage = null;
        manager.remove(expectedMessage);
    }

    @Test
    public void removeTestOnIdSimple() {
        logger.info("Testing method: " + className() +"." + methodName());
        String expectedString = "Simple test remove message by Id";
        Message expectedMessage = getMessage(expectedString);
        Long idExpectedMessage;

        manager.add(expectedMessage);
        idExpectedMessage = expectedMessage.getId();
        manager.remove(idExpectedMessage);
        assertNull(manager.getById(idExpectedMessage));
    }

    @Test
    public void removeTestOnIdDefault() {
        logger.info("Testing method: " + className() +"." + methodName());
        Message expectedMessage = new Message();
        Long idExpectedMessage;
        manager.add(expectedMessage);
        idExpectedMessage = expectedMessage.getId();
        manager.remove(idExpectedMessage);
        assertNull(manager.getById(idExpectedMessage));
    }

    @Test
    public void removeTestOnIdInvalidNegative() {
        logger.info("Testing method: " + className() +"." + methodName());
        Long idNegative = -13163L;
        assertNotNull(manager.getById(idNegative));
    }

    @Test(expected = InvalidDataAccessApiUsageException.class)
    public void removeTestOnIdNull() {
        logger.info("Testing method: " + className() +"." + methodName());
        Long expectedId = null;
        manager.remove(expectedId);
    }
    @Test
    public void getTestByIdSimple() {
        logger.info("Testing method: " + className() +"." + methodName());
        String expectedString = "Simple test get message by id";
        Message expectedMessage = getMessage(expectedString);
        Long idExpectedMessage;
        Message resultingMessage;

        manager.add(expectedMessage);
        idExpectedMessage = expectedMessage.getId();
        resultingMessage = manager.getById(idExpectedMessage);
        assertTrue(expectedMessage.equals(resultingMessage));
    }

    @Test
    public void getTestByIdDefault() {
        logger.info("Testing method: " + className() +"." + methodName());
        Message expectedMessage = new Message();
        Long idExpectedMessage;
        Message resultingMessage;

        manager.add(expectedMessage);
        idExpectedMessage = expectedMessage.getId();
        resultingMessage = manager.getById(idExpectedMessage);
        assertTrue(expectedMessage.equals(resultingMessage));
    }

    @Test
    public void getTestByIdBeforeSetId() {
        logger.info("Testing method: " + className() +"." + methodName());
        Message expectedMessage = new Message();
        Long idExpectedMessage = 345698L;
        Message resultingMessage;
        expectedMessage.setId(idExpectedMessage);

        manager.add(expectedMessage);
        resultingMessage = manager.getById(idExpectedMessage);
        assertTrue(expectedMessage.equals(resultingMessage));
    }

    @Test
    public void getTestByIdAfterSetId() {
        logger.info("Testing method: " + className() +"." + methodName());
        Message expectedMessage = new Message();
        Long idExpectedMessage = 345698L;
        Message resultingMessage;

        manager.add(expectedMessage);
        expectedMessage.setId(idExpectedMessage);
        resultingMessage = manager.getById(idExpectedMessage);
        assertTrue(expectedMessage.equals(resultingMessage));
    }

    @Test(expected = InvalidDataAccessApiUsageException.class)
    public void getTestByIdNull() {
        logger.info("Testing method: " + className() +"." + methodName());
        Long expectedId = null;
        manager.remove(expectedId);
    }

    @Test
    public void getTestMessageDaoSimple() {
        logger.info("Testing method: " + className() +"." + methodName());
        String expectedString = "Simple test get message DAO";
        Message expectedMessage = getMessage(expectedString);

        manager.add(expectedMessage);
        MessageDao messageDao = null;
        if (manager instanceof MessageManagerImpl) {
            messageDao = ((MessageManagerImpl)manager).getMessageDao();
        }
        assertNotNull(messageDao);
    }

    @Test
    public void setMessageDao() {
        logger.info("Testing method: " + className() +"." + methodName());
        String expectedString = "Simple test set message DAO";
        Message expectedMessage = getMessage(expectedString);
        MessageDao expectedMessageDao = new MessageJpaDao();
        manager.add(expectedMessage);
        expectedMessageDao.update(expectedMessage);
        MessageDao resultingMessageDao = ((MessageManagerImpl)manager).getMessageDao();
        assertTrue(expectedMessageDao.equals(resultingMessageDao));
    }
}