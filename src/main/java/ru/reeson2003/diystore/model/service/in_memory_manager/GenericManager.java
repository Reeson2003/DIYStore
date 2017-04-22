package ru.reeson2003.diystore.model.service.in_memory_manager;

import ru.reeson2003.diystore.model.service.DataStorageException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Date: 18.04.2017.
 * Time: 23:19.
 *
 * @author Pavel Gavrilov.
 */
class GenericManager<T extends IdOwner> {
    private Map<Long, Map<Long, T>> container;
    private static AtomicLong idCreator;

    GenericManager() {
        container = new ConcurrentHashMap<>();
        idCreator = new AtomicLong(0);
    }

    List<T> getItems(Long id) throws DataStorageException {
        if (container.isEmpty())
            throw new DataStorageException(new Throwable("Empty container"));
        if (container.get(id).isEmpty())
            throw new DataStorageException(new Throwable("Empty list of " +id +" id"));
        return new ArrayList<>(container.get(id).values());
    }

    T getItem(Long id) {
        for (Map<Long, T> pair: container.values()) {
            if (pair.containsKey(id))
                return pair.get(id);
        }
        return null;
    }

    void setItem(Long id, T item) {
        if (item.getId() == null) {
            item.setId(idCreator.getAndIncrement());
        }
        if (!container.containsKey(id))
            container.put(id, new HashMap<>());
        container.get(id).put(item.getId(), item);
    }

    void deleteItem(Long id) throws DataStorageException {
        for (Map<Long, T> pair: container.values()) {
            if (pair.containsKey(id)) {
                pair.remove(id);
                return;
            }
        }
        throw new DataStorageException(new Throwable());
    }

    public Map<Long, Map<Long, T>> getContainer() {
        return container;
    }
}
