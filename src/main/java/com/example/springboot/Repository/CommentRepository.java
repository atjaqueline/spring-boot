package com.example.springboot.Repository;

import java.util.List;
import javax.transaction.Transactional;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
    List<Comment> findByUpdateId(Long postId);

    @Transactional
    void deleteByUpdateId(long updateId);
}


