package com.dev.cinema.dto;

import java.time.LocalDateTime;
import java.util.List;

public class OrderResponseDto {
    private LocalDateTime orderDate;
    private Long userId;
    private List<TicketDto> ticketsDto;

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<TicketDto> getTicketsDto() {
        return ticketsDto;
    }

    public void setTicketsDto(List<TicketDto> ticketsDto) {
        this.ticketsDto = ticketsDto;
    }
}
