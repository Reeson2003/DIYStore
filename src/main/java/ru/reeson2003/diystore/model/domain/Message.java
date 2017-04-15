package ru.reeson2003.diystore.model.domain;

/**
 * Date: 15.04.17.
 * @author Pavel Gavrilov
 */
public class Message {
    private String message;
    private Product product;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
