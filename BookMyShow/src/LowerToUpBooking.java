public class LowerToUpBooking  extends BookingMethod{
    @Override
    public String[] bookTicket(String ticketId, Show show, int ticketCount) {

        String bookingResult[] = new String[ticketCount];
        int bookingResultIndex = 0;
        int bookingCount = 0;
        int rowSize = show.seats.length;
        int colSize = show.seats[0].length;

        for(int row = 0; row < rowSize; row++){
            for(int col = 0; col < colSize; col++){
                if(show.seats[row][col] == 0){
                    bookingCount++;
                    bookingResult[bookingResultIndex++] = row + "-" + col;
                }
                if(bookingCount == ticketCount) break;
            }
            if(bookingCount == ticketCount) break;
        }

        if(bookingCount == ticketCount){

            for(String bookSeat : bookingResult){
                String seatInfo[] = bookSeat.split("-");
                int row = Integer.parseInt(seatInfo[0]);
                int col = Integer.parseInt(seatInfo[1]);
                show.seats[row][col] = 1;
            }

            return bookingResult;
        }
        return new String[0];
    }
}
