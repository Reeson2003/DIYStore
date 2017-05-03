package ru.reeson2003.diystore.model.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Date: 15.04.17.
 *
 * @author Pavel Gavrilov
 */
@Entity
@Table(name = "artisan")
@Access(AccessType.FIELD)
public class Artisan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "arti_product",
            joinColumns = @JoinColumn(name = "arti_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "arti_message",
            joinColumns = @JoinColumn(name = "arti_id"),
            inverseJoinColumns = @JoinColumn(name = "message_id")
    )
    private List<Message> messages;

    public Artisan() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Artisan artisan = (Artisan) o;

        if (id != null ? !id.equals(artisan.id) : artisan.id != null) return false;
        if (name != null ? !name.equals(artisan.name) : artisan.name != null) return false;
        if (email != null ? !email.equals(artisan.email) : artisan.email != null) return false;
        if (password != null ? !password.equals(artisan.password) : artisan.password != null) return false;
        if (products != null ? !productsEquals(artisan) : artisan.products != null) return false;
        return messages != null ? messagesEquals(artisan) : artisan.messages == null;
    }

    private boolean productsEquals(Artisan artisan) {
        if (products.size() != artisan.products.size()) return false;
        for (int i = 0; i < products.size(); i++) {
            if (!products.get(i).equals(artisan.products.get(i))) return false;
        }
        return true;
    }

    private boolean messagesEquals(Artisan artisan) {
        if (messages.size() != artisan.messages.size()) return false;
        for (int i = 0; i < messages.size(); i++) {
            if(!messages.get(i).equals(artisan.messages.get(i))) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (products != null ? products.hashCode() : 0);
        result = 31 * result + (messages != null ? messages.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Artisan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
