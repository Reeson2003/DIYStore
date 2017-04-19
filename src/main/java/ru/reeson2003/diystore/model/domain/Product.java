package ru.reeson2003.diystore.model.domain;


import ru.reeson2003.diystore.model.service.in_memory_manager.IdOwner;

/**
 * Date: 15.04.17.
 * @author Pavel Gavrilov
 */
public class Product implements IdOwner {
    private Long id;
    private String name;
    private String description;
    private Long price;

    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Product ID ");
        stringBuilder.append(id);
        stringBuilder.append(" Name ");
        stringBuilder.append(name);
        return String.valueOf(stringBuilder);
    }
}
