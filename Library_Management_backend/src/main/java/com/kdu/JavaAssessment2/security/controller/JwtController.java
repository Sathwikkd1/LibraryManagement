package com.kdu.JavaAssessment2.security.controller;

import com.kdu.JavaAssessment2.entity.User;
import com.kdu.JavaAssessment2.entity.UserCredentials;
import com.kdu.JavaAssessment2.repo.UserCredentialsRepository;
import com.kdu.JavaAssessment2.repo.UserRepository;
import com.kdu.JavaAssessment2.security.model.JwtRequest;
import com.kdu.JavaAssessment2.security.model.JwtResponse;
import com.kdu.JavaAssessment2.security.service.CustomUserDetailService;
import com.kdu.JavaAssessment2.security.service.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/sathwik")
@Slf4j
public class JwtController {
    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    private UserCredentialsRepository userCredentialsRepository;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;
    @PostMapping("/getToken")
    public ResponseEntity<String> getToken(@RequestBody JwtRequest jwtRequest) throws RuntimeException{
        String token=customUserDetailService.fetchToken(authenticationManager,jwtRequest,customUserDetailService);
                return new ResponseEntity<>(token, HttpStatus.OK);
    }
    @PostMapping("/register")
    public  ResponseEntity<String> register(@RequestParam(name = "userName") String userName,@RequestParam(name = "password") String password){
        UserCredentials userCredentials=new UserCredentials(userName,password);
        User user=new User(userCredentials);
        userRepository.save(user);
        return new ResponseEntity<>("Registered successfully",HttpStatus.OK);
    }
}
