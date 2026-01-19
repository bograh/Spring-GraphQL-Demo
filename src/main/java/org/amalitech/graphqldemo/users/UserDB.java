package org.amalitech.graphqldemo.users;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDB implements UserRepository {

    private List<User> usersDB = new ArrayList<>();

    @Override
    public User save(User user) {
        usersDB.add(user);
        return user;
    }

    @Override
    public List<User> findAll() {
        return usersDB;
    }

    @Override
    public User findById(int id) {
        return null;
    }
}