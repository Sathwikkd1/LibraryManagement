package com.kdu.JavaAssessment2.model.user;

import com.kdu.JavaAssessment2.entity.UserCredentials;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor

public class UserDetail implements UserDetails {
    private UserCredentials userCredentials;

    public UserDetail(UserCredentials userCredentials){
        this.userCredentials=userCredentials;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return  new HashSet<>();
    }

    @Override
    public String getPassword() {
        return userCredentials.getPassword();
    }

    @Override
    public String getUsername() {
        return userCredentials.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
