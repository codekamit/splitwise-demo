package com.splitwise.scaler.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Getter
@Setter
@Entity(name="expense")
@EntityListeners(AuditingEntityListener.class)
public class Expense extends BaseModel {
    @Column(name="description")
    private String description;

    @Column(name="expense_amount")
    private int expenseAmount;

    @ManyToOne
    private User expenseGeneratedBy;

    @ManyToOne
    private Group partOfGroup;

    @Enumerated(EnumType.ORDINAL)
    private ExpenseType expenseType;

    @OneToMany(mappedBy = "expense")
    private List<ExpenseUser> expenseUsers;
}
