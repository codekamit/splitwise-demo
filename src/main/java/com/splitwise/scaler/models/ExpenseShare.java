package com.splitwise.scaler.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ExpenseShare extends BaseModel {
    @ManyToOne
    private Expense expense;
    @ManyToOne
    private User targetUser;
    private double amountToPay;
}
