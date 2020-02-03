package com.dev.cinema.service;

import java.util.List;

import com.dev.cinema.exceptions.DataProcessingExeption;
import com.dev.cinema.model.Movie;

public interface MovieService {
      Movie add(Movie movie) throws DataProcessingExeption;
    
      List<Movie> getAll() throws DataProcessingExeption;
}