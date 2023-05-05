package com.kdu.JavaAssessment2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    private String userName;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private java.sql.Timestamp createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false, updatable = false)
    private java.sql.Timestamp updatedAt;
    private java.sql.Timestamp deletedAt;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_credential")
    @JsonIgnore
    private UserCredentials userCredentials;

    public User(UserCredentials userCredentials) {
        this.userName=userCredentials.getUserName();
        this.deletedAt=null;
        this.userCredentials=userCredentials;
    }
}
