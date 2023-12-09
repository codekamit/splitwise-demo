package com.splitwise.scaler.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity(name="user_expense")
@Getter
@Setter
public class ExpenseUser extends BaseModel{
    @ManyToOne
    private Expense expense;
    @ManyToOne
    private User targetUser;
    private int amount;
    private ExpenseUserType expenseUserType;
}
