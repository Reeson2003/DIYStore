package ru.reeson2003.diystore.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.reeson2003.diystore.model.dao.MessageDao;
import ru.reeson2003.diystore.model.domain.Message;

/**
 * Date: 13.05.2017.
 * Time: 11:50.
 *
 * @author Pavel Gavrilov.
 */
public class MessageManagerImpl implements MessageManager{
    private MessageDao messageDao;

    @Override
    public void add(Message message) {
        messageDao.add(message);
    }

    @Override
    public void update(Message message) {
        messageDao.update(message);
    }

    @Override
    public void remove(Message message) {
        messageDao.remove(message);
    }

    @Override
    public void remove(Long id) {
        messageDao.remove(id);
    }

    @Override
    public Message getById(Long id) {
        return messageDao.getById(id);
    }

    public MessageDao getMessageDao() {
        return messageDao;
    }

    @Autowired
    public void setMessageDao(MessageDao messageDao) {
        this.messageDao = messageDao;
    }
}
