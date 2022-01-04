package com.filatov.springboot_rest_js.service;


import com.filatov.springboot_rest_js.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    private final UserService userService;


    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.getUserByName(userName);
//        user.getAuthorities().size();
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
        return user;
    }
}
