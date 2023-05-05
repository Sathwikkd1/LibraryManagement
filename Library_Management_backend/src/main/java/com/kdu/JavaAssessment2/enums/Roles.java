package com.kdu.JavaAssessment2.enums;


public enum Roles {
    ADMIN("ADMIN"),
    USER("USER");

    private final String role;
    Roles(String role){
        this.role=role;
    }

    public String getRole() {
        return role;
    }
}