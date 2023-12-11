package com.splitwise.scaler.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;

import java.util.List;

@Entity(name="user")
@Getter
@Setter
@EntityListeners(BaseModel.class)
public class User extends BaseModel {
    @NotNull
    @Column(name="first_name")
    private String firstName;

    @NotNull
    @Column(name="last_name")
    private String lastName;

    @Email
    @NotNull
    @Column(unique = true, name="email_id")
    private String emailId;

    @Column(name="password")
    @Size(min = 8)
    private String password;
}
