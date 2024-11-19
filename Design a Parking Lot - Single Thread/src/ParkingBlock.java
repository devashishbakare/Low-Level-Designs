public class ParkingBlock {
    public int vehicleType;
    public boolean free;
    public ParkingDetails parkingDetails;

    public ParkingBlock(int vehicleType, boolean free, ParkingDetails parkingDetails) {
        this.vehicleType = vehicleType;
        this.free = free;
        this.parkingDetails = parkingDetails;
    }
}
