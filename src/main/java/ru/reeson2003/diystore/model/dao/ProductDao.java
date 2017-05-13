package ru.reeson2003.diystore.model.dao;

import ru.reeson2003.diystore.model.domain.Product;

/**
 * Date: 13.05.2017.
 * Time: 9:07.
 *
 * @author Pavel Gavrilov.
 */
public interface ProductDao {
    void add(Product product);

    void update(Product product);

    void remove(Product product);

    void remove(Long id);

    Product getById(Long id);
}
