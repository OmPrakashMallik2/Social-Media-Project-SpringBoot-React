package com.myproject.MyProject.Controller;

import com.myproject.MyProject.models.Post;
import com.myproject.MyProject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping("/posts/user/{userId}")
    public ResponseEntity<Post> createPost(@RequestBody Post post, @PathVariable Integer userId) throws Exception {
        Post newPost = postService.createNewPost(post, userId);
        return new ResponseEntity<>(newPost, HttpStatus.OK);
    }

    @DeleteMapping("/posts/{postId}/user/{userId}")
    public ResponseEntity<String> deletePost(@PathVariable Integer postId, @PathVariable Integer userId) throws Exception {
        String message = postService.deletePost(postId, userId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable Integer postId) throws Exception {
        Post post = postService.findPostById(postId);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @GetMapping("/posts/user/{userId}")
    public ResponseEntity<List<Post>> getAllPostsOfAUser(@PathVariable Integer userId) {
        List<Post> allPosts = postService.findPostByUserId(userId);
        return new ResponseEntity<>(allPosts, HttpStatus.OK);
    }

    @GetMapping("/api/posts")
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> allPosts = postService.findAllPost();
        return new ResponseEntity<>(allPosts, HttpStatus.OK);
    }

    @PutMapping("/posts/save/{postId}/user/{userId}")
    public ResponseEntity<Post> savePostHandler(@PathVariable Integer postId, @PathVariable Integer userId) throws Exception {
        Post post = postService.savePost(postId, userId);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PutMapping("/posts/like/{postId}/user/{userId}")
    public ResponseEntity<Post> likePostHandler(@PathVariable Integer postId, @PathVariable Integer userId) throws Exception {
        Post post = postService.likePost(postId, userId);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }
}
