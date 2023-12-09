package com.splitwise.scaler.services;

import com.splitwise.scaler.DTOs.Share;
import com.splitwise.scaler.exceptions.GroupCannotBeFoundException;
import com.splitwise.scaler.exceptions.UserCannotBeFoundException;
import com.splitwise.scaler.models_myself.Expense;
import com.splitwise.scaler.models_myself.ExpenseShare;
import com.splitwise.scaler.models_myself.Group;
import com.splitwise.scaler.models_myself.User;
import com.splitwise.scaler.repositories.GroupRepository;
import com.splitwise.scaler.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    private UserRepository userRepository;
    private GroupRepository groupRepository;
    public Expense generateExpense(Long createdBy, List<Share> shareForTargetUsers, Long groupId) throws UserCannotBeFoundException, GroupCannotBeFoundException {
        Expense expense = new Expense();
        //Get User
        Optional<User> expenseGeneratedByOptional = userRepository.findById(createdBy);
        if(expenseGeneratedByOptional.isEmpty()) {
            throw new UserCannotBeFoundException();
        }
        User expenseGeneratedBy = expenseGeneratedByOptional.get();
        //Get Group
        Optional<Group> groupOptional = groupRepository.findById(groupId);
        if(groupOptional.isEmpty()) {
            throw new GroupCannotBeFoundException();
        }
        Group group = groupOptional.get();
        List<ExpenseShare> expenseShareForTargetUsers = new ArrayList<>();
        for(Share individualShare : shareForTargetUsers) {
            ExpenseShare individualExpenseShare = new ExpenseShare();
            Optional<User> targetUserOptional = userRepository.findById(individualShare.getUserId());
            if(targetUserOptional.isEmpty()) {
                throw new UserCannotBeFoundException();
            }
            User targetUser = targetUserOptional.get();
            individualExpenseShare.setTargetUser(targetUser);
            individualExpenseShare.setAmountToPay(individualShare.getAmount());
            individualExpenseShare.setExpense(expense);
            expenseShareForTargetUsers.add(individualExpenseShare);
        }
        expense.setExpenseShareForTargetUsers(expenseShareForTargetUsers);
        expense.setExpenseGeneratedBy(expenseGeneratedBy);
        expense.setPartOfGroup(group);
        return expense;
    }
}
