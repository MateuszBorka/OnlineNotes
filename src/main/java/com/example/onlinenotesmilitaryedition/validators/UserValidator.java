package com.example.onlinenotesmilitaryedition.validators;

import com.example.onlinenotesmilitaryedition.dao.UserDao;
import com.example.onlinenotesmilitaryedition.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {


    private final UserDao userDao;


    @Autowired
    public UserValidator(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        if (userDao.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "username.alreadyExists", "Username already exists");
        }
    }
}
