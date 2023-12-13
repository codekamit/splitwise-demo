package com.scaler.splitwise.DTOs;

import com.scaler.splitwise.models.Expense;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenerateExpenseResponseDTO {
    private Expense expense;
    private ExpenseGenerationStatus expenseGenerationStatus;
}
