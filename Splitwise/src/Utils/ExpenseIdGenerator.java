package Utils;

public class ExpenseIdGenerator {
    private static long expenseId = 0;
    private ExpenseIdGenerator(){};
    public static String getNewExpenseId(){
        expenseId++;
        return "EXPENSE"+expenseId;
    }
}
