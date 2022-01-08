package com.filatov.springboot_rest_js.service;

import com.filatov.springboot_rest_js.model.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User addUser(User user);
    User getUserById(long id);
    void deleteUser(long id);
    User updateUser(User user);
    User getUserByEmail(String email);
}
