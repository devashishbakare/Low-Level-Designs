import java.util.*;
public class SortByRestaurantRating implements RestaurantSortingStrategy{
    @Override
    public List<String> sort() {
       List<Restaurant> topRatedRestaurants = new ArrayList<>();

        for(String restaurantId : Order.restaurantIdToRestaurantMapper.keySet()){
            Restaurant restaurant = Order.restaurantIdToRestaurantMapper.get(restaurantId);
            topRatedRestaurants.add(restaurant);
        }

        Collections.sort(topRatedRestaurants, (a, b) -> {
            if(a.rating == b.rating){
                return a.restaurantId.compareTo(b.restaurantId);
            }
            return Double.compare(b.rating, a.rating);
        });

        List<String> topRated = new ArrayList<>();

        for(int i = 0; i < Math.min(topRatedRestaurants.size(), 20); i++){
            topRated.add(topRatedRestaurants.get(i).restaurantId);
        }
        return topRated;
    }
}
