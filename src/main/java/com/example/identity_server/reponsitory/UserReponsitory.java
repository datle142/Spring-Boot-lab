package com.example.identity_server.reponsitory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.identity_server.entity.user;
import java.util.List;

@Repository
public interface UserReponsitory extends JpaRepository<user,String>{ 
    boolean existsByusername(String username) ;
    Optional<user> findByUsername(String username);
}