package com.shesha.projects.springbootcrud.controllers;

import com.shesha.projects.springbootcrud.entities.User;
import com.shesha.projects.springbootcrud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registeruser")
    public User saveUser(@RequestBody User user)
    {
        return userService.saveUser(user);
    }

    @GetMapping("/users/{username}")
    public User getUserByUserName(@PathVariable String username)
    {
       return userService.getUserByUsername(username);
    }

    @DeleteMapping("/deleteuser/{id}")
    public String deleteUser(@PathVariable int id)
    {
        return userService.deleteUser(id);
    }

    @PutMapping("/updateuser")
    public User updateUserDetails(@RequestBody User user)
    {
        return userService.updateUser(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers()
    {
        return userService.getUsers();
    }
}
