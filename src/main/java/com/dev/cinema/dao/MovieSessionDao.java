package com.dev.cinema.dao;

import java.time.LocalDate;
import java.util.List;

import com.dev.cinema.model.MovieSession;

public interface MovieSessionDao {
    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);

    MovieSession add(MovieSession movieSession);
}
