package ru.reeson2003.diystore.model.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import ru.reeson2003.diystore.model.domain.Artisan;
import ru.reeson2003.diystore.model.domain.Message;
import ru.reeson2003.diystore.model.domain.Product;

import java.util.Arrays;

import static org.junit.Assert.*;

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

    @BeforeClass
    public static void initClass() {
        ArtisanManager manager =
                new ClassPathXmlApplicationContext("spring_config.xml").
                        getBean(ArtisanManager.class);
        logger.info("Initializing " +
                ArtisanManagerTest.class.getName());
    }

    @Before
    public void initTest() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring_config.xml");
        manager = context.getBean(ArtisanManager.class);
        logger.info(manager.getClass().getName());
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
    public void findByNameTest() {
        manager.save(artisan);
        Artisan tmp = manager.findByName(NAME);
        assertEquals(tmp.getName(), NAME);
    }

    private static Message getMessage(String msg) {
        Message message = new Message();
        message.setMessage(msg);
        return message;
    }

    private static Product getProduct(String desc, Long price) {
        Product product = new Product();
        product.setDescription(desc);
        product.setPrice(price);
        return product;
    }

    private static Artisan getArti(String name, String email, String pass) {
        Artisan artisan = new Artisan();
        artisan.setName(name);
        artisan.setEmail(email);
        artisan.setPassword(pass);
        return artisan;
    }
}
