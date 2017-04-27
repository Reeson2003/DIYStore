package ru.reeson2003.diystore.model.domain;


/**
 * Date: 15.04.17.
 * @author Pavel Gavrilov
 */
public class Message{
    private Long id;
    private String message;
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", product=" + product +
                '}';
    }
}
