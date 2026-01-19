package org.amalitech.graphqldemo.users;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @QueryMapping
    public User user() {
        return new User(1, "Tim", "tim@email.com");
    }

    @QueryMapping
    public List<User> users() {
        return userRepository.findAll();
    }

}