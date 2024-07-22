package com.practice.todo.post.service;

import com.practice.todo.common.error.ErrorCode;
import com.practice.todo.common.error.exception.ModelNotFoundException;
import com.practice.todo.post.dto.PostRequest;
import com.practice.todo.post.dto.PostResponse;
import com.practice.todo.post.model.PostEntity;
import com.practice.todo.post.repository.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<PostResponse> getAllPosts() {
        return postRepository.findAll().stream()
                .map(PostEntity::toPostResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PostResponse getPost(Long postId) {
        return postRepository.findById(postId)
                .map(PostEntity::toPostResponse)
                .orElseThrow(() -> new ModelNotFoundException(ErrorCode.MODEL_NOT_FOUND));
    }


    @Override
    public void createPost(PostRequest postRequest) {
        PostEntity postEntity = new PostEntity(
                postRequest.getTitle(), postRequest.getContent()
        );
        postRepository.save(postEntity);
    }


    @Override
    public void updatePost(Long postId, String updateContent) {
        PostEntity post = postRepository.findById(postId)
                .orElseThrow(() -> new ModelNotFoundException(ErrorCode.MODEL_NOT_FOUND));
        post.setContent(updateContent);
    }

    @Transactional
    @Override
    public void deletePost(Long postId) {
        PostEntity post = postRepository.findById(postId)
                .orElseThrow(() -> new ModelNotFoundException(ErrorCode.MODEL_NOT_FOUND));
        postRepository.delete(post);
    }
}