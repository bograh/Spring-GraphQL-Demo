package org.amalitech.graphqldemo.posts;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository {
    Post save(Post post);

    List<Post> findAll();

    Post findById(int id);

    int size();
}