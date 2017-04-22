package ru.reeson2003.diystore.model.service.in_memory_manager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.reeson2003.diystore.model.domain.Product;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by myasnikov
 * on 20.04.2017.
 */
public class GenericManagerTest {

    private GenericManager<Product> genericManager;
    private Product product;

    @Before
    public void initTest() {
        genericManager = new GenericManager<>();
/*        artisan = Artisan.builder().email("test").id(1234L).password("1234").storeName("test name").build();
        product = new Product();
        product.setName("Toy");
        product.setPrice(100L);
        product.setDescription("Just toy");*/
    }
    @After
    public void tearDownTest() {
        genericManager = null;
    }
    @Test
    public void getItemsEmptyContainer() throws Exception {
        Random rand =  new Random();
        long id = rand.nextLong();
        genericManager.getItems(id);
        fail();
    }

    @Test
    public void getItemEmptyContainer() throws Exception {
        Random rand =  new Random();
        long id = rand.nextLong();
        genericManager.getItems(id);
        fail();
    }

    @Test
    public void setItemSimple() throws Exception {
        long id = 999L;
        Product product = new Product();
        product.setDescription("Test product");
        product.setPrice(1234L);
        product.setId(id);
        genericManager.setItem(1L, product);
        assertEquals(genericManager.getItem(id), product);
    }
    @Test
    public void setItemRand() throws Exception {
        Random rand = new Random();
        long id = rand.nextLong();
        Product product = new Product();
        product.setDescription("Test product");
        product.setPrice(1234L);
        product.setId(id);
        genericManager.setItem(1L, product);
        assertEquals(genericManager.getItem(id), product);
    }
    @Test
    public void deleteItem() throws Exception {
        Random rand = new Random();
        long id = rand.nextLong();
        Product product = new Product();
        product.setDescription("Test product");
        product.setPrice(1234L);
        product.setId(id);
        genericManager.setItem(1L, product);
        assertEquals(genericManager.getItem(id), product);
        genericManager.deleteItem(id);
        assertNull(genericManager.getItem(id));
        genericManager.deleteItem(id);
        fail();
    }
}
