package com.example.cine.services.user;

import com.example.cine.exceptions.UserNotFoundException;
import com.example.cine.models.User;
import com.example.cine.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public User findUserById(Long id) throws UserNotFoundException {
        User userSearched = this.userRepository.findById(id).orElseThrow();
        return userSearched;
    }

    @Override
    public Optional<User> findUserByEmail(String email) throws UserNotFoundException {
        return Optional.ofNullable(this.userRepository.findUserByEmail(email)).orElseThrow(() -> new UserNotFoundException("error"));
    }
}
