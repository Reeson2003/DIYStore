package ru.reeson2003.diystore.model.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.reeson2003.diystore.model.domain.Artisan;
import ru.reeson2003.diystore.model.service.exception.DataStorageException;

import java.util.List;

/**
 * Date: 27.04.2017.
 * Time: 22:55.
 *
 * @author Pavel Gavrilov.
 */
@Repository
public interface ArtisanManager extends JpaRepository<Artisan, Long> {

}
