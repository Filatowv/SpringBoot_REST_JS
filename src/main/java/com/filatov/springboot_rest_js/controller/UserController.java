package com.filatov.springboot_rest_js.controller;


import com.filatov.springboot_rest_js.model.User;
import com.filatov.springboot_rest_js.service.RoleService;
import com.filatov.springboot_rest_js.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class UserController {


    private final RoleService roleService;

    @Autowired
    public UserController( RoleService roleService) {
        this.roleService = roleService;
    }



    @GetMapping(value = "/user")
    public String getUserInfo(@AuthenticationPrincipal User user, Model model){
        model.addAttribute("user", user);
        return "userPanel";
    }


    @GetMapping(value = "/admin")
    public String getAllUsers(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", roleService.getAllRole());
        return "adminPanel";
    }
}
