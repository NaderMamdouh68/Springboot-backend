package com.example.backend.service;

import java.util.List;

import com.example.backend.model.Users;

public interface UsersService {
    
    Users saveUser(Users user);
    List<Users> getAllUsers();
    Users getUserById(Long id);
    Users updateUserById(Users user, Long id);
    void deleteUserById(Long id);


}
