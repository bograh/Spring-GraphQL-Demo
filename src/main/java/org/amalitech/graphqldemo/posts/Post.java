package org.amalitech.graphqldemo.posts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Post {
    private int id;
    private String title;
    private String content;
    private int userId;
}