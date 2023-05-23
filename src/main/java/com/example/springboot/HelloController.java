package com.example.springboot;

import com.example.springboot.Repository.MessagesRepository;
import com.example.springboot.Repository.UpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class HelloController {

	@Autowired
	MessagesRepository messagesRepository;
	@Autowired
	UpdateRepository updatesRepository;

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	// get all messages
	@GetMapping("/messages")
	public List<Message> getAll() {
		return messagesRepository.findAll();
	}	// get messages by id

	// get message by id
	@GetMapping("/messages/{id}")
	public String getMessage(@PathVariable("id") long id) {
		Message myMessage =  messagesRepository.getReferenceById(id);
		return myMessage.setMessages();
	}

	// adds new message
	@PostMapping("/messages")
	Message messages(@RequestBody Message messages) {
		return messagesRepository.save(messages);
	}

	@PutMapping("messages/{id}")
	ResponseEntity<Message> updateMessage(@RequestBody Message messages){
		Message result = messagesRepository.save(messages);
		return ResponseEntity.ok().body(result);
	}

	// delete message by id
	@DeleteMapping("/messages/{id}")
	public ResponseEntity<?> deleteMessage(@PathVariable Long id){
		messagesRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}


}