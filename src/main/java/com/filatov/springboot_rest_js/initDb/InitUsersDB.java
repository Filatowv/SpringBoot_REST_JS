package com.filatov.springboot_rest_js.initDb;

import com.filatov.springboot_rest_js.model.Role;
import com.filatov.springboot_rest_js.model.User;
import com.filatov.springboot_rest_js.service.RoleService;
import com.filatov.springboot_rest_js.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class InitUsersDB {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public InitUsersDB(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void initApiUserData() {
        Role user = new Role("USER");
        Role admin = new Role("ADMIN");

        Set<Role> roleUser = new HashSet<>();
        Set<Role> roleAdminUser = new HashSet<>();

        roleUser.add(user);
        roleAdminUser.add(user);
        roleAdminUser.add(admin);

        roleService.addRole(user);
        roleService.addRole(admin);


        User user1 = new User("admin" ,"ADMIN",(byte) 34,"admin@mail.ru","ADMIN");
        user1.setRoles(roleAdminUser);

        User user2 = new User("user" ,"USER",(byte) 30,"user@mail.ru","USER");
        user2.setRoles(roleUser);



        userService.addUser(user1);
        userService.addUser(user2);
    }
}
