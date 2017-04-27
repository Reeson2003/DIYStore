package ru.reeson2003.diystore.model.service;

import ru.reeson2003.diystore.model.domain.Message;

import java.util.List;

/**
 * Date: 27.04.2017.
 * Time: 22:41.
 *
 * @author Pavel Gavrilov.
 */
public class MessageManagerImpl implements MessageManager {
    @Override
    public List<Message> getMessages(Long artisanId) throws DataStorageException {
        return null;
    }

    @Override
    public Message getMessage(Long productId) throws DataStorageException {
        return null;
    }

    @Override
    public void setMessage(Long artisanId, Message product) throws DataStorageException {

    }

    @Override
    public void deleteMessage(Long productId) throws DataStorageException {

    }
}
