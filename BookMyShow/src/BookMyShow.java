
import java.util.*;
public class BookMyShow {

    public Map<Integer, Cinema> cinemaIdToCinemaMapper;
    public Map<Integer, Show> showIdToShowMapper;
    public Map<String, BookingDetails> ticketToTicketDetailsMapper;
    public Map<Integer, List<Cinema>> cityIdToCinemaMapper;

    public BookMyShow(){
        cinemaIdToCinemaMapper = new HashMap<>();
        ticketToTicketDetailsMapper = new HashMap<>();
        showIdToShowMapper = new HashMap<>();
        cityIdToCinemaMapper = new HashMap<>();
    }
    public void addCinema(int cinemaId, int cityId, int screenCount, int screenRow, int screenColumn){
        if(cinemaIdToCinemaMapper.containsKey(cinemaId)) return;
        Cinema cinema = new Cinema(cinemaId, cityId, screenCount, screenRow, screenColumn);
        cinemaIdToCinemaMapper.put(cinemaId, cinema);
        cityIdToCinemaMapper.computeIfAbsent(cityId, v -> new ArrayList<>()).add(cinema);
    }

    public void addShow(int showId, int movieId, int cinemaId, int screenIndex, long startTime, long endTime){
        if(cinemaIdToCinemaMapper.containsKey(cinemaId) == false) return;
        Cinema cinema = cinemaIdToCinemaMapper.get(cinemaId);
        Show show = new Show(showId, movieId, cinemaId, screenIndex, startTime, endTime, cinema.screenRow, cinema.screenColumn);
        Screen screen = cinema.cinemaScreen.get(screenIndex);
        screen.addShow(show);
        showIdToShowMapper.put(showId, show);
    }

    public String[] bookTicket(String ticketId, int showId, int ticketsCount){

        BookingMethod continuousBooking = new ContinuousBooking();
        BookingMethod lowerToUpBooking = new LowerToUpBooking();
        continuousBooking.setNextBookingMethod(lowerToUpBooking);
        if(showIdToShowMapper.containsKey(showId) == false) return new String[0];

        Show show = showIdToShowMapper.get(showId);
        String bookedTickets[] = continuousBooking.bookTicket(ticketId, show, ticketsCount);

        if(bookedTickets.length == 0){
            return new String[0];
        }

        show.bookSeatCount += ticketsCount;
        BookingDetails bookingDetails = new BookingDetails(ticketId, show, bookedTickets);
        ticketToTicketDetailsMapper.put(ticketId, bookingDetails);
        return bookedTickets;
    }

    public boolean cancelTicket(String ticketId){

        if(ticketToTicketDetailsMapper.containsKey(ticketId) == false) return false;
        BookingDetails bookingDetails = ticketToTicketDetailsMapper.get(ticketId);
        Show show = bookingDetails.show;

        String bookedSeats[] = bookingDetails.seatsDetails;
        for(String bookSeat : bookedSeats){
            String seatInfo[] = bookSeat.split("-");
            int row = Integer.parseInt(seatInfo[0]);
            int col = Integer.parseInt(seatInfo[1]);
            show.seats[row][col] = 0;
        }

        show.bookSeatCount -= bookedSeats.length;
        ticketToTicketDetailsMapper.remove(ticketId);
        return true;
    }

    public int getFreeSeatsCount(int showId){
        if(showIdToShowMapper.containsKey(showId) == false){
            System.out.println("show did not exist");
            return 0;
        }
        Show show = showIdToShowMapper.get(showId);
        int totalSeats = show.seats.length * show.seats[0].length;
        return totalSeats - show.bookSeatCount;
    }

    public int[] listCinemas(int movieId, int cityId){
        List<Integer> storeCinemaId = new ArrayList<>();
        if(cinemaIdToCinemaMapper.containsKey(cityId) == false) return new int[0];
        List<Cinema> cinemaInCity = cityIdToCinemaMapper.get(cityId);
        for(Cinema cinema : cinemaInCity){
            List<Screen> screenInCinema = cinema.cinemaScreen;
            for(Screen screen : screenInCinema){
                List<Show> showInScreen = screen.shows;
                for(Show show : showInScreen){
                    if(show.movieId == movieId){
                        storeCinemaId.add(cinema.cinemaId);
                    }
                }
            }
        }

        int cinemaIds[] = new int[storeCinemaId.size()];
        int cinemaIdIndex = 0;
        for(int cinemaId : storeCinemaId) cinemaIds[cinemaIdIndex++] = cinemaId;
        Arrays.sort(cinemaIds);
        return cinemaIds;
    }

    public int[] listShows(int movieId, int cinemaId){
        if(cinemaIdToCinemaMapper.containsKey(cinemaId) == false) return new int[0];
        Cinema cinema = cinemaIdToCinemaMapper.get(cinemaId);
        return cinema.listOfShow(movieId);
    }

}


