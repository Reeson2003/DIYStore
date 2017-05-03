package ru.reeson2003.diystore.model.Examples;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Date: 30.04.2017.
 * Time: 21:50.
 *
 * @author Pavel Gavrilov.
 */
public class DBCreate {
    public static void main(String[] args) {
        SessionFactory factory = null;
        factory = new Configuration().configure().buildSessionFactory();
        factory.close();
    }
}
