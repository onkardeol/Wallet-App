package com.example.wallet.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.wallet.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    
    Optional<User> findByUserName(String username);
}