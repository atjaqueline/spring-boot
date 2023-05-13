package com.example.springboot;


import jakarta.persistence.*;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "messages", nullable = false)
    private String messages;


    public Message() {
    }

    public Message(long id, String messages){
        this.id = id;
        this.messages = messages;
    }

    public String getMessages() {
        return messages;
    }
    public String setMessages() {
        return messages;
    }
}