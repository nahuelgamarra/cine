package com.example.cine.services.user;

import com.example.cine.exceptions.UserNotFoundException;
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

    @Override
    public User findUserById(Long id) throws UserNotFoundException {
        User userSearched = this.userRepository.findById(id).orElseThrow();
        return userSearched;
    }

    @Override
    public User findUserByEmail(String email) throws UserNotFoundException {
        User userSearched = this.userRepository.findUserByEmail(email);
        if(userSearched == null)
            throw new UserNotFoundException("No existe, chau");
        return userSearched;
    }
}
