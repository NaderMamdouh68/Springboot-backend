package com.example.backend.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.backend.exception.ResourceNotFound;
import com.example.backend.model.Users;
import com.example.backend.repository.UsersRepo;
import com.example.backend.service.UsersService;


@Service

public class UsersImplementation implements UsersService {

    private UsersRepo usersRepo;

    public UsersImplementation(UsersRepo usersRepo) {
        super();
        this.usersRepo = usersRepo;
    }

    @Override
    public Users saveUser(Users user) {

        return usersRepo.save(user);
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepo.findAll();
    }

    @Override
    public Users getUserById(Long id) {
        // Optional<Users> user = usersRepo.findById(id);
        // if(user.isPresent()) {
        // return user.get();
        // }else {
        // throw new ResourceNotFound("User", "id", id);
        // }
        return usersRepo.findById(id).orElseThrow(() -> new ResourceNotFound("User", "id", id));
    }

    @Override
    public Users updateUserById(Users user, Long id) {
        Users existingUser = usersRepo.findById(id).orElseThrow(() -> new ResourceNotFound("User", "id", id));
        existingUser.setUser_name(user.getUser_name());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setPhonenumber(user.getPhonenumber());
        usersRepo.save(existingUser);
        return existingUser;
        
    }

    @Override
    public void deleteUserById(Long id) {
        usersRepo.findById(id).orElseThrow(() -> new ResourceNotFound("User", "id", id));
        usersRepo.deleteById(id);
    }

}
