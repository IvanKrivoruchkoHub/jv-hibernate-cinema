package com.dev.cinema.dao;

import java.util.List;

import com.dev.cinema.exceptions.DataProcessingExeption;
import com.dev.cinema.model.Movie;

public interface MovieDao {
    Movie add(Movie movie) throws DataProcessingExeption;

    List<Movie> getAll() throws DataProcessingExeption;
}