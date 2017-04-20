package ru.reeson2003.diystore.model.samples;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import ru.reeson2003.diystore.model.domain.Product;
import ru.reeson2003.diystore.model.service.DataStorageException;
import ru.reeson2003.diystore.model.service.MessageManager;
import ru.reeson2003.diystore.model.service.ProductManager;

import java.util.List;

/**
 * Date: 19.04.2017.
 * Time: 20:17.
 *
 * @author Pavel Gavrilov.
 */
public class SpringTestXmlConfig {
    private static String configPath = "src/main/webapp/WEB-INF/spring-test-xml-config.xml";
    private ProductManager productManager;
    private MessageManager messageManager;

    public ProductManager getProductManager() {
        return productManager;
    }

    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }

    public MessageManager getMessageManager() {
        return messageManager;
    }

    public void setMessageManager(MessageManager messageManager) {
        this.messageManager = messageManager;
    }

    public static void main(String[] args) throws DataStorageException {
        ApplicationContext fileSystemContext = new FileSystemXmlApplicationContext(configPath);
        SpringTestXmlConfig springTest = (SpringTestXmlConfig) fileSystemContext.getBean("springTest");
        ProductManager pm = springTest.getProductManager();
        Class clazz = pm.getClass();
        System.out.println(">>>> Class name: [" +
                clazz.getName().substring(clazz.getPackage().getName().length() + 1) +
                "]");
        Product socks = springTest.getProduct(100L, "Socks");
        Product shirt = springTest.getProduct(500L, "Shirt");
        Product someBeer = springTest.getProduct(350L, "SomeBeer");
        Product portoWine = springTest.getProduct(200L, "Porto wine");
        pm.setProduct(1L, socks);
        pm.setProduct(1L, shirt);
        pm.setProduct(2L, portoWine);
        pm.setProduct(2L, someBeer);

        List<Product> user1list = pm.getProducts(1L);
        List<Product> user2list = pm.getProducts(2L);

        for (Product p : user1list) {
            System.out.println(p);
        }
        System.out.println("---------------------------------------");
        for (Product p : user2list) {
            System.out.println(p);
        }
    }

    public void execute() {

    }

    private Product getProduct(Long price, String description) {
        Product result = new Product();
        result.setDescription(description);
        result.setPrice(price);
        return result;
    }
}
