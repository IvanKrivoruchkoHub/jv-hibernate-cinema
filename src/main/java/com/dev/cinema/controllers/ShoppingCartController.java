package com.dev.cinema.controllers;

import com.dev.cinema.dto.ShoppingCartRequestDto;
import com.dev.cinema.dto.ShoppingCartResponseDto;
import com.dev.cinema.dto.TicketDto;
import com.dev.cinema.model.ShoppingCart;
import com.dev.cinema.model.Ticket;
import com.dev.cinema.service.MovieSessionService;
import com.dev.cinema.service.ShoppingCartService;
import com.dev.cinema.service.UserService;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/shoppingcarts")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private MovieSessionService movieSessionService;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/addmoviesession")
    public void addMovieSessionToShoppingCart(
            @RequestBody ShoppingCartRequestDto shoppingCartRequestDto,
            Authentication authentication) {
        shoppingCartService.addSession(
                movieSessionService.getById(shoppingCartRequestDto.getMovieSessionId()),
                userService.findByEmail(authentication.getName()));
    }

    @GetMapping(value = "/byuser")
    public ShoppingCartResponseDto getById(Authentication authentication) {
        ShoppingCart shoppingCart = shoppingCartService
                .getByUser(userService.findByEmail(authentication.getName()));
        ShoppingCartResponseDto responseDto = new ShoppingCartResponseDto();
        responseDto.setUserId(shoppingCart.getUser().getId());
        responseDto.setTicketDtoss(shoppingCart.getTickets()
                .stream()
                .map(this::transformToTicketDto)
                .collect(Collectors.toList()));
        return responseDto;
    }

    private TicketDto transformToTicketDto(Ticket ticket) {
        TicketDto dto = new TicketDto();
        dto.setUserId(ticket.getUser().getId());
        dto.setCinemaHallId(ticket.getCinemaHall().getId());
        dto.setMovieId(ticket.getMovie().getId());
        dto.setShowTime(ticket.getShowTime().toString());
        return dto;
    }
}
