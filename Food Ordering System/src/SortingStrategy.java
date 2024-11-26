import java.util.*;
public class SortingStrategy {
    public RestaurantSortingStrategy restaurantSortingStrategy;
    public void setSortingStrategy(RestaurantSortingStrategy restaurantSortingStrategy){
        this.restaurantSortingStrategy = restaurantSortingStrategy;
    }
    public List<String> sort(){
        return restaurantSortingStrategy.sort();
    }
}
