package com.example.tutorial.service;

import com.example.tutorial.dto.UserRegForm;
import com.example.tutorial.entity.User;

public interface UserService {
    User findUserById(Long id);

    User findUserByName(String name);

    void saveUser(UserRegForm userRegForm);
}
