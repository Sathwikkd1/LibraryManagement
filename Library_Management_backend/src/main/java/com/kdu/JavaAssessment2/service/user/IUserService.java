package com.kdu.JavaAssessment2.service.user;

import com.kdu.JavaAssessment2.model.user.UserModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface IUserService {
    public ResponseEntity<List<UserModel>> getAllUsers();
    public ResponseEntity<String> addUsers(UserModel userModel, BindingResult result);
}
