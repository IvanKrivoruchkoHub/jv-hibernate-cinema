package com.dev.cinema.service.impl;

import java.time.LocalDate;
import java.util.List;

import com.dev.cinema.dao.MovieSessionDao;
import com.dev.cinema.lib.anotations.Inject;
import com.dev.cinema.lib.anotations.Service;
import com.dev.cinema.model.MovieSession;
import com.dev.cinema.service.MovieSessionService;

@Service
public class MovieSessionServiceImpl implements MovieSessionService {
    @Inject
    private MovieSessionDao movieSessionDao;

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        return movieSessionDao.findAvailableSessions(movieId, date);
    }

    @Override
    public MovieSession add(MovieSession movieSession) {
        return movieSessionDao.add(movieSession);
    }
}