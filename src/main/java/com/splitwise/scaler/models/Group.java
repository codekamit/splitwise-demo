package com.splitwise.scaler.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name="group")
public class Group extends BaseModel {
    private String groupName;
    @ManyToMany
    private List<User> groupParticipants;
    @OneToMany(mappedBy = "partOfGroup")
    private List<Expense> groupExpenseHistory;
    @ManyToOne
    private User groupAdmin;
}
