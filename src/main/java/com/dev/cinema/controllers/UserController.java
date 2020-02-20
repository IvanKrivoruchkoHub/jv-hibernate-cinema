package com.dev.cinema.controllers;

import com.dev.cinema.dto.UserRequestDto;
import com.dev.cinema.dto.UserResponseDto;
import com.dev.cinema.model.User;
import com.dev.cinema.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public void addUser(@RequestBody UserRequestDto userRequestDto) {
        User user = new User();
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getEmail());
        userService.add(user);
    }

    @GetMapping(value = "/byemail")
    public UserResponseDto getUserByEmail(@RequestParam String email) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setEmail(userService.findByEmail(email).getEmail());
        return userResponseDto;
    }
}
