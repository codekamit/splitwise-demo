package com.splitwise.scaler.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name="splitwise_group")
public class Group extends BaseModel {
    @Column(name="group_name")
    @NotNull
    private String groupName;

    @ManyToMany
    private List<User> groupParticipants;

    @OneToMany(mappedBy = "partOfGroup")
    private List<Expense> groupExpenses;

    @ManyToOne
    @NotNull
    private User groupAdmin;
}
