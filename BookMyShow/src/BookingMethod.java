abstract public class BookingMethod {
    BookingMethod bookingMethod;
    public void setNextBookingMethod(BookingMethod bookingMethod){
        this.bookingMethod = bookingMethod;
    }

    public abstract String[] bookTicket(String ticketId, Show show, int ticketCount);
}
