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
        rating = (double)((int)((rating+0.05)*10))/10.0;
        //System.out.println("Food Rating: "  + rating+ " No Of " + noOfRatingCount + " " + totalRating);
    }

    @Override
    public double getRating() {
        return rating;
    }
}
