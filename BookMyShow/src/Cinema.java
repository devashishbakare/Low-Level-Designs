import java.util.*;

class Cinema{
    public int cinemaId;
    public int cityId;
    public int screenCount;
    public int screenRow;
    public int screenColumn;
    public List<Screen> cinemaScreen;

    public Cinema(int cinemaId, int cityId, int screenCount, int screenRow, int screenColumn) {
        this.cinemaId = cinemaId;
        this.cityId = cityId;
        this.screenCount = screenCount;
        this.screenRow = screenRow;
        this.screenColumn = screenColumn;
        this.cinemaScreen = new ArrayList<>(screenCount);
        for(int i = 0; i < screenCount; i++){
            cinemaScreen.add(new Screen(cinemaId, i));
        }
    }
    public int[] listOfShow(int movieId){
        List<Show> storeShow = new ArrayList<>();
        List<Screen> screens = cinemaScreen;
        for(Screen screen : screens){
            List<Show> shows = screen.shows;
            for(Show show : shows){
                if(show.movieId == movieId){
                    storeShow.add(show);
                }
            }
        }

        Collections.sort(storeShow, (a, b) -> Long.compare(b.startTime, a.startTime));
        int showIds[] = new int[storeShow.size()];
        int showIdIndex = 0;
        for(Show show : storeShow){
            showIds[showIdIndex++] = show.showId;
        }
        Arrays.sort(showIds);
        return showIds;
    }
}