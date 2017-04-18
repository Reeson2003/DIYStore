package ru.reeson2003.diystore.model.service;

import ru.reeson2003.diystore.model.domain.Message;

import java.util.List;

/**
 * Date: 18.04.2017.
 * Time: 23:15.
 *
 * @author Pavel Gavrilov.
 */
public interface MessageManager {
    List<Message> getMessages(Long artisanId) throws DataStorageException;

    Message getMessage(Long productId) throws DataStorageException;

    void setMessage(Long artisanId, Message product) throws DataStorageException;

    void deleteMessage(Long productId) throws DataStorageException;
}
