package ru.reeson2003.diystore.model.dao.spring_jpa_dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.reeson2003.diystore.model.domain.ArtisanParams;

import java.util.Date;
import java.util.List;

/**
 * Date: 13.05.2017.
 * Time: 11:08.
 *
 * @author Pavel Gavrilov.
 */
@Repository
public interface ArtisanParamsJpaRepository extends JpaRepository<ArtisanParams, Long> {
    List<ArtisanParams> findAllByFirstName(String firstName);

    List<ArtisanParams> findAllByLastName(String lastName);

    List<ArtisanParams> findAllByBirthDate(Date birthDate);
}
