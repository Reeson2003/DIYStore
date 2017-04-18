package ru.reeson2003.diystore.model.service.in_memory_manager;

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
    private AtomicLong idCreator;

    GenericManager() {
        container = new ConcurrentHashMap<Long, Map<Long, T>>();
        idCreator = new AtomicLong(0);
    }

    List<T> getItems(Long id) {
        return new ArrayList<T>(container.get(id).values());
    }

    T getItem(Long id) {
        for (Map.Entry<Long, Map<Long, T>> pair: container.entrySet()) {
            if (pair.getValue().containsKey(id))
                return pair.getValue().get(id);
        }
        return null;
    }

    void setItem(Long id, T item) {
        if (item.getId() == null) {
            item.setId(idCreator.getAndIncrement());
        }
        if (!container.containsKey(id))
            container.put(id, new HashMap<Long, T>());
        container.get(id).put(item.getId(), item);
    }

    void deleteItem(Long id) {
        for (Map.Entry<Long, Map<Long, T>> pair: container.entrySet()) {
            if (pair.getValue().containsKey(id))
                pair.getValue().remove(id);
        }
    }
}
