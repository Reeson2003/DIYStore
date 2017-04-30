package ru.reeson2003.diystore.model.domain;


import javax.persistence.*;

/**
 * Date: 15.04.17.
 * @author Pavel Gavrilov
 */
@Entity
@Table(name = "message")
public class Message{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "message")
    private String message;
    @OneToOne(cascade = CascadeType.ALL)
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
