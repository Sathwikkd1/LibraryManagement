package com.kdu.JavaAssessment2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "User_credentials")
public class UserCredentials{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
   @Column(unique = true)
    private String userName;
    private String password;
    public UserCredentials(String userName, String password) {
        this.userName=userName;
        this.password=password;
    }
}
