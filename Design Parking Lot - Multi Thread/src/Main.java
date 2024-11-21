import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        // Parking configuration
        String[][][] parkingConfig = {
                {
                        {"4-1", "4-1", "2-1", "2-0"},
                        {"2-1", "4-1", "2-1", "2-1"},
                        {"4-0", "2-1", "4-0", "2-1"},
                        {"4-1", "4-1", "4-1", "2-1"}
                }
        };

        // Initialize parking lot
        ParkingLot parkingLot = new ParkingLot(parkingConfig);

        // Create a thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // Simulate multiple threads parking vehicles
        executorService.submit(() -> {
            ParkingResult result = parkingLot.park(4, "BH123", "TKT123");
            System.out.println("Park Result: " + result.status + ", Spot: " + result.spotId);
        });

        executorService.submit(() -> {
            ParkingResult result = parkingLot.park(2, "DL456", "TKT456");
            System.out.println("Park Result: " + result.status + ", Spot: " + result.spotId);
        });

        // Simulate removing a vehicle
        executorService.submit(() -> {
            int status = parkingLot.removeVehicle("", "BH123", "");
            System.out.println("Remove Vehicle Result: " + (status == 201 ? "Success" : "Failure"));
        });

        // Check free spots count
        executorService.submit(() -> {
            int freeSpots = parkingLot.getFreeSpotsCount(0, 4);
            System.out.println("Free Spots for 4-Wheeler: " + freeSpots);
        });

        // Shut down the executor service
        executorService.shutdown();
    }
}
