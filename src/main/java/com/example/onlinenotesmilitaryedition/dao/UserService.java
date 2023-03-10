package com.example.onlinenotesmilitaryedition.dao;

import com.example.onlinenotesmilitaryedition.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {

    User findByUsername(String username);

    User findByUserId(Long userid);
    void save(User user);
    List<User> findAll();
    void deleteById(long id);
}
