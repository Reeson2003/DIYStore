package ru.reeson2003.diystore.model.domain;


import ru.reeson2003.diystore.model.service.in_memory_manager.IdOwner;

/**
 * Date: 15.04.17.
 * @author Pavel Gavrilov
 */
public class Product implements IdOwner{
    private Long id;
    private String description;
    private Long price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
