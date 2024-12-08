public class Order {
    private String orderId;
    private String destinationPincode;
    private String sellerId;
    private int productId;
    private int productCount;
    private String paymentMode;

    public Order(String orderId, String destinationPincode, String sellerId, int productId, int productCount, String paymentMode) {
        this.orderId = orderId;
        this.destinationPincode = destinationPincode;
        this.sellerId = sellerId;
        this.productId = productId;
        this.productCount = productCount;
        this.paymentMode = paymentMode;
    }

    public String getOrderId() {
        return orderId;
    }


    public String getDestinationPincode() {
        return destinationPincode;
    }


    public String getSellerId() {
        return sellerId;
    }

    public int getProductId() {
        return productId;
    }

    public int getProductCount() {
        return productCount;
    }

    public String getPaymentMode() {
        return paymentMode;
    }
}
