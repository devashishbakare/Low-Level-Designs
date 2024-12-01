import java.util.*;
public class Order implements RestaurantSubject{

    public String orderId;
    public static Map<String, Set<String>> restaurantAndFoodMapper;
    public static Map<String, Restaurant> restaurantIdToRestaurantMapper;
    public static Map<String, Food> foodIdToFoodMapper;
    List<RestaurantObserver> restaurantObserverList;


    public Order(){
        restaurantAndFoodMapper = new HashMap<>();
        restaurantIdToRestaurantMapper =  new HashMap<>();
        foodIdToFoodMapper =  new HashMap<>();
        restaurantObserverList = new ArrayList<>();
    }

    public void addOrder(String orderId, String restaurantId, String foodItemId){
        Restaurant restaurant = new Restaurant(restaurantId);
        Food food = new Food(foodItemId, restaurantId);
        restaurantIdToRestaurantMapper.put(restaurantId, restaurant);
        foodIdToFoodMapper.put(foodItemId, food);
        restaurant.setAvailableFood(foodItemId);
        restaurantAndFoodMapper.computeIfAbsent(restaurantId, k -> new HashSet<>()).add(foodItemId);
        this.orderId = orderId;
        addObserver(restaurant);
        addObserver(food);
    }

    public void rateOrder(int rating){
        notifyObserver(rating);
    }


    @Override
    public void addObserver(RestaurantObserver observer) {
        restaurantObserverList.add(observer);
    }

    @Override
    public void removeObserver(RestaurantObserver observer) {
        restaurantObserverList.remove(observer);
    }

    @Override
    public void notifyObserver(int rating) {
        for(RestaurantObserver observer : restaurantObserverList){
            observer.addRating(rating);
        }
    }
}
