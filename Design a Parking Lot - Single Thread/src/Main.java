import java.util.*;
public class Main {
    public static void main(String[] args) {

        int parking[][][] = {
                    {
                            {4, 4, 2, 2},
                            {2, 4, 2, 0},
                            {0, 2, 2, 2},
                            {4, 4, 4, 0}
                    }
                };
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.init(parking);

        String spotId = parkingLot.park(2, "bh234", "tkt4534", 1);
        System.out.println(spotId);

        String spotIdWithVehicleNumber = parkingLot.searchVehicle("bh234");
        System.out.println("search with vehicleNumber : " +spotIdWithVehicleNumber);

        String spotIdWithTicketNumber = parkingLot.searchVehicle("tkt4534");
        System.out.println("Search with ticket number: " +spotIdWithTicketNumber);

        int freeSpotCount1 = parkingLot.getFreeSpotCount(0, 2);
        System.out.println(freeSpotCount1);

        boolean isRemoved = parkingLot.removeVehicle("0-0-2");
        System.out.println(isRemoved);

        int freeSpotCount2 = parkingLot.getFreeSpotCount(0, 2);
        System.out.println(freeSpotCount2);

        Map<String, ParkingDetails> map = Logs.createInstance();
        for(String history : map.keySet()){
            System.out.print(history + " ");
            System.out.println(map.get(history).vehicleType + " " + map.get(history).vehicleNumber + " " + map.get(history).ticketId + " " + map.get(history).parkingStrategy);
        }
    }
}