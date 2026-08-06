package com.techsctock.techstockcontrol.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techsctock.techstockcontrol.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}