package com.myproject.MyProject.service;

import com.myproject.MyProject.models.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    public Post createNewPost(Post post, Integer userId) throws Exception;

    public String deletePost(Integer postId, Integer userId) throws Exception;

    public List<Post> findPostByUserId(Integer userId);

    public Post findPostById(Integer postId) throws Exception;

    public List<Post> findAllPost();

    public Post savePost(Integer postId, Integer userId) throws Exception;

    public Post likePost(Integer postId, Integer userId) throws Exception;
}
