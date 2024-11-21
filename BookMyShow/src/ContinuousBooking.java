public class ContinuousBooking extends BookingMethod{
    @Override
    public String[] bookTicket(String ticketId, Show show, int ticketCount) {

        int rowSize = show.seats.length;
        int colSize = show.seats[0].length;
        int endColumnNumber = -1;
        int bookingRow = -1;

        for(int row = 0; row < rowSize; row++){
            int freeSeatCount = 0;
            for(int col = 0; col < colSize; col++){
                if(show.seats[row][col] == 0){
                    freeSeatCount++;
                }else{
                    freeSeatCount = 0;
                }
                if(freeSeatCount == ticketCount){
                    bookingRow = row;
                    endColumnNumber = col;
                    break;
                }
            }
            if(bookingRow != -1) break;

        }

        if(bookingRow == -1 && bookingMethod != null){
            bookingMethod.bookTicket(ticketId,show,ticketCount);
        }else{
            int startSeat = endColumnNumber + 1 - ticketCount;
            int seatIndex = 0;
            String selectedSeats[] = new String[ticketCount];
            while(startSeat <= endColumnNumber){
                show.seats[bookingRow][startSeat] = 1;
                String seatNo = bookingRow + "-" + startSeat;
                selectedSeats[seatIndex++] = seatNo;
                startSeat++;
            }
            return selectedSeats;
        }

        return new String[0];
    }
}
