package org.amalitech.graphqldemo.users;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
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
    public User user(@Argument Integer id) {
        return userRepository.findById(id);
    }

    @QueryMapping
    public List<User> users() {
        return userRepository.findAll();
    }

    @MutationMapping
    public User createUser(@Argument String name, @Argument String email) {
        User user = new User(
                userRepository.size() + 1,
                name,
                email
        );
        return userRepository.save(user);
    }

}