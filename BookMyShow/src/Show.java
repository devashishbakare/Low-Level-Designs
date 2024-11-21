import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Show{
    public int showId;
    public int movieId;
    public int cinemaId;
    public int screenIndex;
    public long startTime;
    public long endTime;
    public int seats[][];

    public int bookSeatCount;

    public Show(int showId, int movieId, int cinemaId, int screenIndex, long startTime, long endTime, int rowLength, int columnLength) {
        this.showId = showId;
        this.movieId = movieId;
        this.cinemaId = cinemaId;
        this.screenIndex = screenIndex;
        this.startTime = startTime;
        this.endTime = endTime;
        seats = new int[rowLength][columnLength];
        bookSeatCount = 0;
    }


}