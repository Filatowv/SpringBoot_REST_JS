package com.filatov.springboot_rest_js.service;

import com.filatov.springboot_rest_js.model.Role;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface RoleService {
    List<Role> getAllRole();
    void addRole(Role role);
    void updateRole(Role role);
    void deleteRole(long id);
    Role getRoleByName(String name);
}
