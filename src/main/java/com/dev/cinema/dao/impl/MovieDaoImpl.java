package com.dev.cinema.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import com.dev.cinema.dao.MovieDao;
import com.dev.cinema.exceptions.DataProcessingExeption;
import com.dev.cinema.lib.anotations.Dao;
import com.dev.cinema.model.Movie;
import com.dev.cinema.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class MovieDaoImpl implements MovieDao {
    @Override
    public Movie add(Movie movie) throws DataProcessingExeption {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Long movieId = (Long) session.save(movie);
            transaction.commit();
            movie.setId(movieId);
            return movie;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingExeption("Can't insert movie entity", e);
        }
    }

    @Override
    public List<Movie> getAll() throws DataProcessingExeption {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaQuery<Movie> criteriaQuery = session.getCriteriaBuilder()
                    .createQuery(Movie.class);
            criteriaQuery.from(Movie.class);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new DataProcessingExeption("Error retrieving all movies", e);
        }
    }
}
