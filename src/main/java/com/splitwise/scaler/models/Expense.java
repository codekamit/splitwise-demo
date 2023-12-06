package com.splitwise.scaler.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Expense extends BaseModel {
    @OneToOne
    private User expenseGeneratedBy;
    @ManyToOne
    private Group partOfGroup;
    @OneToMany
    private List<ExpenseShare> expenseShareForTargetUsers;
    private double expenseAmount;
}
