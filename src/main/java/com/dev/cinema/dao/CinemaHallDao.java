package com.dev.cinema.dao;

import java.util.List;

import com.dev.cinema.model.CinemaHall;

public interface CinemaHallDao {
    CinemaHall add(CinemaHall cinemaHall);

    List<CinemaHall> getAll();
}
