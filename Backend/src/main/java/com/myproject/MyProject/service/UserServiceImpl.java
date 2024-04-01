package com.myproject.MyProject.service;

import com.myproject.MyProject.models.User;
import com.myproject.MyProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(User user) {
        User newUser = new User();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        return userRepository.save(newUser);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer userId) throws Exception {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new Exception("User Not found by this" + userId);
        }
        return user.get();
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public String followUser(Integer userId1, Integer userId2) throws Exception {
        User follower = getUserById(userId1);
        User followee = getUserById(userId2);

        follower.getFollowings().add(followee.getId());

        followee.getFollowers().add(follower.getId());

        userRepository.save(follower);
        userRepository.save(followee);

        return "User " + follower.getId() + " is now following user " + followee.getId();
    }


    @Override
    public User updateUser(Integer userId, User user) {
        Optional<User> foundUser = userRepository.findById(userId);

        User oldUser = foundUser.get();

        if (user.getFirstName() != null) {
            oldUser.setFirstName(user.getFirstName());
        }
        if (user.getLastName() != null) {
            oldUser.setLastName(user.getLastName());
        }
        if (user.getEmail() != null) {
            oldUser.setEmail(user.getEmail());
        }
        if (user.getPassword() != null) {
            oldUser.setPassword(user.getPassword());
        }
        return userRepository.save(oldUser);
    }

    @Override
    public String deleteUser(Integer userId) throws Exception {
        Optional<User> foundUser = userRepository.findById(userId);
        if (foundUser.isPresent()) {
            userRepository.delete(foundUser.get());
        } else {
            throw new Exception("User not found in database");
        }
        return "user deleted successfully";
    }
}
