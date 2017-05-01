package ru.reeson2003.diystore.model.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.reeson2003.diystore.model.domain.Product;
import ru.reeson2003.diystore.model.service.exception.DataStorageException;

import java.util.List;

/**
 * Date: 18.04.2017.
 * Time: 7:55.
 *
 * @author Pavel Gavrilov.
 */
@Repository
public interface ProductManager extends JpaRepository<Product, Long> {

}
