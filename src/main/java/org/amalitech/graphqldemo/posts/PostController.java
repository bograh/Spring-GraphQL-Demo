package org.amalitech.graphqldemo.posts;

import org.amalitech.graphqldemo.users.User;
import org.amalitech.graphqldemo.users.UserRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PostController {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostController(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @QueryMapping
    public Post post(@Argument Integer id) {
        return postRepository.findById(id);
    }

    @QueryMapping
    public List<Post> posts() {
        return postRepository.findAll();
    }

    @SchemaMapping
    public User user(Post post) {
        return userRepository.findById(post.getUserId());
    }

    @MutationMapping
    public Post createPost(@Argument CreatePostInput createPostInput) {
        Post post = new Post(
                postRepository.size() + 1,
                createPostInput.title(),
                createPostInput.content(),
                createPostInput.userId()
        );
        return postRepository.save(post);
    }

}