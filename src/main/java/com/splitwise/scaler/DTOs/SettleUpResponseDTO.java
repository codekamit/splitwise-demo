package com.splitwise.scaler.DTOs;

import com.splitwise.scaler.models.Expense;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SettleUpResponseDTO {
    private List<Expense> expenseList;
    private ResponseStatus responseStatus;
}
