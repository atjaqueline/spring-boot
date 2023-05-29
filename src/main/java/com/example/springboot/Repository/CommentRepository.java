package com.example.springboot.Repository;

import java.util.List;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
    List<Comment> findByUpdateId(Long updateId);

    @Transactional
    void deleteByUpdateId(long updateId);
}


