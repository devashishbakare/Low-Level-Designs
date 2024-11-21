import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.*;

public class ParkingLot {
    private final String[][][] parking;
    private final ConcurrentHashMap<String, String> vehicleToSpotMap; // vehicleNumber -> spotId
    private final ConcurrentHashMap<String, String> ticketToSpotMap; // ticketId -> spotId
    private final ConcurrentHashMap<String, ParkingResult> parkingHistory; // spotId -> ParkingResult
    private final AtomicInteger[][] freeSpots2Wheeler; // Tracks free spots per floor for 2-wheelers
    private final AtomicInteger[][] freeSpots4Wheeler; // Tracks free spots per floor for 4-wheelers
    private final Object lock = new Object(); // Lock for synchronization

    public ParkingLot(String[][][] parking) {
        this.parking = parking;
        this.vehicleToSpotMap = new ConcurrentHashMap<>();
        this.ticketToSpotMap = new ConcurrentHashMap<>();
        this.parkingHistory = new ConcurrentHashMap<>();
        int floors = parking.length;
        this.freeSpots2Wheeler = new AtomicInteger[floors][];
        this.freeSpots4Wheeler = new AtomicInteger[floors][];
        initializeFreeSpots();
    }

    private void initializeFreeSpots() {
        for (int floor = 0; floor < parking.length; floor++) {
            int rows = parking[floor].length;
            freeSpots2Wheeler[floor] = new AtomicInteger[rows];
            freeSpots4Wheeler[floor] = new AtomicInteger[rows];
            for (int row = 0; row < rows; row++) {
                freeSpots2Wheeler[floor][row] = new AtomicInteger(0);
                freeSpots4Wheeler[floor][row] = new AtomicInteger(0);
                for (String spot : parking[floor][row]) {
                    if (spot.startsWith("2-1")) {
                        freeSpots2Wheeler[floor][row].incrementAndGet();
                    } else if (spot.startsWith("4-1")) {
                        freeSpots4Wheeler[floor][row].incrementAndGet();
                    }
                }
            }
        }
    }

    public ParkingResult park(int vehicleType, String vehicleNumber, String ticketId) {
        synchronized (lock) {
            for (int floor = 0; floor < parking.length; floor++) {
                for (int row = 0; row < parking[floor].length; row++) {
                    for (int col = 0; col < parking[floor][row].length; col++) {
                        String spot = parking[floor][row][col];
                        if (isSpotAvailable(spot, vehicleType)) {
                            String spotId = floor + "-" + row + "-" + col;
                            parking[floor][row][col] = vehicleType + "-0"; // Mark as occupied
                            vehicleToSpotMap.put(vehicleNumber, spotId);
                            ticketToSpotMap.put(ticketId, spotId);
                            decrementFreeSpots(floor, row, vehicleType);
                            ParkingResult result = new ParkingResult(201, spotId, vehicleNumber, ticketId);
                            parkingHistory.put(spotId, result);
                            return result;
                        }
                    }
                }
            }
        }
        return new ParkingResult(404, "", vehicleNumber, ticketId); // No spot available
    }

    public int removeVehicle(String spotId, String vehicleNumber, String ticketId) {
        synchronized (lock) {
            String resolvedSpotId = resolveSpotId(spotId, vehicleNumber, ticketId);
            if (resolvedSpotId == null) {
                return 404; // Vehicle not found
            }
            String[] parts = resolvedSpotId.split("-");
            int floor = Integer.parseInt(parts[0]);
            int row = Integer.parseInt(parts[1]);
            int col = Integer.parseInt(parts[2]);
            parking[floor][row][col] = parkingHistory.get(resolvedSpotId).vehicleNumber.startsWith("2") ? "2-1" : "4-1";
            vehicleToSpotMap.remove(vehicleNumber);
            ticketToSpotMap.remove(ticketId);
            incrementFreeSpots(floor, row, parking[floor][row][col].startsWith("2") ? 2 : 4);
            return 201; // Success
        }
    }

    private String resolveSpotId(String spotId, String vehicleNumber, String ticketId) {
        if (!spotId.isEmpty()) return spotId;
        if (!vehicleNumber.isEmpty() && vehicleToSpotMap.containsKey(vehicleNumber)) return vehicleToSpotMap.get(vehicleNumber);
        if (!ticketId.isEmpty() && ticketToSpotMap.containsKey(ticketId)) return ticketToSpotMap.get(ticketId);
        return null;
    }

    private void decrementFreeSpots(int floor, int row, int vehicleType) {
        if (vehicleType == 2) {
            freeSpots2Wheeler[floor][row].decrementAndGet();
        } else if (vehicleType == 4) {
            freeSpots4Wheeler[floor][row].decrementAndGet();
        }
    }

    private void incrementFreeSpots(int floor, int row, int vehicleType) {
        if (vehicleType == 2) {
            freeSpots2Wheeler[floor][row].incrementAndGet();
        } else if (vehicleType == 4) {
            freeSpots4Wheeler[floor][row].incrementAndGet();
        }
    }

    private boolean isSpotAvailable(String spot, int vehicleType) {
        return spot.startsWith(vehicleType + "-1");
    }

    public int getFreeSpotsCount(int floor, int vehicleType) {
        AtomicInteger count = new AtomicInteger(0);
        for (int row = 0; row < parking[floor].length; row++) {
            count.addAndGet(vehicleType == 2 ? freeSpots2Wheeler[floor][row].get() : freeSpots4Wheeler[floor][row].get());
        }
        return count.get();
    }
}