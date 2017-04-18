package ru.reeson2003.diystore.model.service.in_memory_manager;

import ru.reeson2003.diystore.model.domain.Message;
import ru.reeson2003.diystore.model.service.DataStorageException;
import ru.reeson2003.diystore.model.service.MessageManager;

import java.util.List;

/**
 * Date: 18.04.2017.
 * Time: 23:52.
 *
 * @author Pavel Gavrilov.
 */
public class InMemoryMessageManager implements MessageManager {
    private GenericManager<Message> genericManager;

    public InMemoryMessageManager() {
        genericManager = new GenericManager<Message>();
    }

    public List<Message> getMessages(Long artisanId) throws DataStorageException {
        return genericManager.getItems(artisanId);
    }

    public Message getMessage(Long productId) throws DataStorageException {
        return genericManager.getItem(productId);
    }

    public void setMessage(Long artisanId, Message product) throws DataStorageException {
        genericManager.setItem(artisanId, product);
    }

    public void deleteMessage(Long productId) throws DataStorageException {
        genericManager.deleteItem(productId);
    }
}
