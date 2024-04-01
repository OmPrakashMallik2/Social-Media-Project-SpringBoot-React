package com.myproject.MyProject.repository;

import com.myproject.MyProject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    public User findUserByEmail(String email);
}
