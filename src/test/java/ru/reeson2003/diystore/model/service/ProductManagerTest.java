package ru.reeson2003.diystore.model.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import ru.reeson2003.diystore.model.domain.Product;
import ru.reeson2003.diystore.model.service.exception.DataStorageException;

import java.util.List;

import static org.junit.Assert.*;

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
                new FileSystemXmlApplicationContext("/src/main/resources/spring_config.xml");
        manager = (ProductManager) context.getBean("productManager");
        Class clazz = manager.getClass();
        String name = clazz.getName().substring(clazz.getPackage().getName().length()+1);
        System.out.println(">>>Class name: " + name);
    }

//    @Test
//    public void notEmtyListAfterInsert() {
//        Product p = getProduct("My product", 100L);
//        Long userId = 1L;
//        try {
//            manager.set(userId, p);
//        } catch (DataStorageException e) {
//            e.printStackTrace();
//            fail("Insert error");
//        }
//        List<Product> products = null;
//        try {
//            products = manager.getAll(userId);
//        } catch (DataStorageException e) {
//            e.printStackTrace();
//            fail("Get list error");
//        }
//        assertTrue(products.size() > 0);
//    }
//
//    @Test
//    public void equalProductBeforeAndAfterStorage() {
//        String desc = "My product unique name 1110001";
//        long price = 555666444333L;
//        Product pBefore = getProduct(desc, price);
//        try {
//            manager.set(1L, pBefore);
//        } catch (DataStorageException e) {
//            e.printStackTrace();
//            fail("Insert error");
//        }
//        List<Product> products = null;
//        try {
//            products = manager.getAll(1L);
//        } catch (DataStorageException e) {
//            e.printStackTrace();
//            fail("Get list error");
//        }
//        Product pAfter = products.get(0);
//        assertTrue(pAfter.getDescription().equals(pBefore.getDescription()) &&
//                pAfter.getPrice() == pBefore.getPrice());
//    }
//    @Test
//    public void idSet() {
//        Product p = getProduct("My product", 100L);
//        Long userId = 1L;
//        try {
//            manager.set(userId, p);
//        } catch (DataStorageException e) {
//            e.printStackTrace();
//            fail("Insert error");
//        }
//        List<Product> products = null;
//        try {
//            products = manager.getAll(userId);
//        } catch (DataStorageException e) {
//            e.printStackTrace();
//            fail("Get list error");
//        }
//        Product product = products.get(0);
//        assertNotNull(product.getId());
//    }
//
//    @Test
//    public void uniqueIdSet() {
//        Product p1 = getProduct("1-st product", 100L);
//        Product p2 = getProduct("2-nd product", 200L);
//        Product p3 = getProduct("3-rd product", 300L);
//        try {
//            manager.set(1L, p1);
//            manager.set(1L, p2);
//            manager.set(1L, p3);
//        } catch (DataStorageException e) {
//            e.printStackTrace();
//            fail("Insert error");
//        }
//        List<Product> products = null;
//        try {
//            products = manager.getAll(1L);
//        } catch (DataStorageException e) {
//            e.printStackTrace();
//            fail("Get list error");
//        }
//        assertTrue(!products.get(0).getId().equals(products.get(1).getId()) &&
//                !products.get(1).getId().equals(products.get(2).getId()) &&
//                !products.get(0).getId().equals(products.get(2).getId()));
//    }

    private Product getProduct(String desc, Long price) {
        Product product = new Product();
        product.setDescription(desc);
        product.setPrice(price);
        return product;
    }
}
