package ru.reeson2003.diystore.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.reeson2003.diystore.model.dao.ArtisanDao;
import ru.reeson2003.diystore.model.domain.Artisan;

import java.util.Date;
import java.util.List;

/**
 * Date: 13.05.2017.
 * Time: 10:49.
 *
 * @author Pavel Gavrilov.
 */
public class ArtisanManagerImpl implements ArtisanManager {
    private ArtisanDao artisanDao;

    @Override
    public void add(Artisan artisan) {
        artisanDao.add(artisan);
    }

    @Override
    public void update(Artisan artisan) {
        artisanDao.update(artisan);
    }

    @Override
    public void remove(Artisan artisan) {
        artisanDao.remove(artisan);
    }

    @Override
    public void remove(Long id) {
        artisanDao.remove(id);
    }

    @Override
    public List<Artisan> getAll() {
        return artisanDao.getAll();
    }

    @Override
    public Artisan getById(Long id) {
        return artisanDao.getById(id);
    }

    @Override
    public Artisan getByUserName(String userName) {
        return artisanDao.getByUserName(userName);
    }

    @Override
    public List<Artisan> getAllByFirstName(String firstName) {
        return artisanDao.getAllByFirstName(firstName);
    }

    @Override
    public List<Artisan> getAllByLastName(String lastName) {
        return artisanDao.getAllByLastName(lastName);
    }

    @Override
    public List<Artisan> getAllByBirthDate(Date date) {
        return artisanDao.getAllByBirthDate(date);
    }

    public ArtisanDao getArtisanDao() {
        return artisanDao;
    }

    @Autowired
    public void setArtisanDao(ArtisanDao artisanDao) {
        this.artisanDao = artisanDao;
    }
}
