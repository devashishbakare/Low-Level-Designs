public class Food implements RateFoodSubscriber {
    private String foodId;
    private String foodInfo;

    public String restaurantId;

    private int totalRating;
    private int numberOfRating;
    private double averageRating;

    public Food(String foodId, String restaurantId){
        this.foodId = foodId;
        this.restaurantId = restaurantId;
        totalRating = 0;
        numberOfRating = 0;
        averageRating = 0.0;
    }

    public void setFoodInfo(String foodInfo) {
        this.foodInfo = foodInfo;
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
