package com.example.identity_server.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.identity_server.entity.user;
@Repository
public interface UserReponsitory extends JpaRepository<user,String>{ 

    
}