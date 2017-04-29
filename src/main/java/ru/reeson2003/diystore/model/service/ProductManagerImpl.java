package ru.reeson2003.diystore.model.service;

import ru.reeson2003.diystore.model.domain.Product;
import ru.reeson2003.diystore.model.service.exception.DataStorageException;

import java.util.List;

/**
 * Date: 27.04.2017.
 * Time: 22:27.
 *
 * @author Pavel Gavrilov.
 */
public class ProductManagerImpl implements ProductManager{
    public List<Product> getAll(Long artisanId) throws DataStorageException {
        return null;
    }

    public Product getById(Long productId) throws DataStorageException {
        return null;
    }

    public void set(Long artisanId, Product product) throws DataStorageException {

    }

    public void delete(Long productId) throws DataStorageException {

    }
}
