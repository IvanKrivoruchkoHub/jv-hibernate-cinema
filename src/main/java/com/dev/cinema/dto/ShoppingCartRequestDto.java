package com.dev.cinema.dto;

import javax.validation.constraints.NotNull;

public class ShoppingCartRequestDto {
    @NotNull
    private Long movieSessionId;

    public Long getMovieSessionId() {
        return movieSessionId;
    }

    public void setMovieSessionId(Long movieSessionId) {
        this.movieSessionId = movieSessionId;
    }
}
