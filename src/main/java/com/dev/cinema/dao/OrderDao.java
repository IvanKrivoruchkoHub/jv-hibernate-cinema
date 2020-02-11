package com.dev.cinema.dao;

import java.util.List;

import com.dev.cinema.model.Order;
import com.dev.cinema.model.User;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrderHistory(User user);
}
