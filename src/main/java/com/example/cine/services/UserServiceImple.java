package com.example.cine.services;

import com.example.cine.models.User;
import com.example.cine.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImple implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImple(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(User usuario) {
        userRepository.save(usuario);
    }

    @Override
    public List<User> findAllUsers() {
       return (List<User>) userRepository.findAll();
    }
}
