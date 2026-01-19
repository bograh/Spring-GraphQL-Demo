package org.amalitech.graphqldemo;

import org.amalitech.graphqldemo.posts.Post;
import org.amalitech.graphqldemo.posts.PostRepository;
import org.amalitech.graphqldemo.users.User;
import org.amalitech.graphqldemo.users.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Config {

    @Bean
    public CommandLineRunner commandLineRunner(PostRepository postRepository, UserRepository userRepository) {
        return args -> {
            createPosts(postRepository);
            createUsers(userRepository);
        };

    }

    private void createUsers(UserRepository userRepository) {
        var users = List.of(
                new User(1, "John", "john@email.com"),
                new User(2, "Jack", "jack@email.com"),
                new User(3, "Tim", "tim@email.com"),
                new User(4, "Mark", "mark@email.com"),
                new User(5, "Tom", "tom@email.com"),
                new User(6, "Jane", "jane@email.com"),
                new User(7, "Ben", "ben@email.com"),
                new User(8, "Jake", "jake@email.com")
        );

        users.forEach(userRepository::save);
    }

    private void createPosts(PostRepository postRepository) {
        var posts = List.of(
                new Post(1, "First Post", "This is the first post", 1),
                new Post(2, "Second Post", "Spring Boot is awesome", 1),
                new Post(3, "GraphQL Intro", "Learning GraphQL with Spring", 2),
                new Post(4, "JPA Tips", "Avoid N+1 queries", 3)
        );

        posts.forEach(postRepository::save);
    }

}