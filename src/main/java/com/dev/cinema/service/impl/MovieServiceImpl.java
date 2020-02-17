package com.dev.cinema.service.impl;

import com.dev.cinema.dao.MovieDao;
import com.dev.cinema.exceptions.DataProcessingExeption;
import com.dev.cinema.model.Movie;
import com.dev.cinema.service.MovieService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
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
