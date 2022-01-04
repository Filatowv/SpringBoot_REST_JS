package com.filatov.springboot_rest_js.dao;

import com.filatov.springboot_rest_js.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {


    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT user FROM User user", User.class).getResultList();
    }

    @Override
    public User addUser(User user) {
        return entityManager.merge(user);
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(long id) {
        entityManager.createQuery("DELETE FROM User WHERE id=:id")
                .setParameter("id",id).executeUpdate();
    }

    @Override
    public User updateUser(User user) {
        return entityManager.merge(user);
    }

    @Override
    //изменил на EAGER
    //SELECT distinct user FROM User user JOIN FETCH user.roles WHERE user.firstName =:userName", User.class
    public User getUserByName(String name) {
        return entityManager.createQuery("SELECT user FROM User user JOIN FETCH user.roles WHERE user.email =:userName", User.class)
                .setParameter("userName", name)
                .getSingleResult();
    }
}
