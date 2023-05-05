package com.kdu.JavaAssessment2.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    @NotNull
    private long userId;
    @NotNull
    private String userName;
    @NotNull
    private String password;
}
