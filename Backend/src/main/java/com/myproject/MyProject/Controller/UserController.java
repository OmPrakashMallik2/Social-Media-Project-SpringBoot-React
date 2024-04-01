package com.myproject.MyProject.Controller;

import com.myproject.MyProject.models.User;
import com.myproject.MyProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/api/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Integer userId) throws Exception {
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }

    @GetMapping("/users/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.OK);
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Integer userId, @RequestBody User user) throws Exception {
        User updatedUser = userService.updateUser(userId, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer userId) throws Exception {
        String message = userService.deleteUser(userId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("users/follow/{userId1}/{userId2}")
    public ResponseEntity<String> followHandler(@PathVariable Integer userId1, @PathVariable Integer userId2) throws Exception {
        return new ResponseEntity<>(userService.followUser(userId1, userId2), HttpStatus.OK);
    }

    // search user functionality

}
