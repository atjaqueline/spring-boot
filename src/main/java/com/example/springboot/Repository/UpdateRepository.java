package com.example.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springboot.models.Update;
import java.util.List;

@Repository
public interface UpdateRepository extends JpaRepository<Update, Long> {
    List <Update> findByTitleContaining(String title);
}