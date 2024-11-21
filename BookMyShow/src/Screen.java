import java.util.*;
class Screen{
    public int cinemaId;
    public int screenId;

    public List<Show> shows = new ArrayList<>();
    public Screen(int cinemaId, int screenId) {
        this.cinemaId = cinemaId;
        this.screenId = screenId;
    }

    public void addShow(Show show){
        shows.add(show);
    }




}