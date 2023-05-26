package com.example.springboot;

import jakarta.persistence.*;

import javax.validation.constraints.Email;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Column(name="username", nullable = false, unique= true)
    private String username;

    @Column(name="password", nullable= false)
    private String password;

    @Column(name="first_name", nulable= false)
    private String firstName;

    @Email
    @Column(name= "email", nulable = false, unique= true)
    private String email;
}