package com.example.cine;

import com.example.cine.models.User;
import com.example.cine.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void thatWhenCreatingUserShouldObtainOneUser() {
        User usuario = new User();
        usuario.setName("Pepe");
        usuario.setEmail("pepe@gmail.com");
        usuario.setPassword("1234");
        userService.saveUser(usuario);
        List<User> listUser = userService.findAllUsers();
        assertThat(listUser.get(0).getIdUser()).isEqualTo(usuario.getIdUser());
    }

    @Test
    void thatWhenCreatingUserShouldObtainTwoUsers() {
        User usuario = new User();
        usuario.setName("Pepe");
        usuario.setEmail("pepe@gmail.com");
        usuario.setPassword("1234");

        User usuarioTwo = new User();
        usuarioTwo.setName("PepeTwo");
        usuarioTwo.setEmail("pepeTwo@gmail.com");
        usuarioTwo.setPassword("12345");

        userService.saveUser(usuario);
        userService.saveUser(usuarioTwo);
        List<User> listUser = userService.findAllUsers();
        assertThat(listUser.size()).isEqualTo(2);
    }
}
