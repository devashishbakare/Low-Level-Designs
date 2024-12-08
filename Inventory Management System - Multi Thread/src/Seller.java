import java.util.*;
public class Seller {
    private String sellerId;
    private Set<String> pincodes;
    private Map<Integer, Integer> history;
    private Set<String> paymentMethodAvailable;
    private List<String> orders;

    public Seller(String sellerId, List<String> pincodes, List<String> paymentMode) {
        this.sellerId = sellerId;
        this.pincodes = new HashSet<>(pincodes);
        this.history = new HashMap();
        this.paymentMethodAvailable = new HashSet<>(paymentMode);
        this.orders = new ArrayList<>();
    }
    
    public void updateSellerHistory(int productId, int delta){
        history.putIfAbsent(productId, history.getOrDefault(productId, 0) + delta);
    }

    public boolean checkIsPincodeAvailable(String pincode){
        return this.pincodes.contains(pincode);
    }
    public boolean checkPaymentModeAvailable(String paymentMode){
        return this.paymentMethodAvailable.contains(paymentMode);
    }

    public void setOrders(String orderId) {
        orders.add(orderId);
    }
    public void addInSellerHistory(int productId, int productCount){
        history.put(productId, history.getOrDefault(productId, 0) + productCount);
    }

    public String getSellerId() {
        return sellerId;
    }

    public Set<String> getPincodes() {
        return pincodes;
    }

    public Map<Integer, Integer> getHistory() {
        return history;
    }

    // we can have( name, mobile number, history of seller)
}
