package com.example.springboot;

import com.example.springboot.Repository.UserRepository;
import com.example.springboot.security.jwt.JwtUtils;
import com.example.springboot.models.User;
import com.example.springboot.request.LoginRequest;
import com.example.springboot.request.SignupRequest;
import com.example.springboot.response.JwtResponse;
import com.example.springboot.response.MessageResponse;
import com.example.springboot.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateuser
            (@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager
                .authenticate
                        (new UsernamePasswordAuthenticationToken
                                (loginRequest.getUsername(),
                                        loginRequest.getPassword()));

        SecurityContextHolder.getContext()
                .setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl)
                authentication.getPrincipal();

        return ResponseEntity
                .ok(new JwtResponse(jwt, userDetails.getId(),
                        userDetails.getUsername(),
                        userDetails.getEmail()));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser
            (@RequestBody SignupRequest signUpRequest) {

        if (userRepository.existsByUsername(signUpRequest
                .getUsername())) {

            return ResponseEntity.badRequest()
                    .body(new MessageResponse
                            ("Error: username is already taken!"));
        }

        if (userRepository.existsByEmail
                (signUpRequest.getEmail())) {

            return ResponseEntity.badRequest()
                    .body(new MessageResponse
                            ("Error: Email is already in use!"));
        }

        // Create new user account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        userRepository.save(user);

        return ResponseEntity
                .ok(new MessageResponse("user registered successfully!"));
    }
}