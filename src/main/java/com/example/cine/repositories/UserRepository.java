package com.example.cine.repositories;

import com.example.cine.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    public User findUserByIdUser(Long id);

    public User findUserByEmail(String email);

}
