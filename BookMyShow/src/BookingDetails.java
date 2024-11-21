public class BookingDetails {
    public String ticketId;
    public Show show;
    public String[] seatsDetails;

    public BookingDetails(String ticketId, Show show, String[] seatsDetails) {
        this.ticketId = ticketId;
        this.show = show;
        this.seatsDetails = seatsDetails;
    }
}
