package ru.reeson2003.diystore.model.dao.spring_jpa_dao;

import org.springframework.beans.factory.annotation.Autowired;
import ru.reeson2003.diystore.model.dao.ProductDao;
import ru.reeson2003.diystore.model.domain.Product;

/**
 * Date: 13.05.2017.
 * Time: 11:44.
 *
 * @author Pavel Gavrilov.
 */
public class ProductJpaDao implements ProductDao {
    private ProductJpaRepository productJpaRepository;

    @Override
    public void add(Product product) {
        productJpaRepository.save(product);
    }

    @Override
    public void update(Product product) {
        productJpaRepository.save(product);
    }

    @Override
    public void remove(Product product) {
        productJpaRepository.delete(product);
    }

    @Override
    public void remove(Long id) {
        productJpaRepository.delete(id);
    }

    @Override
    public Product getById(Long id) {
        return productJpaRepository.findOne(id);
    }

    public ProductJpaRepository getProductJpaRepository() {
        return productJpaRepository;
    }

    @Autowired
    public void setProductJpaRepository(ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }
}
