package ru.reeson2003.diystore.model.service;

import ru.reeson2003.diystore.model.domain.Message;

/**
 * Date: 18.04.2017.
 * Time: 23:15.
 *
 * @author Pavel Gavrilov.
 */

public interface MessageManager{
    void add(Message message);

    void update(Message message);

    void remove(Message message);

    void remove(Long id);

    Message getById(Long id);
}
