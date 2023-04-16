package com.example.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.Users;
import com.example.backend.service.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {


    private UsersService usersService;

    public UsersController(UsersService usersService) {
        super();
        this.usersService = usersService;
    }


    @PostMapping
    public ResponseEntity<Users> saveUser(@RequestBody Users user) {
        return new ResponseEntity<Users>(usersService.saveUser(user),HttpStatus.CREATED);
    }

    @GetMapping
    public List<Users> getAllUsers() {
        return usersService.getAllUsers();
    }

    @GetMapping("userdetails/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable("id") Long userId) {
        return new ResponseEntity<Users>(usersService.getUserById(userId),HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Users> updateUserById(@RequestBody Users user, @PathVariable("id") Long userId) {
        return new ResponseEntity<Users>(usersService.updateUserById(user, userId),HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long userId) {
        usersService.deleteUserById(userId);
        return new ResponseEntity<String>("User deleted successfully",HttpStatus.OK);
    }

}
