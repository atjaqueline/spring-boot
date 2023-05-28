package com.example.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springboot.User;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
    User findByUsername(String username);
}