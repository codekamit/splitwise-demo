package com.scaler.splitwise.DTOs;

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
