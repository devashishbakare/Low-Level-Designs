import java.util.*;

import Expense.Expense;
import Expense.ExpenseService;
import Expense.ExpenseType;
import Group.Group;
import Group.GroupService;
import Split.*;
import Split.Split;
import User.User;
import User.UserService;
import Split.SplitType;
import Exception.*;

public class Main {
    public static void main(String[] args) throws InvalidSplit, GroupNotFound, IllegalExpenseType {

        UserService userService = UserService.getInstance();

        User devashish = userService.createUser("devashish", "devashish bakare");
        User shubham = userService.createUser("shubham", "shubham khilari");
        User vaibhav = userService.createUser("vaibhav", "vaibhav Gaikwad");

        GroupService groupService = GroupService.getInstance();

        Group goaGroup =  groupService.createGroup("Goa Trip", "group1", "Goa Trip", devashish);

        System.out.println(groupService.addMemberToGroup(goaGroup.getGroupId(), shubham));
        System.out.println(groupService.addMemberToGroup(goaGroup.getGroupId(), vaibhav));

        //create expenses and split here..
        //here : 1500 devashish(created), devashish(paid), for food, 3(total), equal split, List<User>(vaibhav, devashish, shubham)
        ExpenseService expenseService = ExpenseService.createInstance();

        Split devashishSplit = new EqualSplit(devashish, 500);
        Split vaibhavSplit = new EqualSplit(vaibhav, 500);
        Split shubhamSplit = new EqualSplit(shubham, 500);
        System.out.println(expenseService.addExpense(1500, devashish, devashish, "Food", 3, ExpenseType.EQUAL, Arrays.asList(devashishSplit, vaibhavSplit, shubhamSplit)));
        String u1 = devashish.toString();
        String u2 = vaibhav.toString();
        String u3 = shubham.toString();

        System.out.println(u1 + " " + u2 +  " " + u3);

        ///////////////////////////////////////////////////////

        devashishSplit = new ExactSplit(devashish, 500);
        vaibhavSplit = new ExactSplit(vaibhav, 500);
        shubhamSplit = new ExactSplit(shubham, 500);
        System.out.println(expenseService.addExpense(1500, shubham, shubham, "petrol", 3, ExpenseType.EXACT, Arrays.asList(devashishSplit, vaibhavSplit, shubhamSplit)));
        u1 = devashish.toString();
        u2 = vaibhav.toString();
        u3 = shubham.toString();

        System.out.println(u1 + " " + u2 +  " " + u3);

        ///////////////////////////////////////////////////////

        devashishSplit = new PercentageSplit(devashish, 1500, 33.33);
        vaibhavSplit = new PercentageSplit(vaibhav, 1500, 33.33);
        shubhamSplit = new PercentageSplit(shubham, 1500, 33.34);
        System.out.println(expenseService.addExpense(1500, vaibhav, vaibhav, "petrol", 3, ExpenseType.PERCENT, Arrays.asList(devashishSplit, vaibhavSplit, shubhamSplit)));
        u1 = devashish.toString();
        u2 = vaibhav.toString();
        u3 = shubham.toString();
        System.out.println(u1 + " " + u2 +  " " + u3);

    }
}