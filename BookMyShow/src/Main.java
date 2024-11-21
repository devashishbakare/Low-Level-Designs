public class Main {
    public static void main(String[] args) {

        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.addCinema(0, 1,4, 5, 10);
        bookMyShow.addShow(1, 4, 0, 1, 1710516108,1710523308);
        bookMyShow.addShow(2,11, 0, 3, 1710516108,1710523308);

        int listOfCinemas[] = bookMyShow.listCinemas(0, 1);
        System.out.println(listOfCinemas.length);

        int shows[] = bookMyShow.listShows(4, 0);
        for(int showId : shows) System.out.print(showId + ", ");
        System.out.println();

        int shows1[] = bookMyShow.listShows(11, 0);
        for(int showId : shows1) System.out.print(showId + ", ");
        System.out.println();

        System.out.println(bookMyShow.getFreeSeatsCount(1));
        String seats[] = bookMyShow.bookTicket("tkt-1", 1, 4);
        for(String seat : seats) System.out.print(seat + ", ");
        System.out.println();

        System.out.println(bookMyShow.getFreeSeatsCount(1));
        boolean cancelUpdate = bookMyShow.cancelTicket("tkt-1");
        System.out.println(cancelUpdate);

        System.out.println(bookMyShow.getFreeSeatsCount(1));

    }
}