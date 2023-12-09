package com.splitwise.scaler.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name="user")
@Getter
@Setter
public class User extends BaseModel {
    private String firstName;
    private String lastName;
    private String emailId;
    private String password;
}
