package com.dev.cinema.controllers;

import com.dev.cinema.dto.UserRequestDto;
import com.dev.cinema.exceptions.AuthenticationException;
import com.dev.cinema.service.AuthenticationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping(value = "/login")
    public void login(@RequestBody UserRequestDto userRequestDto) {
        try {
            authenticationService.login(userRequestDto.getEmail(), userRequestDto.getPassword());
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping(value = "/register")
    public void register(@RequestBody UserRequestDto userRequestDto) {
        authenticationService.register(userRequestDto.getEmail(), userRequestDto.getPassword());
    }
}
