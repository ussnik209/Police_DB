package by.bsuir.police.service.impl;

import by.bsuir.police.dao.impl.PersonDaoImpl;
import by.bsuir.police.entity.Person;
import by.bsuir.police.exception.DaoException;
import by.bsuir.police.exception.ServiceException;
import by.bsuir.police.service.PersonService;


import java.sql.Blob;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Optional;

/**
 * The type Person service.
 */
public class PersonServiceImpl implements PersonService {

    private PersonDaoImpl personDao = new PersonDaoImpl();

    @Override
    public void addPerson(String name, String lastName, Date birth, int weight, int height, String hair, String nationality,
                          String sex, String characteristics, int status, Blob imagePart) throws ServiceException {
        try {
            personDao.addPerson(name, lastName, birth, weight, height, hair, nationality, sex, characteristics, status, imagePart);
        } catch (DaoException e) {
            throw new ServiceException("Add document is failed", e);
        }

    }

    @Override
    public Optional<Person> searchById(int id) {
        return personDao.searchById(id);
    }

    @Override
    public void remove(int id) throws ServiceException {
        try {
            personDao.remove(id);
        } catch (DaoException e) {
            throw new ServiceException("Delete Person is failed");
        }
    }

    @Override
    public ArrayList<Person> showAll() {
        return personDao.showAll();
    }
}
