package ru.reeson2003.diystore.model.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.reeson2003.diystore.model.domain.Artisan;
import ru.reeson2003.diystore.model.service.exception.DataStorageException;

import java.util.Date;
import java.util.List;

/**
 * Date: 27.04.2017.
 * Time: 22:55.
 *
 * @author Pavel Gavrilov.
 */
public interface ArtisanManager {
    void add(Artisan artisan);

    void update(Artisan artisan);

    void remove(Artisan artisan);

    void remove(Long id);

    List<Artisan> getAll();

    Artisan getById(Long id);

    Artisan getByUserName(String userName);

    List<Artisan> getAllByFirstName(String firstName);

    List<Artisan> getAllByLastName(String lastName);

    List<Artisan> getAllByBirthDate(Date date);
}
