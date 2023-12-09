package com.splitwise.scaler.DTOs;

import com.splitwise.scaler.models_myself.Expense;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenerateExpenseResponseDTO {
    private Expense expense;
    private ExpenseGenerationStatus expenseGenerationStatus;
}
