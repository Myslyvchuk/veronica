package com.myslyv4uk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myslyv4uk.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
