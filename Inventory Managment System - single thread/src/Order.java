public class Order {
    public String orderId;
    public String destinationPincode;
    public String sellerId;
    public int productId;
    public int productCount;
    Enum paymentMode;

    public Order(String orderId, String destinationPincode, String sellerId, int productId, int productCount, Enum paymentMode) {
        this.orderId = orderId;
        this.destinationPincode = destinationPincode;
        this.sellerId = sellerId;
        this.productId = productId;
        this.productCount = productCount;
        this.paymentMode = paymentMode;
    }
}
