package ru.reeson2003.diystore.model.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import ru.reeson2003.diystore.model.dao.ProductDao;
import ru.reeson2003.diystore.model.dao.spring_jpa_dao.ProductJpaDao;
import ru.reeson2003.diystore.model.domain.Product;

import static org.junit.Assert.*;
import static ru.reeson2003.diystore.model.service.EntityTestUtils.*;

/**
 * Date: 22.04.2017.
 * Time: 23:00.
 *
 * @author Pavel Gavrilov.
 */
public class ProductManagerTest {
    private static final Logger logger = LogManager.getLogger("TEST");
    private ProductManager manager;

    @Before
    public void initTest() {
        manager = new ClassPathXmlApplicationContext("spring_config.xml").
                getBean(ProductManager.class);
    }


    @Test
    public void managerNotNull() {
        logger.info("Testing method: " + className() +"." + methodName());
        assertNotNull(manager);
    }
    @Test
    public void managerAddProductSimpleTest() {
        logger.info("Testing method: " + className() +"." + methodName());
        String expectedString = "Simple test add product";
        Long expectedPrice = 12345L;
        Product expectedProduct = getProduct(expectedString, expectedPrice);
        manager.add(expectedProduct);
        Product resultingProduct = manager.getById(expectedProduct.getId());
        assertTrue(expectedProduct.equals(resultingProduct));
    }

    @Test
    public void managerAddProductDefault() {
        logger.info("Testing method: " + className() +"." + methodName());
        Product expectedProduct = new Product();
        manager.add(expectedProduct);
        Product resultingProduct = manager.getById(expectedProduct.getId());
        assertTrue(expectedProduct.equals(resultingProduct));
    }

    @Test(expected = InvalidDataAccessApiUsageException.class)
    public void managerAddProductNull() {
        logger.info("Testing method: " + className() +"." + methodName());
        Product expectedProduct = null;
        manager.add(expectedProduct);
    }
    @Test
    public void removeTestOnProductSimple() {
        logger.info("Testing method: " + className() +"." + methodName());
        String expectedString = "Simple test remove product by obj";
        Long expectedPrice = 12345L;
        Product expectedProduct = getProduct(expectedString, expectedPrice);
        Long idExpectedProduct;

        manager.add(expectedProduct);
        idExpectedProduct = expectedProduct.getId();
        manager.remove(expectedProduct);
        assertNull(manager.getById(idExpectedProduct));
    }

    @Test
    public void removeTestOnProductDefault() {
        logger.info("Testing method: " + className() +"." + methodName());
        Product expectedProduct = new Product();
        Long idExpectedProduct;

        manager.add(expectedProduct);
        idExpectedProduct = expectedProduct.getId();
        manager.remove(expectedProduct);
        assertNull(manager.getById(idExpectedProduct));
    }

    @Test(expected = InvalidDataAccessApiUsageException.class)
    public void removeTestOnProductNull() {
        logger.info("Testing method: " + className() +"." + methodName());
        Product expectedProduct = null;
        manager.remove(expectedProduct);
    }

    @Test
    public void removeTestOnIdSimple() {
        logger.info("Testing method: " + className() +"." + methodName());
        String expectedString = "Simple test remove product by Id";
        Long expectedPrice = 12345L;
        Product expectedProduct = getProduct(expectedString, expectedPrice);
        Long idExpectedProduct;

        manager.add(expectedProduct);
        idExpectedProduct = expectedProduct.getId();
        manager.remove(idExpectedProduct);
        assertNull(manager.getById(idExpectedProduct));
    }

