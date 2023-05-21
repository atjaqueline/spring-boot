package com.example.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springboot.Update;

@Repository
public interface UpdatesRepository extends JpaRepository<Update, Long> {
}