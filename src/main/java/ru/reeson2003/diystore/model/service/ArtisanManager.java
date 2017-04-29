package ru.reeson2003.diystore.model.service;

import ru.reeson2003.diystore.model.domain.Artisan;
import ru.reeson2003.diystore.model.service.exception.DataStorageException;

import java.util.List;

/**
 * Date: 27.04.2017.
 * Time: 22:55.
 *
 * @author Pavel Gavrilov.
 */
public interface ArtisanManager {

    void set(Artisan artisan) throws DataStorageException;

    List<Artisan> getAll() throws DataStorageException;

    Artisan getById(Long id) throws DataStorageException;

    Artisan getByName(String name) throws DataStorageException;

    Artisan getByEmail(String email) throws DataStorageException;
}
