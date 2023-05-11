package com.example.springboot;

import com.example.springboot.Repository.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

	@Autowired
	MessagesRepository messagesRepository;

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@GetMapping("/messages/{id}")
	public String getMessage(@PathVariable("id") long id) {
		Message myMessage =  messagesRepository.getReferenceById(id);
		return myMessage.getData();
	}
}


