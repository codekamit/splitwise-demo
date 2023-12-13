package com.scaler.splitwise.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity(name="user_expense")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class ExpenseUser extends BaseModel {
    @ManyToOne
    private Expense expense;

    @ManyToOne
    private User targetUser;

    @Column(name="amount")
    private int amount;

    @Enumerated(EnumType.ORDINAL)
    private ExpenseUserType expenseUserType;
}
