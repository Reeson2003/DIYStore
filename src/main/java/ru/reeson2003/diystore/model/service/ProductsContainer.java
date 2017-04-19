package ru.reeson2003.diystore.model.service;

import ru.reeson2003.diystore.model.domain.Product;

import java.util.*;

/**
 * Created by myasnikov
 * on 18.04.2017.
 */
public class ProductsContainer implements ProductManager {
    private static long productId = 0;
    private Map<Long, List<Product>> tree;

    public ProductsContainer() {
        tree = new HashMap<>();
    }
    public ProductsContainer(Map<Long, List<Product>> tree) {
        this.tree = tree;
    }

    private Long generateIdProduct() {


        // TODO: 18.04.2017
        return productId++;
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
    public void setProduct(final Long artisan, final Product product) throws DataStorageException {
//        String name = product.getName();
//        for (List<Product> value : tree.values()) {
//            for (Product pro : value) {
//                if (pro.getName().equals(name)) {
//                    throw new DException();  //the product with such name already exists
//                }                           // TODO: 18.04.2017
//            }
//        }
        product.setId(generateIdProduct());
        if (tree.containsKey(artisan)) {   //addition of a new product to the existing list of products of the user
            tree.get(artisan).add(product);
        } else {                   //creation of the new list of products for for the first time the created product
            List<Product> productList = new ArrayList<>();
            productList.add(product);
            tree.put(artisan, productList);
        }
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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Long key : tree.keySet()) {
            stringBuilder.append("Artisan ID ");
            stringBuilder.append("<");
            stringBuilder.append(key);
            stringBuilder.append(">");
            stringBuilder.append("\n");
            for (Product product : tree.get(key)) {
                stringBuilder.append("    Name ");
//                stringBuilder.append(product.getName());
                stringBuilder.append("\n");
                stringBuilder.append("    Product ID ");
                stringBuilder.append(product.getId());
                stringBuilder.append("\n");
                stringBuilder.append("    --------------------\n");
            }
        }
        return String.valueOf(stringBuilder);
    }
}
