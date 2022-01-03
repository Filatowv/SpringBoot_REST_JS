package com.filatov.springboot_rest_js.repository;

import com.filatov.springboot_rest_js.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);

}
