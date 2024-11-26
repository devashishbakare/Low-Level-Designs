import java.util.*;

public class FoodOrderingSystem {

    public Map<String, Order> orderIdToOrderMapper;
    public FoodOrderingSystem(){
        orderIdToOrderMapper = new HashMap<>();
    }
    public void orderFood(String orderId, String restaurantId, String foodItem) {
        Order order = new Order();
        order.addOrder(orderId, restaurantId, foodItem);
        orderIdToOrderMapper.put(orderId, order);
    }

    public void rateOrder(String orderId, int rating) {
        if(orderIdToOrderMapper.containsKey(orderId) == false) return;
        Order order = orderIdToOrderMapper.get(orderId);
        order.rateOrder(rating);
    }

    public List<String> getTopRestaurantsByFood(String foodId) {
        RestaurantSortingStrategy byFood = new SortByFoodRating(foodId);
        return byFood.sort();
    }
    public List<String> getTopRatedRestaurants(){
        RestaurantSortingStrategy byRestaurant = new SortByRestaurantRating();
        return byRestaurant.sort();
    }
}
