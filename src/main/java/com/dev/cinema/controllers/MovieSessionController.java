package com.dev.cinema.controllers;

import com.dev.cinema.dto.MovieSessionDto;
import com.dev.cinema.model.MovieSession;
import com.dev.cinema.service.CinemaHallService;
import com.dev.cinema.service.MovieService;
import com.dev.cinema.service.MovieSessionService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/moviesessions")
public class MovieSessionController {
    @Autowired
    private MovieSessionService movieSessionService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private CinemaHallService cinemaHallService;

    @PostMapping
    public void addMovieSession(@RequestBody MovieSessionDto movieSessionDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.getById(movieSessionDto.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService.getById(movieSessionDto.getCinemaHallId()));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        movieSession.setShowTime(LocalDateTime.parse(movieSessionDto.getShowTime(), formatter));
        movieSessionService.add(movieSession);
    }

    @GetMapping(value = "/available")
    public List<MovieSessionDto> getAvailableMovieSession(
            @RequestParam Long movieId, @RequestParam String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return movieSessionService.findAvailableSessions(movieId, LocalDate.parse(date, formatter))
                .stream()
                .map(this::toMovieSessionDto)
                .collect(Collectors.toList());
    }

    private MovieSessionDto toMovieSessionDto(
            MovieSession movieSession) {
        MovieSessionDto movieSessionDto = new MovieSessionDto();
        movieSessionDto.setShowTime(movieSession.getShowTime().toString());
        movieSessionDto.setMovieId(movieSession.getMovie().getId());
        movieSessionDto.setCinemaHallId(movieSession.getCinemaHall().getId());
        return movieSessionDto;
    }
}
