package com.example.springboot;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.lang.constant.ConstantDesc;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_generator")
    private Long id;

    @Lob
    private String Content;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "update_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Update update;

}