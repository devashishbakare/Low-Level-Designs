package User;
import Expense.Expense;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String userId;
    private double balance;
    private List<Expense> expenseList;

    public User(String name, String userId) {
        this.name = name;
        this.userId = userId;
        this.balance = 0;
        expenseList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addToExpenseList(Expense expense){
        this.expenseList.add(expense);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", userId='" + userId + '\'' +
                ", balance=" + balance +
                ", expenseList=" + expenseList +
                '}';
    }

    public void addBalance(double amount){
        this.balance += amount;
    }
    public void getExpenseList() {
        for(Expense expense : expenseList) {
            expense.toString();
        }
    }
}

