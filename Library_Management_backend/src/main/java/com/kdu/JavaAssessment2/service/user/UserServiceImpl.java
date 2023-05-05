package com.kdu.JavaAssessment2.service.user;

import com.kdu.JavaAssessment2.entity.User;
import com.kdu.JavaAssessment2.entity.UserCredentials;
import com.kdu.JavaAssessment2.exception.InvalidObjectInput;
import com.kdu.JavaAssessment2.exception.ObjectNotFoundException;
import com.kdu.JavaAssessment2.model.user.UserModel;
import com.kdu.JavaAssessment2.repo.UserRepository;
import com.kdu.JavaAssessment2.service.parser.UserAndUserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.List;

@Component
public class UserServiceImpl implements IUserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserAndUserModel userAndUserModel;

    public ResponseEntity<List<UserModel>> getAllUsers() {
        List<User> userList = userRepository.findAll();
        if (userList == null) {
            throw new ObjectNotFoundException("No users Found");
        }
        List<UserModel> userModelList = userAndUserModel.getUserMOdel(userList);
        return new ResponseEntity<>(userModelList, HttpStatus.OK);
    }

    public ResponseEntity<String> addUsers(UserModel userModel, BindingResult result) {
        if (result.hasErrors()) {
            throw new InvalidObjectInput("Invalid object passed");
        }
        UserCredentials userCredentials=new UserCredentials(userModel.getUserName(),userModel.getPassword());
        User user = new User(userCredentials);
        userRepository.save(user);
        return new ResponseEntity<>("Addded Successfully", HttpStatus.OK);
    }
}
