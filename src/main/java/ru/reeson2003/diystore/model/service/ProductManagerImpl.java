package ru.reeson2003.diystore.model.service;

import ru.reeson2003.diystore.model.domain.Product;

import java.util.List;

/**
 * Date: 27.04.2017.
 * Time: 22:27.
 *
 * @author Pavel Gavrilov.
 */
public class ProductManagerImpl implements ProductManager{
    public List<Product> getProducts(Long artisanId) throws DataStorageException {
        return null;
    }

    public Product getProduct(Long productId) throws DataStorageException {
        return null;
    }

    public void setProduct(Long artisanId, Product product) throws DataStorageException {

    }

    public void deleteProduct(Long productId) throws DataStorageException {

    }
}
