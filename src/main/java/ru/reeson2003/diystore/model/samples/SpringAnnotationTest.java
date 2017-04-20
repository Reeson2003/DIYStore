package ru.reeson2003.diystore.model.samples;

import org.springframework.beans.factory.annotation.Autowired;
import ru.reeson2003.diystore.model.samples.SpringTestXmlConfig;
import ru.reeson2003.diystore.model.service.MessageManager;
import ru.reeson2003.diystore.model.service.ProductManager;

/**
 * Date: 20.04.2017.
 * Time: 21:18.
 *
 * @author Pavel Gavrilov.
 */
public class SpringAnnotationTest extends SpringTestXmlConfig {

    @Autowired
    @Override
    public void setProductManager(ProductManager productManager) {
        super.setProductManager(productManager);
    }

    @Autowired
    @Override
    public void setMessageManager(MessageManager messageManager) {
        super.setMessageManager(messageManager);
    }
}
