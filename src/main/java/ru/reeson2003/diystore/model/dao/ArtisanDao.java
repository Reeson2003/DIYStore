package ru.reeson2003.diystore.model.dao;

import ru.reeson2003.diystore.model.domain.Artisan;

import java.util.Date;
import java.util.List;

/**
 * Date: 13.05.2017.
 * Time: 9:07.
 *
 * @author Pavel Gavrilov.
 */
public interface ArtisanDao {
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
