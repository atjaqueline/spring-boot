package com.example.springboot;

import com.example.springboot.Repository.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class HelloController {

	@Autowired
	MessagesRepository messagesRepository;

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	// get messages by id
	@GetMapping("/messages/{id}")
	public String getMessage(@PathVariable("id") long id) {
		Message myMessage =  messagesRepository.getReferenceById(id);
		return myMessage.setMessages();
	}

	// get all messages
	@GetMapping("/messages")
	public List<Message> getAll() {
		return messagesRepository.findAll();
	}
	// adds new message
	@PostMapping("/messages")
	Message messages(@RequestBody Message messages) {
		return messagesRepository.save(messages);
	}
}