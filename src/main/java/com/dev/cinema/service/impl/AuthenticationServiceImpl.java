package com.dev.cinema.service.impl;

import com.dev.cinema.exceptions.AuthenticationException;
import com.dev.cinema.model.User;
import com.dev.cinema.service.AuthenticationService;
import com.dev.cinema.service.ShoppingCartService;
import com.dev.cinema.service.UserService;
import com.dev.cinema.util.HashUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private UserService userService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Override
    public User login(String email, String password) throws AuthenticationException {
        User user = userService.findByEmail(email);
        if (user != null
                && user.getPassword().equals(HashUtil.hashPassword(password, user.getSalt()))) {
            return user;
        }
        throw new AuthenticationException(String.format("Can't find user with email = %s", email));
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        User userRegistered = userService.add(user);
        shoppingCartService.registerNewShoppingCart(userRegistered);
        return userRegistered;
    }
}
