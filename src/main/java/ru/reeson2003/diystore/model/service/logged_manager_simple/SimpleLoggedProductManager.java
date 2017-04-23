package ru.reeson2003.diystore.model.service.logged_manager_simple;

import ru.reeson2003.diystore.model.domain.Product;
import ru.reeson2003.diystore.model.service.DataStorageException;
import ru.reeson2003.diystore.model.service.ProductManager;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Date: 23.04.17.
 *
 * @author Pavel Gavrilov.
 */
public class SimpleLoggedProductManager implements ProductManager {
    private ProductManager manager;
    private PrintStream stream;

    public SimpleLoggedProductManager(ProductManager manager, OutputStream os) {
        this.manager = manager;
        this.stream = new PrintStream(os);
    }

    @Override
    public List<Product> getProducts(Long artisanId) throws DataStorageException {
        print("Artisan ID: " +
                artisanId.toString() +
                " gets product list");
        return manager.getProducts(artisanId);
    }

    @Override
    public Product getProduct(Long productId) throws DataStorageException {
        print("Gets product ID: " + productId.toString());
        return manager.getProduct(productId);
    }

    @Override
    public void setProduct(Long artisanId, Product product) throws DataStorageException {
        print("Artisan ID: " +
                artisanId.toString() +
                " sets " +
                (product.getId() == null ? "new product" : ("product with ID: " + product.getId().toString())));
        manager.setProduct(artisanId, product);
    }

    @Override
    public void deleteProduct(Long productId) throws DataStorageException {
        print("remove product with ID: " + productId.toString());
    }

    private void print(String info) {
        String prefix = "[Simple Logger] >>> ";
        Calendar c = new GregorianCalendar();
        String date = c.getTime().toString();
        stream.println(prefix + date + ": " + info);
    }
}
