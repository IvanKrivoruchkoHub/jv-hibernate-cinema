package com.dev.cinema.service.impl;

import java.util.List;

import com.dev.cinema.dao.MovieDao;
import com.dev.cinema.exceptions.DataProcessingExeption;
import com.dev.cinema.lib.anotations.Inject;
import com.dev.cinema.lib.anotations.Service;
import com.dev.cinema.model.Movie;
import com.dev.cinema.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
    @Inject
    private MovieDao movieDao;

    @Override
    public Movie add(Movie movie) throws DataProcessingExeption {
        return movieDao.add(movie);
    }

    @Override
    public List<Movie> getAll() throws DataProcessingExeption {
        return movieDao.getAll();
    }
}
