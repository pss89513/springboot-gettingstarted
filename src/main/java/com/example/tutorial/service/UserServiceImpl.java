package com.example.tutorial.service;

import com.example.tutorial.dto.UserRegForm;
import com.example.tutorial.entity.User;
import com.example.tutorial.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service("userService")
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "not found user"));
    }

    @Override
    public User findUserByName(String name) {
        return userRepository.findUserByName(name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "not found user"));
    }

    @Override
    public void saveUser(UserRegForm userRegForm) {
        User user = new User();
        user.setName(userRegForm.getName());
        user.setAge(userRegForm.getAge());
        user.setPhoneNumber(userRegForm.getPhoneNumber());

        userRepository.save(user);
    }
}
