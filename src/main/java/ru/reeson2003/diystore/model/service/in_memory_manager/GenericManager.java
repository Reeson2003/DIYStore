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
    private static AtomicLong idCreator;

    GenericManager() {
        container = new ConcurrentHashMap<>();
        idCreator = new AtomicLong(0);
    }

    List<T> getItems(Long id) {
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

    void deleteItem(Long id) {
        for (Map<Long, T> pair: container.values()) {
            if (pair.containsKey(id))
                pair.remove(id);
        }
    }

    public Map<Long, Map<Long, T>> getContainer() {
        return container;
    }

    public void setContainer(Map<Long, Map<Long, T>> container) {
        this.container = container;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int totalOfProducts = 0;
        int totalOfArtisan = 0;
        for (Long key : container.keySet()) {
            stringBuilder.append("Artisan ID ");
            stringBuilder.append("<");
            stringBuilder.append(key);
            stringBuilder.append(">");
            stringBuilder.append("\n");
            totalOfArtisan++;
            int countProduct = 0;
            for (Long productId : container.get(key).keySet()) {
                countProduct++;
                stringBuilder.append("    Name product - ");
                stringBuilder.append(((Product)container.get(key).get(productId)).getName());
                stringBuilder.append("\n");
                stringBuilder.append("    ID product - ");
                stringBuilder.append(productId);
                stringBuilder.append("\n");
                stringBuilder.append("    --------------------\n");
            }
            stringBuilder.append("Count product [");
            stringBuilder.append(countProduct);
            stringBuilder.append("]");
            stringBuilder.append(" Artisan - ");
            stringBuilder.append(key);
            stringBuilder.append("\n");
            totalOfProducts += countProduct;
        }
        stringBuilder.append("\n\n");
        stringBuilder.append(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        stringBuilder.append("\n");
        stringBuilder.append("Total Of Artisan - ");
        stringBuilder.append(totalOfArtisan);
        stringBuilder.append("\n");
        stringBuilder.append("Total Of Products - ");
        stringBuilder.append(totalOfProducts);
        stringBuilder.append("\n");
        stringBuilder.append("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        return String.valueOf(stringBuilder);
    }
}
