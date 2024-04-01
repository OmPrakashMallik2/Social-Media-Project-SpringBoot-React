package com.myproject.MyProject.service;

import com.myproject.MyProject.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public User addUser(User user);

    public List<User> getAllUsers();

    public User getUserById(Integer userId) throws Exception;

    public User getUserByEmail(String email);

    public String followUser(Integer userId1, Integer userId2) throws Exception;

    public User updateUser(Integer userId, User user);

    public String deleteUser(Integer userId) throws Exception;
}
