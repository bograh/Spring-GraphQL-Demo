package org.amalitech.graphqldemo.posts;

public record CreatePostInput(
        String title,
        String content,
        Integer userId
) {
}