package ru.reeson2003.diystore.model.service;

import ru.reeson2003.diystore.model.domain.Product;

/**
 * Date: 18.04.2017.
 * Time: 7:55.
 *
 * @author Pavel Gavrilov.
 */
public interface ProductManager{
    void add(Product product);

    void update(Product product);

    void remove(Product product);

    void remove(Long id);

    Product getById(Long id);
}
