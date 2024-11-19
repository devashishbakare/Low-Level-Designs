import java.util.*;

public class ParkingStrategy1 implements ParkingStrategy{

    @Override
    public int[] getParkingSpot(int vehicleType, ParkingBlock parking[][][]) {

        int floorCount = parking.length;
        int rowCount = parking[0].length;
        int colCount = parking[0][0].length;
        int[][] storeFreeParkingSpotsDetails = new int[floorCount][2];
        for(int floor = 0; floor < floorCount; floor++){
            ParkingBlock floorParking[][] = parking[floor];
            int freeSpot = 0;
            for(int row = 0; row < rowCount; row++){
                for(int col = 0; col < colCount; col++){
                    if(floorParking[row][col].vehicleType == vehicleType && floorParking[row][col].free == true){
                        freeSpot++;
                    }
                }
            }
            storeFreeParkingSpotsDetails[floor] = new int[]{floor, freeSpot};
        }

        Arrays.sort(storeFreeParkingSpotsDetails, (a, b) -> {
           if(a[1] == b[1]){
               return a[0]-b[0];
           }
           return b[1]-a[1];
        });



        int floorFreeSpotDetails[] = storeFreeParkingSpotsDetails[0];
        int floorNo = floorFreeSpotDetails[0];
        int floorFreeSpotCount = floorFreeSpotDetails[1];
        if(floorFreeSpotCount == 0) return new int[]{-1};

        ParkingBlock floorParking[][] = parking[floorNo];
        for(int row = 0; row < floorParking.length; row++){
            for(int col = 0; col < floorParking[0].length; col++){
                if(floorParking[row][col].vehicleType == vehicleType && floorParking[row][col].free == true){
                    return new int[]{floorNo, row, col};
                }
            }
        }
        return new int[]{-1};
    }
}
