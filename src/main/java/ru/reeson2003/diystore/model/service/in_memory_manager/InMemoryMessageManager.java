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
        genericManager = new GenericManager<>();
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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Long key : genericManager.getContainer().keySet()) {
            stringBuilder.append("\nProduct ID ");
            stringBuilder.append("<");
            stringBuilder.append(key);
            stringBuilder.append(">");
            stringBuilder.append("\n");
            stringBuilder.append("All message: \n");
            for (Long productId : genericManager.getContainer().get(key).keySet()) {
                stringBuilder.append("           Message ID ");
                stringBuilder.append("<");
                stringBuilder.append(productId);
                stringBuilder.append(">");
                stringBuilder.append("\n");
                stringBuilder.append("-----------------------------------\n");
                Message productMessage = genericManager.getContainer().get(key).get(productId);
                    stringBuilder.append("\"");
                    stringBuilder.append(productMessage.getMessage());
                    stringBuilder.append("\"");
                    stringBuilder.append("\n");
                    stringBuilder.append("-----------------------------------");
                    stringBuilder.append("\n");
                }
            }
            return String.valueOf(stringBuilder);
    }
}
