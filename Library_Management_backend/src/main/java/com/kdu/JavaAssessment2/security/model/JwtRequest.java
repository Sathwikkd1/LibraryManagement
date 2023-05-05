package com.kdu.JavaAssessment2.security.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JwtRequest {
    private String userName;
    private String password;
}
