package com.example.springboot;

import jakarta.persistence.*;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "messages", nullable = false)
    private String messages;

    public Message() {
    }
    // setters and getters
    public String getMessages() {
        return messages;
    }
    public String setMessages() {
        return messages;
    }
    public Long getId(){
        return id;
    }

}