package com.example.springsecurity.Controller;

import com.example.springsecurity.Entity.Role;
import com.example.springsecurity.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @Autowired
    RoleRepository repository;

    @PutMapping("/addRole/{rolename}")
    public String addRole(@PathVariable("rolename") String roleName) {
        Role role = Role.builder().roleName(roleName).build();
        repository.save(role);
        return "Role saved";
    }
}
