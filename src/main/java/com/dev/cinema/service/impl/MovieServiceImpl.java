package com.dev.cinema.service.impl;

import com.dev.cinema.dao.MovieDao;
import com.dev.cinema.exceptions.DataProcessingExeption;
import com.dev.cinema.lib.anotations.Inject;
import com.dev.cinema.lib.anotations.Service;
import com.dev.cinema.model.Movie;
import com.dev.cinema.service.MovieService;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Inject
    private MovieDao movieDao;

    @Override
    public Movie add(Movie movie) {
        try {
            return movieDao.add(movie);
        } catch (DataProcessingExeption dataProcessingExeption) {
            throw new RuntimeException(dataProcessingExeption);
        }
    }

    @Override
    public List<Movie> getAll() {
        try {
            return movieDao.getAll();
        } catch (DataProcessingExeption dataProcessingExeption) {
            throw new RuntimeException(dataProcessingExeption);
        }
    }
}
