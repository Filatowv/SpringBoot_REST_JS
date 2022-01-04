package com.filatov.springboot_rest_js.dao;


import com.filatov.springboot_rest_js.model.Role;

import java.util.List;


public interface RoleDao {

    List<Role> getAllRole();
    void addRole(Role role);
    void updateRole(Role role);
    void deleteRole(long id);
    Role getRoleByName(String name);
}
