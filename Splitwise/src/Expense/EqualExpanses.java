package Expense;
import java.util.*;
import Split.Split;
import User.User;

public class EqualExpanses extends Expense{

    public EqualExpanses(String expenseId, double amount, User createdBy, User payer, String description) {
        super(expenseId, amount, createdBy, payer, description, ExpenseType.EQUAL);
    }

    @Override
    public void validateExpenses() {

    }

    @Override
    public boolean validateSplit(List<Split> splitList, double amount) {
        double totalAmount = 0;
        for(Split split : splitList){
            totalAmount += split.getAmount();
        }
        return totalAmount == amount;
    }
}


