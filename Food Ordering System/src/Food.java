public class Food implements RestaurantObserver{
    public String foodId;
    public String restaurantId;

    public static int totalRating;
    public static double rating;
    public static int noOfRatingCount;

    public Food(String foodId, String restaurantId) {
        this.foodId = foodId;
        this.restaurantId = restaurantId;
        noOfRatingCount = 0;
    }


    public void addRating(int rating) {
        noOfRatingCount++;
        totalRating += rating;
        calculateRating();
    }

    public void calculateRating(){
        rating = (double)totalRating/noOfRatingCount;
        System.out.println("Food Rating: "  + rating);
    }

    @Override
    public double getRating() {
        return rating;
    }
}
