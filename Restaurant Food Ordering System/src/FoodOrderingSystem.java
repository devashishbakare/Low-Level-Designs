import java.util.*;

public class FoodOrderingSystem {
    private Map<String, Order> orderIdToOrderMapper;
    private Map<String, Restaurant> restaurantIdToRestaurantMapper;
    private Map<String, Food> foodIdToFoodMapper;

    private Map<String, Set<String>> foodIdToRestaurantMapper;


    public FoodOrderingSystem(){
        orderIdToOrderMapper = new HashMap<>();
        restaurantIdToRestaurantMapper = new HashMap<>();
        foodIdToFoodMapper = new HashMap<>();
        foodIdToRestaurantMapper = new HashMap<>();

    }

    public void orderFood(String orderId, String restaurantId, String foodId){
        Order order = new Order(orderId);
        Restaurant restaurant = null;
        if(restaurantIdToRestaurantMapper.containsKey(restaurantId)){
            restaurant = restaurantIdToRestaurantMapper.get(restaurantId);
        }else{
            restaurant = new Restaurant(restaurantId);
            restaurantIdToRestaurantMapper.put(restaurantId, restaurant);
        }
        Food food = null;
        if(foodIdToFoodMapper.containsKey(foodId)){
            food = foodIdToFoodMapper.get(foodId);
        }else{
            food = new Food(foodId, restaurantId);
            foodIdToFoodMapper.put(foodId, food);
        }
        //System.out.println("adding order from system");
        order.addOrder(restaurant, food);
        foodIdToRestaurantMapper.computeIfAbsent(foodId, v -> new HashSet<>()).add(restaurantId);
        orderIdToOrderMapper.put(orderId, order);
    }
    public void rateOrder(String orderId, int rating){
        if(orderIdToOrderMapper.containsKey(orderId) == false) return;
        //System.out.println("Rating order from system");
        Order order = orderIdToOrderMapper.get(orderId);
        order.rateOrder(rating);
    }
    public List<String> getTopRestaurantsByFood(String foodItemId){

        if(foodIdToRestaurantMapper.size() == 0) return new ArrayList<>();
        Set<String> restaurantList = foodIdToRestaurantMapper.get(foodItemId);
        System.out.println(restaurantList.size());
        List<Restaurant> storeRestaurantList = new ArrayList<>();
        for(String restaurantId : restaurantList){
            Restaurant restaurant = restaurantIdToRestaurantMapper.get(restaurantId);
            storeRestaurantList.add(restaurant);
        }

        List<String> storeResult = new ArrayList<>();
        Collections.sort(storeRestaurantList, (a, b) -> {
            if(a.getAverageRating() == b.getAverageRating()){
                return a.restaurantId.compareTo(b.restaurantId);
            }
            return Double.compare(b.getAverageRating(), a.getAverageRating());
        });

        for(Restaurant restaurant : storeRestaurantList){
            System.out.println(restaurant.getAverageRating());
            storeResult.add(restaurant.restaurantId);
        }

       return storeResult;
    }

    public List<String> getTopRatedRestaurants(){

        List<String> topRatedRestaurant = new ArrayList<>();
        List<Restaurant> storeRestaurantItem = new ArrayList<>();
        for(String restaurantId : restaurantIdToRestaurantMapper.keySet()){
            Restaurant restaurant = restaurantIdToRestaurantMapper.get(restaurantId);
            storeRestaurantItem.add(restaurant);
        }
        Collections.sort(storeRestaurantItem, (a, b) -> {
            if(a.getAverageRating() == b.getAverageRating()){
                return a.restaurantId.compareTo(b.restaurantId);
            }
            return Double.compare(b.getAverageRating(), a.getAverageRating());
        });

        for(Restaurant restaurant : storeRestaurantItem){
            topRatedRestaurant.add(restaurant.restaurantId);
        }
        return topRatedRestaurant;
    }

}
