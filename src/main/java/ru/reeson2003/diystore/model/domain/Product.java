package ru.reeson2003.diystore.model.domain;


/**
 * Date: 15.04.17.
 * @author Pavel Gavrilov
 */
public class Product {
    private long id;
    private String description;
    private long price;

    public long getId() {
        return id;
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
}
