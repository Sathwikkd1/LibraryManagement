package com.kdu.JavaAssessment2.service.parser;

import com.kdu.JavaAssessment2.entity.User;
import com.kdu.JavaAssessment2.model.user.UserModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserAndUserModel {
    public List<UserModel> getUserMOdel(List<User> userList){
        List<UserModel> userModelList=new ArrayList<>();
        for(User user: userList){
            UserModel userModel=new UserModel(user.getUserId(),user.getUserCredentials().getUserName(),user.getUserCredentials().getPassword());
            userModelList.add(userModel);
        }
        return userModelList;
    }
}
