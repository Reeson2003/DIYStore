package ru.reeson2003.diystore.model.domain;

/**
 * Date: 15.04.17.
 * @author Pavel Gavrilov
 */
public class Artisan {
    private long id;
    private String storeName;
    private String email;
    private String password;
    private Store store;

    public Artisan() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
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

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
