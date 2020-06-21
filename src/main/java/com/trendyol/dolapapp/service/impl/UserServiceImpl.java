package com.trendyol.dolapapp.service.impl;

import com.trendyol.dolapapp.model.User;
import com.trendyol.dolapapp.repo.UserRepository;
import com.trendyol.dolapapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void save(User user) {

    }
}
