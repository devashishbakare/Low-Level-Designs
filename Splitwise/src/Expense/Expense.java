package Expense;
import java.util.*;
import Split.Split;
import User.User;

public abstract class Expense {
    private String expenseId;
    private double amount;
    private User createdBy;
    private User payer;
    private String description;
    private ExpenseType expenseType;
    private List<Split> userMoneySplit;

    public Expense(String expenseId, double amount, User createdBy, User payer, String description, ExpenseType expenseType) {
        this.expenseId = expenseId;
        this.amount = amount;
        this.createdBy = createdBy;
        this.payer = payer;
        this.description = description;
        this.expenseType = expenseType;
        this.userMoneySplit = new ArrayList<>();
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getPayer() {
        return payer;
    }

    public void setPayer(User payer) {
        this.payer = payer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }

    public abstract void validateExpenses();
    public abstract boolean validateSplit(List<Split> splitList, double amount);
}
