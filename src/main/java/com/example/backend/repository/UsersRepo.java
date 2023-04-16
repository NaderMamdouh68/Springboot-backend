package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.model.Users;

public interface UsersRepo extends JpaRepository<Users, Long> {


}
