package com.dev.cinema.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import com.dev.cinema.dao.CinemaHallDao;
import com.dev.cinema.exceptions.DataProcessingExeption;
import com.dev.cinema.lib.anotations.Dao;
import com.dev.cinema.model.CinemaHall;
import com.dev.cinema.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class CinemaHallDaoImpl implements CinemaHallDao {

    @Override
    public CinemaHall add(CinemaHall cinemaHall) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Long cinemaHallId = (Long) session.save(cinemaHall);
            transaction.commit();
            cinemaHall.setId(cinemaHallId);
            return cinemaHall;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingExeption("Can't insert cinema hall entity", e);
        }
    }

    @Override
    public List<CinemaHall> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaQuery<CinemaHall> criteriaQuery = session.getCriteriaBuilder()
                    .createQuery(CinemaHall.class);
            criteriaQuery.from(CinemaHall.class);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new DataProcessingExeption("Error retrieving all cinema halls", e);
        }
    }
}