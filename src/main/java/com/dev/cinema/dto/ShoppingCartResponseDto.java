package com.dev.cinema.dto;

import java.util.List;

public class ShoppingCartResponseDto {
    private Long userId;
    private List<TicketDto> ticketDtoss;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<TicketDto> getTicketDtoss() {
        return ticketDtoss;
    }

    public void setTicketDtoss(List<TicketDto> ticketDtoss) {
        this.ticketDtoss = ticketDtoss;
    }
}