    @Test
    public void removeTestOnIdDefault() {
        logger.info("Testing method: " + className() +"." + methodName());
        Product expectedProduct = new Product();
        Long idExpectedProduct;

        manager.add(expectedProduct);
        idExpectedProduct = expectedProduct.getId();
        manager.remove(idExpectedProduct);
        assertNull(manager.getById(idExpectedProduct));
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
        String expectedString = "Simple test get product by id";
        Long expectedPrice = 12345L;
        Product expectedProduct = getProduct(expectedString, expectedPrice);
        Long idExpectedProduct;
        Product resultingProduct;

        manager.add(expectedProduct);
        idExpectedProduct = expectedProduct.getId();
        resultingProduct = manager.getById(idExpectedProduct);
        assertTrue(expectedProduct.equals(resultingProduct));
    }

    @Test
    public void getTestByIdDefault() {
        logger.info("Testing method: " + className() +"." + methodName());
        Product expectedProduct = new Product();
        Long idExpectedProduct;
        Product resultingProduct;

        manager.add(expectedProduct);
        idExpectedProduct = expectedProduct.getId();
        resultingProduct = manager.getById(idExpectedProduct);
        assertTrue(expectedProduct.equals(resultingProduct));
    }

    @Test
    public void getTestByIdBeforeSetId() {
        logger.info("Testing method: " + className() +"." + methodName());
        Product expectedProduct = new Product();
        Long idExpectedProduct = 345698L;
        Product resultingProduct;
        expectedProduct.setId(idExpectedProduct);

        manager.add(expectedProduct);
        resultingProduct = manager.getById(idExpectedProduct);
        assertTrue(expectedProduct.equals(resultingProduct));
    }

    @Test
    public void getTestByIdAfterSetId() {
        logger.info("Testing method: " + className() +"." + methodName());
        Product expectedProduct = new Product();
        Long idExpectedProduct = 345698L;
        Product resultingProduct;

        manager.add(expectedProduct);
        expectedProduct.setId(idExpectedProduct);
        resultingProduct = manager.getById(idExpectedProduct);
        assertTrue(expectedProduct.equals(resultingProduct));
    }

    @Test(expected = InvalidDataAccessApiUsageException.class)
    public void getTestByIdNull() {
        logger.info("Testing method: " + className() +"." + methodName());
        Long expectedId = null;
        manager.remove(expectedId);
    }

    @Test
    public void getTestProductDaoSimple() {
        logger.info("Testing method: " + className() +"." + methodName());
        String expectedString = "Simple test get product DAO";
        Long expectedPrice = 12345L;
        Product expectedProduct = getProduct(expectedString, expectedPrice);

        manager.add(expectedProduct);
        ProductDao productDao = null;
        if (manager instanceof ProductManagerImpl) {
            productDao = ((ProductManagerImpl)manager).getProductDao();
        }
        assertNotNull(productDao);
    }

    @Test
    public void setProductDao() {
        logger.info("Testing method: " + className() +"." + methodName());
        String expectedString = "Simple test set product DAO";
        Long expectedPrice = 12345L;
        Product expectedProduct = getProduct(expectedString, expectedPrice);
        ProductDao expectedProductDao = new ProductJpaDao();
        manager.add(expectedProduct);
        expectedProductDao.update(expectedProduct);
        ProductDao resultingProductDao = ((ProductManagerImpl)manager).getProductDao();
        assertTrue(expectedProductDao.equals(resultingProductDao));
    }

    @Test
    public void setPriceTestSimple() {
        logger.info("Testing method: " + className() +"." + methodName());
        String expectedString = "Simple test set product price";
        Long expectedPrice = 12345L;
        Long initialPrice = 54321L;
        Product expectedProduct = getProduct(expectedString, initialPrice);
        expectedProduct.setPrice(expectedPrice);
        assertTrue(expectedPrice.equals(expectedProduct.getPrice()));
    }

    @Test
    public void getDescriptionTestSimple() {
        logger.info("Testing method: " + className() +"." + methodName());
        String expectedString = "Simple test set product description";
        Long initialPrice = 54321L;
        Product expectedProduct = getProduct(expectedString, initialPrice);
        String resultString = expectedProduct.getDescription();
        assertEquals(expectedString, resultString);
    }
}
