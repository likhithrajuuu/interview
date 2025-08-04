package com.think41.interview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.think41.interview.model.UsersModel;

@Repository
public interface UserRepository extends JpaRepository<UsersModel, Long> {
    
}
