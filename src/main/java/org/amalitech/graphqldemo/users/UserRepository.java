package org.amalitech.graphqldemo.users;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {

    User save(User user);

    List<User> findAll();

    User findById(int id);

    int size();

}