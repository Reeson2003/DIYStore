package ru.reeson2003.diystore.model.dao.spring_jpa_dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.reeson2003.diystore.model.domain.Message;

/**
 * Date: 13.05.2017.
 * Time: 11:45.
 *
 * @author Pavel Gavrilov.
 */
@Repository
public interface MessageJpaRepository extends CrudRepository<Message, Long> {
}
