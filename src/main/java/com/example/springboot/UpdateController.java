package com.example.springboot;

import com.example.springboot.Repository.UpdateRepository;
import com.example.springboot.Update;
import com.example.springboot.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UpdateController {

    @Autowired
    UpdateRepository updateRepository;

    // get all updates
    @GetMapping("/updates")
    public ResponseEntity<List<Update>> getAllUpdates(@RequestParam(required = false) String title){
        List<Update> updates = new ArrayList<Update>();

        if (title == null)
            updateRepository.findAll().forEach(updates::add);
        else
            updateRepository.findByTitleContaining(title).forEach(updates::add);

        if (updates.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
            return new ResponseEntity<>(updates, HttpStatus.OK);
    }
    // get update by ID
    @GetMapping("/updates/{id}")
    public ResponseEntity<Update> getUpdateById(@PathVariable("id") long id){
        Update update = updateRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));
        return new ResponseEntity<>(update, HttpStatus.OK);
    }


    // post request - creates new update
    @PostMapping("/updates")
    public ResponseEntity<Update> createUpdate(@RequestBody Update update){
        Update _update = updateRepository.save(new Update(update.getTitle(), update.getDescription(), update.getAffected_team(), update.getSubmited_by()));
        return new ResponseEntity<>(_update, HttpStatus.CREATED);
        }

        // delete update by id

    @DeleteMapping("/updates/{id}")
    public ResponseEntity<HttpStatus> deleteUpdate(@PathVariable("id") long id){
        updateRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        // to do - find updates by team
    }



