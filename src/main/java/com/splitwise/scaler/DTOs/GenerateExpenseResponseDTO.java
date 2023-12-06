package com.splitwise.scaler.DTOs;

import com.splitwise.scaler.models.Expense;
import com.splitwise.scaler.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class GenerateExpenseResponseDTO {
    private Expense expense;
    private ExpenseGenerationStatus expenseGenerationStatus;
}
