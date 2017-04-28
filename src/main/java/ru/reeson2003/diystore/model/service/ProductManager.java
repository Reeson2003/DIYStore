package ru.reeson2003.diystore.model.service;

import ru.reeson2003.diystore.model.domain.Product;
import ru.reeson2003.diystore.model.service.exception.DataStorageException;

import java.util.List;

/**
 * Date: 18.04.2017.
 * Time: 7:55.
 *
 * @author Pavel Gavrilov.
 */
public interface ProductManager {
    List<Product> getAll(Long artisanId) throws DataStorageException;

    Product getById(Long productId) throws DataStorageException;

    void set(Long artisanId, Product product) throws DataStorageException;

    void delete(Long productId) throws DataStorageException;
}
