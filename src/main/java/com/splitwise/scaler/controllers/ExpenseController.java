package com.splitwise.scaler.controllers;

import com.splitwise.scaler.DTOs.ExpenseGenerationStatus;
import com.splitwise.scaler.DTOs.GenerateExpenseRequestDTO;
import com.splitwise.scaler.DTOs.GenerateExpenseResponseDTO;
import com.splitwise.scaler.DTOs.Share;
import com.splitwise.scaler.exceptions.GroupCannotBeFoundException;
import com.splitwise.scaler.exceptions.UserCannotBeFoundException;
import com.splitwise.scaler.models.Expense;
import com.splitwise.scaler.models.ExpenseShare;
import com.splitwise.scaler.repositories.UserRepository;
import com.splitwise.scaler.services.ExpenseService;
import com.splitwise.scaler.services.UserService;

import java.util.ArrayList;
import java.util.List;

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
