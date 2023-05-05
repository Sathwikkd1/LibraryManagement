package com.kdu.JavaAssessment2.controller;

import com.kdu.JavaAssessment2.model.user.UserModel;
import com.kdu.JavaAssessment2.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/sathwik")
public class UserController {
    @Autowired
    IUserService userService;
    @GetMapping("/getAllUsers")
    ResponseEntity<List<UserModel>> getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping("/addUsers")
    ResponseEntity<String> addUsers(@Valid @RequestBody UserModel userModel, BindingResult result){
        return userService.addUsers(userModel,result);
    }
}
