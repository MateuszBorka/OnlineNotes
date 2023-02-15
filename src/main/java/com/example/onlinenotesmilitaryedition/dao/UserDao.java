package com.example.onlinenotesmilitaryedition.dao;

import com.example.onlinenotesmilitaryedition.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserDao extends JpaRepository<User, Long> {
        User findByUsername(String username);

        User findUserById(long id);
}
