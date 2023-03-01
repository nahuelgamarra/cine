package com.example.cine.services.user;

import com.example.cine.exceptions.UserNotFoundException;
import com.example.cine.models.User;
import java.util.List;
import java.util.Optional;

public interface UserService {

    public void saveUser(User usuario);

    public List<User> findAllUsers();

    public User findUserById(Long id) throws UserNotFoundException;

    public Optional<User> findUserByEmail(String email) throws UserNotFoundException;
}
