package com.practice.todo.post.model;


import com.practice.todo.common.model.BaseEntity;
import com.practice.todo.post.dto.PostResponse;
import jakarta.persistence.*;

@Entity
@Table(name = "posts")
public class PostEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

    protected PostEntity() {}

    public PostEntity(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public PostResponse toPostResponse() {
        return new PostResponse(
                id,
                title,
                content
        );
    }
}

