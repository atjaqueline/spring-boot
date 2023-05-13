package com.example.springboot;

import com.example.springboot.Repository.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
	public List<Message> getAll(){
		return messagesRepository.findAll();
	}
	@PostMapping("/messages")
	 Message messages(@RequestBody Message messages) {
		return messagesRepository.save(messages);
	}
}


