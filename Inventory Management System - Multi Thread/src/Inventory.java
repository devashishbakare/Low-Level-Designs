import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Inventory {
    public static Inventory inventoryInstance = null;
    private final ConcurrentHashMap<String, ConcurrentHashMap<Integer, AtomicInteger>> sellerToProductToDeltaMapper;

    private Inventory(){
        sellerToProductToDeltaMapper = new ConcurrentHashMap<>();
    }

    public static Inventory createInventory(){
        if(inventoryInstance == null){
            inventoryInstance = new Inventory();
        }
        return inventoryInstance;
    }

    public ConcurrentHashMap<String, ConcurrentHashMap<Integer, AtomicInteger>> getSellerToProductToDeltaMapper() {
        return sellerToProductToDeltaMapper;
    }

    public void addInventory(int productId, String sellerId, int delta){
        if(sellerToProductToDeltaMapper.containsKey(sellerId) == false){
            sellerToProductToDeltaMapper.put(sellerId, new ConcurrentHashMap<>());
        }
        ConcurrentHashMap<Integer, AtomicInteger> productToDeltaMapper = sellerToProductToDeltaMapper.get(sellerId);
        productToDeltaMapper.put(productId, new AtomicInteger(delta));
        sellerToProductToDeltaMapper.put(sellerId, productToDeltaMapper);
    }



    //we can have other methods here not mention in problem statement but we could have here
    //public void updateQuantity(productId, delta)
    //public void addSeller(sellerId, productId)

}
