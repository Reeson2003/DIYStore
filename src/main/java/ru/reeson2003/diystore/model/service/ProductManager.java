package ru.reeson2003.diystore.model.service;

import ru.reeson2003.diystore.model.domain.Product;

import java.util.List;

/**
 * Date: 18.04.2017.
 * Time: 7:55.
 *
 * @author Pavel Gavrilov.
 */
public interface ProductManager {
    List<Product> getProducts(Long artisanId) throws DataStorageException;

    Product getProduct(Long productId) throws DataStorageException;

    void setProduct(Long artisanId, Product product) throws DataStorageException;

    void deleteProduct(Long productId) throws DataStorageException;
}
