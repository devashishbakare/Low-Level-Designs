public interface RateOrderObserver {
    void addSubscriber(RateFoodSubscriber rateFoodSubscriber);
    void removeSubscriber(RateFoodSubscriber rateFoodSubscriber);
    void notifySubscriber(int rating);
}
