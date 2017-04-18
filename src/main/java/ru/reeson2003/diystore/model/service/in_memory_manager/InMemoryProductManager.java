package ru.reeson2003.diystore.model.service.in_memory_manager;

import ru.reeson2003.diystore.model.domain.Product;
import ru.reeson2003.diystore.model.service.DataStorageException;
import ru.reeson2003.diystore.model.service.ProductManager;

import java.util.List;

/**
 * Date: 18.04.2017.
 * Time: 23:18.
 *
 * @author Pavel Gavrilov.
 */
public class InMemoryProductManager implements ProductManager {
    private GenericManager<Product> genericManager;

    public InMemoryProductManager() {
        genericManager = new GenericManager<Product>();
    }
    public List<Product> getProducts(Long artisanId) throws DataStorageException {
        return genericManager.getItems(artisanId);
    }

    public Product getProduct(Long productId) throws DataStorageException {
        return genericManager.getItem(productId);
    }

    public void setProduct(Long artisanId, Product product) throws DataStorageException {
        genericManager.setItem(artisanId, product);
    }

    public void deleteProduct(Long productId) throws DataStorageException {
        genericManager.deleteItem(productId);
    }
}
