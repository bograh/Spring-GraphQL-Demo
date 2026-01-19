package org.amalitech.graphqldemo.posts;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostDB implements PostRepository {

    private List<Post> postsDB = new ArrayList<>();

    @Override
    public Post save(Post post) {
        postsDB.add(post);
        return post;
    }

    @Override
    public List<Post> findAll() {
        return postsDB;
    }

    @Override
    public Post findById(int id) {
        return null;
    }
}