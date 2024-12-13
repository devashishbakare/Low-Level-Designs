package Expense;
import Split.Split;
import User.User;
import Split.SplitType;
import Utils.ExpenseIdGenerator;
import Exception.*;

import java.util.*;
public class ExpenseService {
    private static ExpenseService expenseService = null;
    private final Map<String, Expense> expenseIdToExpenseMapper = new HashMap<>();

    private ExpenseService(){

    }

    public static ExpenseService createInstance(){
        if(expenseService == null){
            expenseService = new ExpenseService();
        }
        return expenseService;
    }
    //here : 1500 devashish(created), devashish(paid), for food, 3(total), equal split, List<User>(vaibhav, devashish, shubham)
    public String addExpense(double amountPaid, User createdBy, User paidBy, String description, int totalUser, ExpenseType expenseType, List<Split> splitList) throws InvalidSplit, IllegalExpenseType {

        if(expenseType == ExpenseType.EQUAL){
        String expenseId = ExpenseIdGenerator.getNewExpenseId();
        Expense expense = new EqualExpanses(expenseId, amountPaid, createdBy, paidBy, description);
        if(expense.validateSplit(splitList, amountPaid)){
            paidBy.addBalance(-amountPaid);
            for(Split userSplit : splitList){
                User user = userSplit.getUser();
                user.addBalance(userSplit.getAmount());
                user.addToExpenseList(expense);
            }
            expenseIdToExpenseMapper.put(expenseId, expense);
            return expenseId;
        }else {
            throw new InvalidSplit("Invalid Split Between Members");
        }
        }else if(expenseType == ExpenseType.EXACT){
            String expenseId = ExpenseIdGenerator.getNewExpenseId();
            Expense expense = new ExactExpanses(expenseId, amountPaid, createdBy, paidBy, description);
            if(expense.validateSplit(splitList, amountPaid)){
                paidBy.addBalance(-amountPaid);
                for(Split userInfo : splitList){
                    User user = userInfo.getUser();
                    user.addBalance(userInfo.getAmount());
                    user.addToExpenseList(expense);
                }
                expenseIdToExpenseMapper.put(expenseId, expense);
                return expenseId;
            }else{
                throw new InvalidSplit("Invalid Split Between Members");
            }

        }else if(expenseType == ExpenseType.PERCENT){
            String expenseId = ExpenseIdGenerator.getNewExpenseId();
            Expense expense = new PercentageExpanses(expenseId, amountPaid, createdBy, paidBy, description);
            if(expense.validateSplit(splitList, amountPaid)){
                paidBy.addBalance(-amountPaid);
                for(Split splitInfo : splitList){
                    User user = splitInfo.getUser();
                    double share = splitInfo.getShare();
                    double perShareAmount = (splitInfo.getAmount() * share / 100);
                    user.addBalance(perShareAmount);
                    user.addToExpenseList(expense);
                }
                expenseIdToExpenseMapper.put(expenseId, expense);
                return expenseId;
            }else{
                throw new InvalidSplit("Invalid Split Between Members");
            }
        }else{
            throw new IllegalExpenseType("Invalid Expense Type");
        }
    }

}
