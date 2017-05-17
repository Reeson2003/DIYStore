package ru.reeson2003.diystore.model.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.reeson2003.diystore.model.domain.Artisan;
import ru.reeson2003.diystore.model.domain.Message;
import ru.reeson2003.diystore.model.domain.Product;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static ru.reeson2003.diystore.model.service.EntityTestUtils.*;

/**
 * Date: 27.04.2017.
 * Time: 22:58.
 *
 * @author Pavel Gavrilov.
 */
public class ArtisanManagerTest {
    private static final String NAME = "Gordon";
    private static final String EMAIL = "g.freeman@gmail.com";
    private static final String PASSWORD = "123asd";
    private static final String SOCKS = "Socks";
    private static final Long SOCKS_PRICE = 134L;
    private static final String SHIRT = "Shirt";
    private static final Long SHIRT_PRICE = 513L;
    private static final String SOCKS_MESSAGE = "Buy socks";
    private static final String SHIRT_MESSAGE = "Buy shirt";
    private static final Logger logger = LogManager.getLogger("TEST");
    private Artisan artisan;
    private ArtisanManager manager;

    @Before
    public void initTest() {
        manager = new ClassPathXmlApplicationContext("spring_config.xml").
                getBean(ArtisanManager.class);
        artisan = getArti(NAME, EMAIL, PASSWORD);
        Product socks = getProduct(SOCKS, SOCKS_PRICE);
        Product shirt = getProduct(SHIRT, SHIRT_PRICE);
        Message socks_msg = getMessage(SOCKS_MESSAGE);
        socks_msg.setProduct(socks);
        Message shirt_msg = getMessage(SHIRT_MESSAGE);
        shirt_msg.setProduct(shirt);
        artisan.setProducts(Arrays.asList(socks, shirt));
        artisan.setMessages(Arrays.asList(socks_msg, shirt_msg));
    }

    @Test
    public void managerNotNull() {
        logger.info("Testing method: " + className() +"." + methodName());
        assertNotNull(manager);
    }

    @Test
    public void findUserByNameTest() {
        logger.info("Testing method: " + className() +"." + methodName());
        String expectedName = "Vasya";
        Artisan expectedArtisan = new Artisan(expectedName, "www", "13");
        manager.add(expectedArtisan);
        Artisan resultingArtisan = manager.getByUserName(expectedName);
        String resultingName = resultingArtisan.getUserName();
        assertTrue(expectedName.equals(resultingName) ||
                    expectedArtisan.equals(resultingArtisan));
    }

    @Test
    @Ignore
    public void findAllByFirstNameTest() {
        logger.info("Testing method: " + className() +"." + methodName());
        int number = 10;
        for (int i = 0; i < number; i++) {
            manager.add(getArti(NAME, EMAIL, PASSWORD));
        }
        List<Artisan> artisans = manager.getAllByFirstName(NAME);
        assertNotNull(artisans);
        assertTrue(artisans.size() == number);
    }

    @Test
    public void idGenerateTest() {
        logger.info("Testing method: " + className() +"." + methodName());
        assertNull(artisan.getId());
        manager.add(artisan);
        Artisan tmp = manager.getByUserName(NAME);
        assertNotNull(tmp.getId());
    }

    @Test
    public void findByIdTest() {
        logger.info("Testing method: " + className() +"." + methodName());
        manager.add(artisan);
        Artisan tmp = manager.getByUserName(NAME);
        Long id = tmp.getId();
        tmp = manager.getById(id);
        assertNotNull(tmp);
        assertTrue(tmp.equals(artisan));
    }

    @Test
    public void updateTest() {
        logger.info("Testing method: " + className() +"." + methodName());
        String name = "Marcus";
        manager.add(artisan);
        Artisan tmp = manager.getByUserName(NAME);
        Long id = tmp.getId();
        tmp.setUserName(name);
        manager.add(tmp);
        Artisan tmpNew = manager.getById(id);
        assertTrue(tmp.equals(tmpNew));
    }

    @Test
    public void productsNotNullTest() {
        logger.info("Testing method: " + className() +"." + methodName());
        manager.add(artisan);
        Artisan tmp = manager.getByUserName(NAME);
        assertNotNull(tmp.getProducts());
    }

    @Test
    public void messagesNotNullTest() {
        logger.info("Testing method: " + className() +"." + methodName());
        manager.add(artisan);
        Artisan tmp = manager.getByUserName(NAME);
        assertNotNull(tmp.getMessages());
    }
}
