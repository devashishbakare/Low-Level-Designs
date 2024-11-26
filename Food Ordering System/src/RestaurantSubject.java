public interface RestaurantSubject {
    void addObserver(RestaurantObserver observer);
    void removeObserver(RestaurantObserver observer);
    void notifyObserver(int rating);
}
