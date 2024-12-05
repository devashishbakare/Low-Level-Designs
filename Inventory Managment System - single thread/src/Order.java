public class Order {
    public String orderId;
    public String destinationPincode;
    public String sellerId;
    public int productId;
    public int productCount;
    public String paymentMode;

    public Order(String orderId, String destinationPincode, String sellerId, int productId, int productCount, String paymentMode) {
        this.orderId = orderId;
        this.destinationPincode = destinationPincode;
        this.sellerId = sellerId;
        this.productId = productId;
        this.productCount = productCount;
        this.paymentMode = paymentMode;
    }
}
