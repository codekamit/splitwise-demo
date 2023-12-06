package com.splitwise.scaler.models;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User extends BaseModel {
    private String firstName;
    private String lastName;
    private String emailId;
    private String password;
    @ManyToMany
    private List<GroupParticipants> participantsInGroup;
    @OneToMany
    private List<Expense> userGeneratedExpenses;
}
