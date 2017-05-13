package ru.reeson2003.diystore.model.dao.spring_jpa_dao;

import org.springframework.data.repository.CrudRepository;
import ru.reeson2003.diystore.model.domain.Product;

/**
 * Date: 13.05.2017.
 * Time: 11:48.
 *
 * @author Pavel Gavrilov.
 */
public interface ProductJpaRepository extends CrudRepository<Product, Long> {
}
