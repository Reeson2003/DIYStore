package ru.reeson2003.diystore.model.dao.spring_jpa_dao;

import org.springframework.beans.factory.annotation.Autowired;
import ru.reeson2003.diystore.model.dao.ArtisanDao;
import ru.reeson2003.diystore.model.domain.Artisan;
import ru.reeson2003.diystore.model.domain.ArtisanParams;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Date: 13.05.2017.
 * Time: 9:10.
 *
 * @author Pavel Gavrilov.
 */
public class ArtisanJpaDao implements ArtisanDao {
    private ArtisanJpaRepository artisanJpaRepository;
    private ArtisanParamsJpaRepository artisanParamsJpaRepository;

    @Override
    public void add(Artisan artisan) {
        artisanJpaRepository.save(artisan);
    }

    @Override
    public void update(Artisan artisan) {
        artisanJpaRepository.save(artisan);
    }

    @Override
    public void remove(Artisan artisan) {
        artisanJpaRepository.delete(artisan);
    }

    @Override
    public void remove(Long id) {
        artisanJpaRepository.delete(id);
    }

    @Override
    public List<Artisan> getAll() {
        return artisanJpaRepository.findAll();
    }

    @Override
    public Artisan getById(Long id) {
        return artisanJpaRepository.findOne(id);
    }

    @Override
    public Artisan getByUserName(String userName) {
        return artisanJpaRepository.findByUserName(userName);
    }

    @Override
    public List<Artisan> getAllByFirstName(String firstName) {
        List<ArtisanParams> params = artisanParamsJpaRepository.findAllByFirstName(firstName);
        List<Artisan> result = new ArrayList<>();
        for (ArtisanParams p: params)
            result.add(p.getArtisan());
        return result;
    }

    @Override
    public List<Artisan> getAllByLastName(String lastName) {
        List<ArtisanParams> params = artisanParamsJpaRepository.findAllByLastName(lastName);
        List<Artisan> result = new ArrayList<>();
        for (ArtisanParams p: params)
            result.add(p.getArtisan());
        return result;
    }

    @Override
    public List<Artisan> getAllByBirthDate(Date date) {
        List<ArtisanParams> params = artisanParamsJpaRepository.findAllByBirthDate(date);
        List<Artisan> result = new ArrayList<>();
        for (ArtisanParams p: params)
            result.add(p.getArtisan());
        return result;
    }

    public ArtisanJpaRepository getArtisanJpaRepository() {
        return artisanJpaRepository;
    }

    @Autowired
    public void setArtisanJpaRepository(ArtisanJpaRepository artisanJpaRepository) {
        this.artisanJpaRepository = artisanJpaRepository;
    }

    public ArtisanParamsJpaRepository getArtisanParamsJpaRepository() {
        return artisanParamsJpaRepository;
    }

    @Autowired
    public void setArtisanParamsJpaRepository(ArtisanParamsJpaRepository artisanParamsJpaRepository) {
        this.artisanParamsJpaRepository = artisanParamsJpaRepository;
    }
}
