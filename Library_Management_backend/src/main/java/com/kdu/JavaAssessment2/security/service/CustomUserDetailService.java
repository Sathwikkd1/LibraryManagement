package com.kdu.JavaAssessment2.security.service;

import com.kdu.JavaAssessment2.entity.UserCredentials;
import com.kdu.JavaAssessment2.model.user.UserDetail;
import com.kdu.JavaAssessment2.repo.UserCredentialsRepository;
import com.kdu.JavaAssessment2.security.model.JwtRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    UserCredentialsRepository userCredentialsRepository;

    @Autowired
    JwtUtil jwtUtil;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCredentials userCredentials=userCredentialsRepository.findByUserName(username);
        if(userCredentials==null){
            throw new UsernameNotFoundException("User name not found");
        }
        return new UserDetail(userCredentials);
    }

    public String fetchToken(AuthenticationManager authenticationManager, JwtRequest jwtRequest, CustomUserDetailService customUserDetailService){
        log.info("fetch token for user: " + jwtRequest.getUserName());
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUserName(), jwtRequest.getPassword()));
        }catch (UsernameNotFoundException e){
            throw new UsernameNotFoundException("UserName not found: " + jwtRequest.getUserName());
        }
        UserDetails userDetails = customUserDetailService.loadUserByUsername(jwtRequest.getUserName());
        log.info(userDetails.getAuthorities() + " " + userDetails.getUsername());
        String token = jwtUtil.generateToken(userDetails);
        log.info("JWT: " + token);
        return token;
    }

}
