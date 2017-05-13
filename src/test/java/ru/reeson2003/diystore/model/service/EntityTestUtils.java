package ru.reeson2003.diystore.model.service;

import ru.reeson2003.diystore.model.domain.Artisan;
import ru.reeson2003.diystore.model.domain.Message;
import ru.reeson2003.diystore.model.domain.Product;

/**
 * Date: 03.05.2017.
 * Time: 21:53.
 *
 * @author Pavel Gavrilov.
 */
public class EntityTestUtils {
    public static Message getMessage(String msg) {
        Message message = new Message();
        message.setMessage(msg);
        return message;
    }

    public static Product getProduct(String desc, Long price) {
        Product product = new Product();
        product.setDescription(desc);
        product.setPrice(price);
        return product;
    }

    public static Artisan getArti(String name, String email, String pass) {
        Artisan artisan = new Artisan();
        artisan.setUserName(name);
        artisan.setEmail(email);
        artisan.setPassword(pass);
        return artisan;
    }
}
