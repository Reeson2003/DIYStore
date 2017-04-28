package ru.reeson2003.diystore.model.service;

import ru.reeson2003.diystore.model.domain.Message;
import ru.reeson2003.diystore.model.service.exception.DataStorageException;

import java.util.List;

/**
 * Date: 27.04.2017.
 * Time: 22:41.
 *
 * @author Pavel Gavrilov.
 */
public class MessageManagerImpl implements MessageManager {
    @Override
    public List<Message> getAll(Long artisanId) throws DataStorageException {
        return null;
    }

    @Override
    public Message getById(Long productId) throws DataStorageException {
        return null;
    }

    @Override
    public void set(Long artisanId, Message product) throws DataStorageException {

    }

    @Override
    public void delete(Long productId) throws DataStorageException {

    }
}
