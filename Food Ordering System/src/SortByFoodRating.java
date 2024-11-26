import java.util.*;

public class SortByFoodRating implements RestaurantSortingStrategy{

    private String foodId;
    public SortByFoodRating(String foodId){
        this.foodId = foodId;
    }
    @Override
    public List<String> sort() {

        List<Restaurant> topRatedRestaurants = new ArrayList<>();

        for(String restaurantId : Order.restaurantAndFoodMapper.keySet()){
            Set<String> listOfFood = Order.restaurantAndFoodMapper.get(restaurantId);
            if(listOfFood.contains(foodId)){
                topRatedRestaurants.add(Order.restaurantIdToRestaurantMapper.get(restaurantId));
            }
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
