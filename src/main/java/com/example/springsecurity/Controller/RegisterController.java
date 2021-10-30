package com.example.springsecurity.Controller;

import com.example.springsecurity.Entity.Role;
import com.example.springsecurity.Entity.User;
import com.example.springsecurity.Repository.RoleRepository;
import com.example.springsecurity.Repository.UserRepository;
import com.example.springsecurity.Service.UserService;
import com.example.springsecurity.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@RestController
public class RegisterController {

    @Autowired
    UserService userService;

    @Autowired
    RoleRepository repository;

    @PostMapping("/register")
    public String register(@RequestBody UserDto user) {
        Boolean isPresent = userService.checkIfUsernameExists(user.getUsername());
        if(isPresent) return "Username exists";
        Set<Role> roles = new HashSet<>(repository.findAllById(user.getRoles()));
        User user1 = new User();
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        user1.setRoles(roles);
        User u = userService.saveUser(user1);
        return "user saved: "+u.toString();
    }
}
