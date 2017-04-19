package ru.reeson2003.diystore.model.service;

import ru.reeson2003.diystore.model.domain.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by myasnikov
 * on 18.04.2017.
 */
public class Separator implements ProductManager {

    private Map<Long, List<Product>> tree;

    public Separator() {
        tree = new HashMap<>();
    }

    public Separator(Map<Long, List<Product>> tree) {
        this.tree = tree;
    }

    @Override
    public List<Product> getProducts(Long artisanId) throws DataStorageException {
        if (!tree.containsKey(artisanId))  //the user has no registered products
            throw new DataStorageException();         // TODO: 18.04.2017
        return tree.get(artisanId);
    }

    @Override
    public Product getProduct(final Long productId) throws DataStorageException {
        for (List<Product> value : tree.values()) {
            for (Product product : value) {
                if (product.getId() == productId) {
                    return product;
                }
            }
        }                                 //the user doesn't have it products
        throw new DataStorageException();            // TODO: 18.04.2017
    }

    @Override
    public void setProduct(final Long artisanId, final Product product) throws DataStorageException {
//        if (!tree.containsKey(artisanId)) {  //not registered user
//            throw new DataStorageException();           // TODO: 18.04.2017
//        }
        if (tree.get(artisanId).contains(product)) { //product it is already registered
            throw new DataStorageException();           // TODO: 18.04.2017
        }
        tree.get(artisanId).add(product);
    }

    @Override
    public void deleteProduct(Long productId) throws DataStorageException {
        for (List<Product> value : tree.values()) {
            for (Product product : value) {
                if (product.getId() == productId) {
                    value.remove(product);
                    return;
                }
            }
        }                                 //the user doesn't have it products
        throw new DataStorageException();            // TODO: 18.04.2017
    }
}
