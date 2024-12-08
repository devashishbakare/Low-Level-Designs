import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        InventoryManagementSystem inventoryManagementSystem = new InventoryManagementSystem();

        // Create a thread pool with 4 threads
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        executorService.submit(() -> {
            inventoryManagementSystem.createSeller("seller-0", Arrays.asList("110001", "560092", "452001", "700001"), Arrays.asList("netbanking", "cash", "upi"));
            inventoryManagementSystem.createSeller("seller-1", Arrays.asList("400050", "110001", "600032", "560092"), Arrays.asList("netbanking", "cash", "upi"));
        });

        executorService.submit(() -> {
            System.out.println(inventoryManagementSystem.addInventory(0, "seller-1", 52));
            System.out.println(inventoryManagementSystem.addInventory(0, "seller-0", 32));
        });

        executorService.submit(() -> {
            System.out.println(inventoryManagementSystem.createOrder("order-1", "400050", "seller-1", 0, 5, "upi"));
            System.out.println(inventoryManagementSystem.getInventory(0, "seller-1"));
        });

        executorService.submit(() -> {
            System.out.println(inventoryManagementSystem.createOrder("order-2", "560092", "seller-0", 0, 1, "upi"));
            System.out.println(inventoryManagementSystem.getInventory(0, "seller-0"));
        });

        // Shutdown the executor service
        executorService.shutdown();
    }
}