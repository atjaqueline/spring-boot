package com.example.springboot;


import com.example.springboot.Repository.CommentRepository;
import com.example.springboot.Repository.UpdateRepository;
import com.example.springboot.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CommentController {

@Autowired
    private UpdateRepository updateRepository;

@Autowired
    private CommentRepository commentRepository;

// get comments from update Id
@GetMapping("/updates/{updateId}/comments")
public ResponseEntity<List<Comment>> getAllCommentsByUpdateId(@PathVariable(value = "updateId") Long updateId) {
    if (!updateRepository.existsById(updateId)) {
        throw new ResourceNotFoundException(" Update Not found with id = " + updateId);
    }

    List<Comment> comments = commentRepository.findByUpdateId(updateId);
    return new ResponseEntity<>(comments, HttpStatus.OK);
}


@PostMapping("/updates/{updateId}/comments")
    public ResponseEntity<Comment> createComment(@PathVariable(value="updateId") Long updateId, @RequestBody Comment commentRequest) {
    Comment comment = updateRepository.findById(updateId).map(update -> {
        commentRequest.setUpdate(update);
    return commentRepository.save(commentRequest);
}).orElseThrow(() -> new ResourceNotFoundException("Update not found with id = " + updateId));

    return new ResponseEntity<>(comment, HttpStatus.CREATED);
}

}