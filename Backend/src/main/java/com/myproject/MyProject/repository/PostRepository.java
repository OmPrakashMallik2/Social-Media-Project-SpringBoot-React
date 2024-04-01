package com.myproject.MyProject.repository;

import com.myproject.MyProject.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    @Query("select p from Post p where p.user.id = :userId")
    public List<Post> findAllPostByUserId(Integer userId);
}
