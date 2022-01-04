package com.filatov.springboot_rest_js.service;

import com.filatov.springboot_rest_js.model.Role;

import java.util.List;


public interface RoleService {

    List<Role> getAllRole();
    void addRole(Role role);
    void updateRole(Role role);
    void deleteRole(long id);
    Role getRoleByName(String name);
}
