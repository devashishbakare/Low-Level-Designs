public class ParkingDetails {
    public int vehicleType;
    public String vehicleNumber;
    public String ticketId;
    public int parkingStrategy;

    public ParkingDetails(int vehicleType, String vehicleNumber, String ticketId, int parkingStrategy) {
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
        this.ticketId = ticketId;
        this.parkingStrategy = parkingStrategy;
    }
}
