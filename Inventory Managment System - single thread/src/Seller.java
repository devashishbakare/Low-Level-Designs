import java.util.*;
public class Seller {
    public String sellerId;
    public Set<String> pincodes;
    public Map<Integer, Integer> history;
    public Set<String> paymentMethodAvailable;

    public List<String> orders;

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
    // we can have( name, mobile number, history of seller)
}
