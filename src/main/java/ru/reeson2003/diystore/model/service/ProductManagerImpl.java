package ru.reeson2003.diystore.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.reeson2003.diystore.model.dao.ProductDao;
import ru.reeson2003.diystore.model.domain.Product;

/**
 * Date: 13.05.2017.
 * Time: 11:52.
 *
 * @author Pavel Gavrilov.
 */
public class ProductManagerImpl implements ProductManager {
    private ProductDao productDao;

    @Override
    public void add(Product product) {
        productDao.add(product);
    }

    @Override
    public void update(Product product) {
        productDao.update(product);
    }

    @Override
    public void remove(Product product) {
        productDao.remove(product);
    }

    @Override
    public void remove(Long id) {
        productDao.remove(id);
    }

    @Override
    public Product getById(Long id) {
        return productDao.getById(id);
    }

    public ProductDao getProductDao() {
        return productDao;
    }

    @Autowired
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }
}
