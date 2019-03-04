package by.bsuir.police.service.impl;

import by.bsuir.police.dao.impl.NewsDaoImpl;
import by.bsuir.police.entity.News;
import by.bsuir.police.exception.DaoException;
import by.bsuir.police.exception.ServiceException;
import by.bsuir.police.service.NewsService;

import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;

/**
 * The type News service.
 */
public class NewsServiceImpl implements NewsService {

    private NewsDaoImpl newsDao = new NewsDaoImpl();

    @Override
    public Optional<News> searchById(int id) {
        return newsDao.searchById(id);
    }

    @Override
    public void remove(int id) throws ServiceException {
        try {
            newsDao.remove(id);
        } catch (DaoException e) {
            throw new ServiceException("Delete news is failed", e);
        }
    }

    @Override
    public ArrayList<News> showAll() {
        return newsDao.showAll();
    }

    @Override
    public void addNews(String topic, String information, String country, Date time, Part imagePart) throws ServiceException {
        try {
            InputStream inputStream = imagePart.getInputStream();
            newsDao.addNews(topic, information, country, time, inputStream);
        } catch (DaoException | IOException e) {
            throw new ServiceException("Add news is failed", e);
        }

    }
}
