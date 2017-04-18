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
    List<Product> getProducts(long artisanId);

    Product getProduct(long productId);

    void setProduct(Product product);

    void deleteProduct(long productId);
}
