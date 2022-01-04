package com.filatov.springboot_rest_js.service;

import com.filatov.springboot_rest_js.dao.UserDao;
import com.filatov.springboot_rest_js.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override

    public User addUser(User user) {
        user.setPasswordUser(getPasswordEncoder().encode(user.getPasswordUser()));
        return userDao.addUser(user);
    }

    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    public User updateUser(User user) {
        user.setPasswordUser(getPasswordEncoder().encode(user.getPasswordUser()));
       return userDao.updateUser(user);
    }

    @Override
    public User getUserByName(String userName) {
        return userDao.getUserByName(userName);
    }

    @Override
    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }
}
