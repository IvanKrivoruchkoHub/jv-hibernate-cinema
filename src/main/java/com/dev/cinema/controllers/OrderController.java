package com.dev.cinema.controllers;

import com.dev.cinema.dto.OrderResponseDto;
import com.dev.cinema.dto.TicketDto;
import com.dev.cinema.dto.UserRequestDto;
import com.dev.cinema.model.Order;
import com.dev.cinema.model.Ticket;
import com.dev.cinema.service.OrderService;
import com.dev.cinema.service.ShoppingCartService;
import com.dev.cinema.service.UserService;

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
@RequestMapping(value = "/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private UserService userService;

    @PostMapping(value = "/complete")
    public void completeOrder(@RequestBody UserRequestDto userRequestDto) {
        orderService.completeOrder(shoppingCartService
                .getByUser(userService.findByEmail(userRequestDto.getEmail())));
    }

    @GetMapping
    public List<OrderResponseDto> getOrdersHistory(@RequestParam Long userId) {
        return orderService.getOrderHistory(userService.getById(userId))
                .stream()
                .map(this::toOrderResponseDto)
                .collect(Collectors.toList());
    }

    private TicketDto toTicketDto(Ticket ticket) {
        TicketDto dto = new TicketDto();
        dto.setUserId(ticket.getUser().getId());
        dto.setCinemaHallId(ticket.getCinemaHall().getId());
        dto.setMovieId(ticket.getMovie().getId());
        dto.setShowTime(ticket.getShowTime().toString());
        return dto;
    }

    private OrderResponseDto toOrderResponseDto(Order order) {
        OrderResponseDto dto = new OrderResponseDto();
        dto.setOrderDate(order.getOrderDate());
        dto.setUserId(order.getUser().getId());
        dto.setTicketsDto(order.getTickets()
                .stream()
                .map(this::toTicketDto)
                .collect(Collectors.toList()));
        return dto;
    }
}
