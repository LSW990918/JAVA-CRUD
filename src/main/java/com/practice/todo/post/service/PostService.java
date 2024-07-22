package com.practice.todo.post.service;

import com.practice.todo.post.dto.PostRequest;
import com.practice.todo.post.dto.PostResponse;

import java.util.List;

import java.util.List;

public interface PostService {
    List<PostResponse> getAllPosts();
    PostResponse getPost(Long postId);
    void createPost(PostRequest postRequest);
    void updatePost(Long postId, String updateContent);
    void deletePost(Long postId);
}


