package com.splitwise.scaler.controllers;

import com.splitwise.scaler.DTOs.ExpenseGenerationStatus;
import com.splitwise.scaler.DTOs.GenerateExpenseRequestDTO;
import com.splitwise.scaler.DTOs.GenerateExpenseResponseDTO;
import com.splitwise.scaler.exceptions.GroupCannotBeFoundException;
import com.splitwise.scaler.exceptions.UserCannotBeFoundException;
import com.splitwise.scaler.models_myself.Expense;
import com.splitwise.scaler.services.ExpenseService;
import com.splitwise.scaler.services.UserService;

public class ExpenseController {
    private ExpenseService expenseService;
    private UserService userService;
    public GenerateExpenseResponseDTO generateExpense(GenerateExpenseRequestDTO generateExpenseRequestDTO) {
        GenerateExpenseResponseDTO generateExpenseResponseDTO = new GenerateExpenseResponseDTO();
        Expense expense;
        try {
            expense = expenseService.generateExpense(generateExpenseRequestDTO.getGeneratedByUserId(),
                    generateExpenseRequestDTO.getExpenseShareForTargetUsers(),
                    generateExpenseRequestDTO.getGroupId());
            generateExpenseResponseDTO.setExpense(expense);
        }
        catch(UserCannotBeFoundException | GroupCannotBeFoundException e) {
            generateExpenseResponseDTO.setExpenseGenerationStatus(ExpenseGenerationStatus.FAILED);
            System.out.println("Expense has not been generated.");
        }
        generateExpenseResponseDTO.setExpenseGenerationStatus(ExpenseGenerationStatus.SUCCESSFUL);
        return generateExpenseResponseDTO;
    }
}
