package Expense;
import Split.Split;
import User.User;

import java.util.List;

public class ExactExpanses extends Expense{

    public ExactExpanses(String expenseId, double amount, User createdBy, User payer, String description) {
        super(expenseId, amount, createdBy, payer, description, ExpenseType.EXACT);
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
        return amount == totalAmount;
    }
}
