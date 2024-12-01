import java.util.*;
public class Restaurant implements RestaurantObserver{
    public String restaurantId;
    public static int totalRating;
    public static int noOfRatingCount;
    public static double rating;
    public Set<String> availableFood;

    public Restaurant(String restaurantId) {
        this.restaurantId = restaurantId;
        noOfRatingCount = 0;
        availableFood = new HashSet<>();
    }

    public void setAvailableFood(String foodId){
        availableFood.add(foodId);
    }

    @Override
    public void addRating(int rating) {
        noOfRatingCount++;
        totalRating += rating;
        calculateRating();
    }

    public void calculateRating(){
        rating = (double)totalRating/noOfRatingCount;
        rating = (double)((int)((rating+0.05)*10))/10.0;
        //System.out.println("Restaurant Rating: "  + rating);
    }

    @Override
    public double getRating() {
        return rating;
    }
}
