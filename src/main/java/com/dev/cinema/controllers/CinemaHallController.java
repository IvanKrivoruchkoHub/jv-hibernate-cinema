package com.dev.cinema.controllers;

import com.dev.cinema.dto.CinemaHallDto;
import com.dev.cinema.model.CinemaHall;
import com.dev.cinema.service.CinemaHallService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "cinemahalls")
public class CinemaHallController {
    @Autowired
    private CinemaHallService cinemaHallService;

    @PostMapping
    public void addMovie(@RequestBody CinemaHallDto cinemaHallDto) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(cinemaHallDto.getCapacity());
        cinemaHall.setDescription(cinemaHallDto.getDescription());
        cinemaHallService.add(cinemaHall);
    }

    @GetMapping
    public List<CinemaHallDto> getAllCinemaHalls() {
        return cinemaHallService.getAll()
                .stream()
                .map(this::transformCinemaHallToCinemaHallDto)
                .collect(Collectors.toList());
    }

    private CinemaHallDto transformCinemaHallToCinemaHallDto(CinemaHall cinemaHall) {
        CinemaHallDto cinemaHallDto = new CinemaHallDto();
        cinemaHallDto.setCapacity(cinemaHall.getCapacity());
        cinemaHallDto.setDescription(cinemaHall.getDescription());
        return cinemaHallDto;
    }
}
