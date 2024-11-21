class ParkingResult {
    int status;
    String spotId;
    String vehicleNumber;
    String ticketId;

    public ParkingResult(int status, String spotId, String vehicleNumber, String ticketId) {
        this.status = status;
        this.spotId = spotId;
        this.vehicleNumber = vehicleNumber;
        this.ticketId = ticketId;
    }
}