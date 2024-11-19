public class ParkingStrategy0 implements ParkingStrategy{

    @Override
    public int[] getParkingSpot(int vehicleType, ParkingBlock parking[][][]) {
        int floorCount = parking.length;
        int rowCount = parking[0].length;
        int colCount = parking[0][0].length;
        for(int floor = 0; floor < floorCount; floor++){
            ParkingBlock floorParking[][] = parking[floor];
            for(int row = 0; row < rowCount; row++){
                for(int col = 0; col < colCount; col++){
                    if(floorParking[row][col].vehicleType == vehicleType && floorParking[row][col].free == true){
                        return new int[]{floor, row, col};
                    }
                }
            }
        }
        return new int[]{-1};
    }
}
