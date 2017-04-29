package ru.reeson2003.diystore.model.service;

import ru.reeson2003.diystore.model.domain.Message;
import ru.reeson2003.diystore.model.service.exception.DataStorageException;

import java.util.List;

/**
 * Date: 18.04.2017.
 * Time: 23:15.
 *
 * @author Pavel Gavrilov.
 */
public interface MessageManager {
    List<Message> getAll(Long artisanId) throws DataStorageException;

    Message getById(Long productId) throws DataStorageException;

    void set(Long artisanId, Message product) throws DataStorageException;

    void delete(Long productId) throws DataStorageException;
}
