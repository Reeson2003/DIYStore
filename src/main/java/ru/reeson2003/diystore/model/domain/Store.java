package ru.reeson2003.diystore.model.domain;

import java.util.List;

/**
 * Date: 15.04.17.
 * @author Pavel Gavrilov
 */
public class Store {
    private List<Product> products;
    private List<Message> messages;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
