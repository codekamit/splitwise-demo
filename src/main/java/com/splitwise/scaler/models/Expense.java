package com.splitwise.scaler.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name="expense")
public class Expense extends BaseModel {
    private String description;
    private int expenseAmount;

    @OneToOne
    private User expenseGeneratedBy;

    @ManyToOne
    private Group partOfGroup;

    @Enumerated(EnumType.ORDINAL)
    private ExpenseType expenseType;

    @OneToMany
    private List<ExpenseUser> expenseUsers;
}
