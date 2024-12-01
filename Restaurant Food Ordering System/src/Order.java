import java.util.*;
public class Order implements RateOrderObserver{
    private String orderId;
    private Map<Restaurant, List<Food>> restaurantAndFood;

    private List<RateFoodSubscriber> subscriberList;

    public Order(String orderId){
        this.orderId = orderId;
        restaurantAndFood = new HashMap<>();
        subscriberList = new ArrayList<>();
    }

    public void addOrder(Restaurant restaurant, Food food){
        restaurantAndFood.computeIfAbsent(restaurant, v -> new ArrayList<>()).add(food);
        subscriberList.add(restaurant);
        subscriberList.add(food);
        //System.out.println("adding order from order : adding to subscriber list");
    }

    public void rateOrder(int rating){
        //System.out.println("Rating order from order");
        notifySubscriber(rating);
    }

    @Override
    public void addSubscriber(RateFoodSubscriber subscriber) {
        subscriberList.add(subscriber);
    }

    @Override
    public void removeSubscriber(RateFoodSubscriber subscriber) {
        subscriberList.remove(subscriber);
    }

    @Override
    public void notifySubscriber(int rating) {
        //System.out.println("Nofitying from order");
        for(RateFoodSubscriber rateFoodSubscriber : subscriberList){
            //System.out.print(rateFoodSubscriber + ", ");
            rateFoodSubscriber.rateItem(rating);
        }
        //System.out.println();
    }
}
