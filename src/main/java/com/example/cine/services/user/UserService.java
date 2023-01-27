package com.example.cine.services.user;

import com.example.cine.models.User;
import java.util.List;

public interface UserService {

    public void saveUser(User usuario);

    public List<User> findAllUsers();
}
