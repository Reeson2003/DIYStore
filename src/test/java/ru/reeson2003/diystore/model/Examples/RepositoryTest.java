package ru.reeson2003.diystore.model.Examples;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.reeson2003.diystore.model.domain.Artisan;
import ru.reeson2003.diystore.model.domain.Message;
import ru.reeson2003.diystore.model.domain.Product;
import ru.reeson2003.diystore.model.service.ArtisanManager;
import ru.reeson2003.diystore.model.service.MessageManager;
import ru.reeson2003.diystore.model.service.ProductManager;

import java.util.Arrays;

import static ru.reeson2003.diystore.model.service.EntityTestUtils.*;

/**
 * Date: 01.05.2017.
 * Time: 21:24.
 *
 * @author Pavel Gavrilov.
 */
public class RepositoryTest {
    private static Logger logger = LogManager.getLogger("TEST");

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring_config.xml");

        ArtisanManager artisanManager = context.getBean(ArtisanManager.class);
        ProductManager productManager = context.getBean(ProductManager.class);
        MessageManager messageManager = context.getBean(MessageManager.class);

        Product socks = getProduct("Socks", 120L);
        Product pants = getProduct("Pants", 214L);
        Product cake = getProduct("Cake", 43L);
        Product bread = getProduct("Bread", 14L);
        Product spoon = getProduct("Spoon", 35L);
        Product fork = getProduct("Fork", 37L);

        Message buySocks = getMessage("Byu socks");
        buySocks.setProduct(socks);
        Message buyPants = getMessage("Buy pants");
        buyPants.setProduct(pants);
        Message buyCake = getMessage("Buy cake");
        buyCake.setProduct(cake);
        Message buyBread = getMessage("Buy bread");
        buyBread.setProduct(bread);
        Message buySpoon = getMessage("Buy spoon");
        buySpoon.setProduct(spoon);
        Message buyFork = getMessage("Buy fork");
        buyFork.setProduct(fork);

        Artisan tailor = getArti("John Tailor", "j.tailor@mail.com", "12345");
        tailor.setProducts(Arrays.asList(socks, pants));
        tailor.setMessages(Arrays.asList(buySocks, buyPants));
        Artisan baker = getArti("Alice Baker", "abc@mail.net", "234234");
        baker.setProducts(Arrays.asList(cake, bread));
        baker.setMessages(Arrays.asList(buyCake, buyBread));
        Artisan smith = getArti("Tom Smith", "black@smith.com", "34Ghlsj*9JHgjK");
        smith.setProducts(Arrays.asList(spoon, fork));
        smith.setMessages(Arrays.asList(buySpoon, buyFork));

        artisanManager.save(tailor);
        artisanManager.save(baker);
        artisanManager.save(smith);

        logger.debug(artisanManager.findByName("Tom Smith").getProducts());
    }
}
