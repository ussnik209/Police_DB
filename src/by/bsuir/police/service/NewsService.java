package by.bsuir.police.service;

import by.bsuir.police.entity.News;
import by.bsuir.police.exception.ServiceException;

import javax.servlet.http.Part;
import java.sql.Date;

/**
 * The interface News service.
 */
public interface NewsService extends CommonService<News> {
    /**
     * Add news.
     *
     * @param topic       the topic
     * @param information the information
     * @param country     the country
     * @param time        the time
     * @param imagePart   the image part
     * @throws ServiceException the service exception
     */
    void addNews(String topic, String information, String country, Date time, Part imagePart) throws ServiceException;

}
