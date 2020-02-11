package com.dev.cinema;

import com.dev.cinema.exceptions.AuthenticationException;
import com.dev.cinema.lib.Injector;
import com.dev.cinema.model.CinemaHall;
import com.dev.cinema.model.Movie;
import com.dev.cinema.model.MovieSession;
import com.dev.cinema.model.ShoppingCart;
import com.dev.cinema.service.AuthenticationService;
import com.dev.cinema.service.CinemaHallService;
import com.dev.cinema.service.MovieService;
import com.dev.cinema.service.MovieSessionService;
import com.dev.cinema.service.OrderService;
import com.dev.cinema.service.ShoppingCartService;
import com.dev.cinema.service.UserService;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.apache.log4j.Logger;

public class Main {
    private static Injector injector = Injector.getInstance("com.dev.cinema");

    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) throws AuthenticationException {
        LOGGER.info("Start testing MovieService");
        MovieService movieService = (MovieService) injector.getInstance(MovieService.class);
        movieService.getAll().forEach(System.out::println);
        Movie movie = new Movie();
        movie.setTitle("Fast and Furious");
        movieService.add(movie);
        movieService.getAll().forEach(System.out::println);

        LOGGER.info("Start testing CinemaHallService");
        CinemaHallService cinemaHallService
                = (CinemaHallService) injector.getInstance(CinemaHallService.class);
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(100);
        cinemaHallService.add(cinemaHall);
        cinemaHallService.getAll().forEach(System.out::println);

        LOGGER.info("Start testing MovieSessionService");
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movie);
        movieSession.setCinemaHall(cinemaHall);
        movieSession.setShowTime(LocalDateTime.of(2020, 2, 26, 12, 30));
        MovieSessionService movieSessionService
                = (MovieSessionService) injector.getInstance(MovieSessionService.class);
        movieSessionService.add(movieSession);
        movieSessionService.findAvailableSessions(movie.getId(),
                LocalDate.of(2020, 2, 26)).forEach(System.out::println);

        LOGGER.info("Start testing AuthenticationService");
        AuthenticationService authenticationService
                = (AuthenticationService) injector.getInstance(AuthenticationService.class);
        System.out.println(authenticationService.register("parker@gmail.com", "parker"));
        System.out.println(authenticationService.login("parker@gmail.com", "parker"));

        LOGGER.info("Start testing ShoppingCartService");
        ShoppingCartService shoppingCartService
                = (ShoppingCartService) injector.getInstance(ShoppingCartService.class);
        UserService userService = (UserService) injector.getInstance(UserService.class);

        shoppingCartService.addSession(movieSession, userService.findByEmail("parker@gmail.com"));
        ShoppingCart shoppingCart
                = shoppingCartService.getByUser(userService.findByEmail("parker@gmail.com"));

        LOGGER.info("Start testing OrderService");
        OrderService orderService = (OrderService) injector.getInstance(OrderService.class);
        orderService.completeOrder(shoppingCart);
        orderService.getOrderHistory(userService.findByEmail("parker@gmail.com"));
    }
}
