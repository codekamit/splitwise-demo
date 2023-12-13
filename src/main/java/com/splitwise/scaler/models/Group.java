package com.scaler.splitwise.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Getter
@Setter
@Entity(name="splitwise_group")
@EntityListeners(AuditingEntityListener.class)
public class Group extends BaseModel {
    @Column(name="group_name")
    @NotNull
    private String groupName;

    @ManyToMany
    private List<User> groupParticipants;

    @OneToMany(mappedBy = "partOfGroup")
    private List<Expense> groupExpenses;

    @NotNull
    @ManyToOne
    private User groupAdmin;
}
