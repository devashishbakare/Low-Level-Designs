package Expense;
import Split.Split;
import User.User;

import java.util.List;

public class PercentageExpanses extends Expense{

    public PercentageExpanses(String expenseId, double amount, User createdBy, User payer, String description) {
        super(expenseId, amount, createdBy, payer, description, ExpenseType.PERCENT);
    }

    @Override
    public void validateExpenses() {

    }

    @Override
    public boolean validateSplit(List<Split> splitList, double amount) {
        double totalAmount = 0;
        for(Split split : splitList){
            double per = split.getShare();
            double perAmount = (split.getAmount() * per / 100);
            totalAmount += perAmount;
        }
        return totalAmount == amount;
    }
}
