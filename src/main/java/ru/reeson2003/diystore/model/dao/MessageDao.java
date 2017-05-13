package ru.reeson2003.diystore.model.dao;


import ru.reeson2003.diystore.model.domain.Message;

/**
 * Date: 13.05.2017.
 * Time: 9:07.
 *
 * @author Pavel Gavrilov.
 */
public interface MessageDao {
    void add(Message message);

    void update(Message message);

    void remove(Message message);

    void remove(Long id);

    Message getById(Long id);
}
