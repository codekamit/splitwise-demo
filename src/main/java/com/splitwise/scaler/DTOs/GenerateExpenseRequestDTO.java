package com.splitwise.scaler.DTOs;

import com.splitwise.scaler.models.ExpenseShare;
import com.splitwise.scaler.models.Group;
import com.splitwise.scaler.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GenerateExpenseRequestDTO {
    private Long generatedByUserId;
    private double amount;
    private List<Share> expenseShareForTargetUsers;
    private Long groupId;
}
