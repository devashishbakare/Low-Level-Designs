import java.util.*;
public class Restaurant implements RateFoodSubscriber {
    public String restaurantId;
    private String name;
    private String address;
    private double rating;
    private List<Food> foodList;

    private int totalRating;
    private int numberOfRating;
    private double averageRating;

    public Restaurant(String restaurantId) {
        this.restaurantId = restaurantId;
        foodList = new ArrayList<>();
        totalRating = 0;
        numberOfRating = 0;
        averageRating = 0.0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void rateItem(int rating) {
        if(rating == 0) return;
        totalRating += rating;
        numberOfRating++;
        averageRating = (double)totalRating/numberOfRating;
        averageRating = (double) ((int) ((averageRating + 0.05) * 10)) / 10.0;
        //System.out.println(averageRating);
    }

    public double getAverageRating(){
        return averageRating;
    }
}
