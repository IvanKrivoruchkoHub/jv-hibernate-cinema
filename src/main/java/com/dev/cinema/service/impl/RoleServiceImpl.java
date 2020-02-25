package com.dev.cinema.service.impl;

import com.dev.cinema.dao.RoleDao;
import com.dev.cinema.model.Role;
import com.dev.cinema.service.RoleService;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public Role add(Role role) {
        return roleDao.add(role);
    }

    @Override
    public Role getByName(String name) {
        return roleDao.getByName(name);
    }

    @PostConstruct
    private void init() {
        Role adminRole = new Role();
        adminRole.setRoleName("ADMIN");
        add(adminRole);
        Role userRole = new Role();
        userRole.setRoleName("USER");
        add(userRole);
    }
}
