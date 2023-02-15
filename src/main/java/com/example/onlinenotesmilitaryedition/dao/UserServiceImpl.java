package com.example.onlinenotesmilitaryedition.dao;

import com.example.onlinenotesmilitaryedition.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public void save(User user) {
        user.setAdminRights(false);
        userDao.save(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void deleteById(long id) {
        userDao.deleteById(id);
    }
}
