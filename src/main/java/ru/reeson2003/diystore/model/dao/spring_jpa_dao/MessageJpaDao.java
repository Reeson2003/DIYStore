package ru.reeson2003.diystore.model.dao.spring_jpa_dao;

import org.springframework.beans.factory.annotation.Autowired;
import ru.reeson2003.diystore.model.dao.MessageDao;
import ru.reeson2003.diystore.model.domain.Message;

/**
 * Date: 13.05.2017.
 * Time: 11:38.
 *
 * @author Pavel Gavrilov.
 */
public class MessageJpaDao implements MessageDao{
    private MessageJpaRepository messageJpaRepository;

    @Override
    public void add(Message message) {
        messageJpaRepository.save(message);
    }

    @Override
    public void update(Message message) {
        messageJpaRepository.save(message);
    }

    @Override
    public void remove(Message message) {
        messageJpaRepository.delete(message);
    }

    @Override
    public void remove(Long id) {
        messageJpaRepository.delete(id);
    }

    @Override
    public Message getById(Long id) {
        return messageJpaRepository.findOne(id);
    }

    public MessageJpaRepository getMessageJpaRepository() {
        return messageJpaRepository;
    }

    @Autowired
    public void setMessageJpaRepository(MessageJpaRepository messageJpaRepository) {
        this.messageJpaRepository = messageJpaRepository;
    }
}
