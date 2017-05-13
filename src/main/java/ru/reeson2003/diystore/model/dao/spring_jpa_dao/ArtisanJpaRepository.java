package ru.reeson2003.diystore.model.dao.spring_jpa_dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.reeson2003.diystore.model.domain.Artisan;

/**
 * Date: 13.05.2017.
 * Time: 10:57.
 *
 * @author Pavel Gavrilov.
 */
@Repository
public interface ArtisanJpaRepository extends JpaRepository<Artisan, Long>{
    Artisan findByUserName(String userName);
}
