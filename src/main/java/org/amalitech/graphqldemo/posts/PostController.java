package org.amalitech.graphqldemo.posts;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PostController {

    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @QueryMapping
    public Post post() {
        return new Post(1, "Title", "Content", 1);
    }

    @QueryMapping
    public List<Post> posts() {
        return postRepository.findAll();
    }

}