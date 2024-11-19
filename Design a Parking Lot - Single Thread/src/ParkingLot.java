import java.util.*;
public class ParkingLot {
    public ParkingBlock parking[][][];
    private Map<String, String> ticketToSpotMapper;
    private Map<String, String> vehicleNumberToSpotMapper;
    public void init(int parking[][][]){
        int floorCount = parking.length;
        int rowCount = parking[0].length;
        int colCount = parking[0][0].length;
        this.parking = new ParkingBlock[floorCount][rowCount][colCount];
        for(int floor = 0; floor < floorCount; floor++){
            int floorParking[][] = parking[floor];
            for(int row = 0; row < rowCount; row++){
                for(int col = 0; col < colCount; col++){
                    this.parking[floor][row][col] = new ParkingBlock(floorParking[row][col], true, null);
                }
            }
        }

        ticketToSpotMapper = new HashMap<>();
        vehicleNumberToSpotMapper = new HashMap<>();

    }

    public String park(int vehicleType, String vehicleNumber, String ticketId, int parkingStrategy){

        ParkingStrategy strategy = (parkingStrategy == 0 ? new ParkingStrategy0() : new ParkingStrategy1());
        int freeParkingSpot[] = strategy.getParkingSpot(vehicleType, parking);
        if(freeParkingSpot.length == 1) return "";
        int floorNo = freeParkingSpot[0];
        int row = freeParkingSpot[1];
        int col = freeParkingSpot[2];
        ParkingDetails parkingDetails = new ParkingDetails(vehicleType, vehicleNumber, ticketId, parkingStrategy);
        parking[floorNo][row][col] = new ParkingBlock(vehicleType, false, parkingDetails);
        Map<String, ParkingDetails> logger = Logs.createInstance();
        logger.put("Vehicle Parked", parkingDetails);
        String spotId = floorNo + "-" + row + "-" + col;

        ticketToSpotMapper.put(ticketId, spotId);
        vehicleNumberToSpotMapper.put(vehicleNumber, spotId);
        return spotId;
    }

    public boolean removeVehicle(String spotId){
        String parkingDetails[] = spotId.split("-");

        int floor = Integer.parseInt(parkingDetails[0]);
        int row = Integer.parseInt(parkingDetails[1]);
        int col = Integer.parseInt(parkingDetails[2]);

        int floorCount = parking.length;
        int rowCount = parking[floor].length;
        int colLCount = parking[floor][row].length;

        if(floor >= floorCount || row >= rowCount || col >= colLCount) return false;

        ParkingDetails oldParkingDetails = parking[floor][row][col].parkingDetails;

        if(parking[floor][row][col].free == true) return false;

        parking[floor][row][col].free = true;
        parking[floor][row][col].parkingDetails = null;

        ticketToSpotMapper.values().remove(spotId);
        vehicleNumberToSpotMapper.values().remove(spotId);

        Map<String, ParkingDetails> logger = Logs.createInstance();
        logger.put("Vehicle Un-Park", oldParkingDetails);
        return true;
    }

    public String searchVehicle(String query){
        if(vehicleNumberToSpotMapper.containsKey(query)){
            return vehicleNumberToSpotMapper.get(query);
        }
        if(ticketToSpotMapper.containsKey(query)){
            return ticketToSpotMapper.get(query);
        }
        return "";
    }

    public int getFreeSpotCount(int floor, int vehicleType){
        ParkingBlock floorParking[][] = parking[floor];
        int freeSpotCount = 0;
        for(int row = 0; row < floorParking.length; row++){
            for(int col = 0; col < floorParking[0].length; col++){
                if(floorParking[row][col].vehicleType == vehicleType && floorParking[row][col].free == true){
                    freeSpotCount++;
                }
            }
        }
        return freeSpotCount;
    }


}
