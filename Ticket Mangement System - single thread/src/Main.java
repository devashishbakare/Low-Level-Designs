import java.util.*;
public class Main {
    public static void main(String[] args) {
        TicketManagementSystem ticketManagementSystem = new TicketManagementSystem();
        List<String> issueTypes = Arrays.asList(
                "wrong product received",
                "order delayed",
                "cancel delivery",
                "damaged product received");
        ticketManagementSystem.init(issueTypes);

        ticketManagementSystem.addAgent("A-0", Arrays.asList(0, 1, 3));
        ticketManagementSystem.addAgent("A-1", Arrays.asList(1, 2, 3));
        ticketManagementSystem.addAgent("A-2", Arrays.asList(1, 3));

        System.out.println(ticketManagementSystem.createIssue("I-0", "Order-0", 3, "sample issue description : damaged product received"));
        System.out.println(ticketManagementSystem.assignIssue("I-0", 1));

        System.out.println(ticketManagementSystem.createIssue("I-1", "Order-1", 1, "sample issue description : order delayed"));
        System.out.println(ticketManagementSystem.assignIssue("I-1", 1));

        System.out.println(ticketManagementSystem.createIssue("I-2", "Order-2", 1, "sample issue description : order delayed"));
        System.out.println(ticketManagementSystem.assignIssue("I-2", 0));

        System.out.println(ticketManagementSystem.createIssue("I-3", "Order-3", 2, "sample issue description : order delayed"));
        System.out.println(ticketManagementSystem.assignIssue("I-3", 2));

        ticketManagementSystem.resolveIssue("I-3", "RESOLVED");

        List<String> store = ticketManagementSystem.getAgentHistory("A-1");
        for(String str : store) System.out.print(str + ", ");
        System.out.println();

        System.out.println(ticketManagementSystem.createIssue("I-4", "Order-4", 3, "sample issue description : order delayed"));
        System.out.println(ticketManagementSystem.assignIssue("I-4", 2));

        System.out.println(ticketManagementSystem.createIssue("I-5", "Order-5", 1, "sample issue description : order delayed"));
        System.out.println(ticketManagementSystem.assignIssue("I-5", 0));

        ticketManagementSystem.resolveIssue("I-1", "RESOLVED");
        store = ticketManagementSystem.getAgentHistory("A-2");
        for(String str : store) System.out.print(str + ", ");
        System.out.println();
    }
}