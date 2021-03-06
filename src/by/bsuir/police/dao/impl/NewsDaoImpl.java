package by.bsuir.police.dao.impl;

import by.bsuir.police.dao.NewsDao;
import by.bsuir.police.pool.PoolConnection;
import by.bsuir.police.entity.News;

import by.bsuir.police.exception.DaoException;
import by.bsuir.police.util.NewsBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

/**
 * The type News dao.
 */
public class NewsDaoImpl implements NewsDao {

    private static Logger LOGGER = LogManager.getLogger(NewsDaoImpl.class);
    private static final String SEARCH_NEWS_BY_ID = "SELECT * FROM news WHERE news_id = ?";
    private static final String SEARCH_NEWS_BY_INF = "SELECT * FROM news WHERE  information= ?  ";
    private static final String INSERT_NEW_COMMON = "INSERT INTO news values(null,?,?,?,? + INTERVAL 1 DAY,?)";
    private static final String SELECT_NEW_ALL = "SELECT * FROM news";
    private static final String REMOVE_DOC_DATA = "DELETE FROM news  WHERE news_id = ?";


    @Override
    public Optional<News> searchById(int id) {

        try (Connection connection = PoolConnection.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_NEWS_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            News news = null;
            if (resultSet.next()) {
                news = NewsBuilder.createNews(resultSet);
            }
            return Optional.of(news);
        } catch (SQLException e) {
            return Optional.empty();
        }
    }

    @Override
    public void addNews(String topic, String information, String country, Date date, InputStream image) throws DaoException {
        try (Connection connection = PoolConnection.getInstance().getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_NEWS_BY_INF);
            preparedStatement.setString(1, information);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                throw new DaoException("News already exist");
            } else {
                PreparedStatement statement = connection.prepareStatement(INSERT_NEW_COMMON);
                statement.setString(1, topic);
                statement.setString(2, information);
                statement.setString(3, country);
                statement.setDate(4, date);
                statement.setBlob(5, image);

                statement.executeUpdate();
                LOGGER.info("News correctly added");

            }
        } catch (SQLException e) {
            throw new DaoException("News not added", e);
        }

    }

    @Override
    public void remove(int id) throws DaoException {
        try (Connection connection = PoolConnection.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_DOC_DATA);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public ArrayList<News> showAll() {

        try (Connection connection = PoolConnection.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_NEW_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<News> news = NewsBuilder.createNewsAll(resultSet);
            return news;
        } catch (SQLException e) {
            return new ArrayList<>();
        }
    }

}
