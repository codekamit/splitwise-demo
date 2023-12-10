package com.splitwise.scaler.models;

import jakarta.persistence.*;
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

    @Column(name="amount")
    private int amount;

    @Enumerated(EnumType.ORDINAL)
    private ExpenseUserType expenseUserType;
}
