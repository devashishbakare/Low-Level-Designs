import java.util.*;
public class Inventory {
    public static Inventory inventoryInstance = null;
    public Map<String, Map<Integer, Integer>> sellerToProductToDeltaMapper;

    private Inventory(){
        sellerToProductToDeltaMapper = new HashMap<>();
    }

    public static Inventory createInventory(){
        if(inventoryInstance == null){
            inventoryInstance = new Inventory();
        }
        return inventoryInstance;
    }

    public void addInventory(int productId, String sellerId, int delta){
        if(sellerToProductToDeltaMapper.containsKey(sellerId) == false){
            sellerToProductToDeltaMapper.put(sellerId, new HashMap<>());
        }
        Map<Integer, Integer> productToDeltaMapper = sellerToProductToDeltaMapper.get(sellerId);
        productToDeltaMapper.put(productId, productToDeltaMapper.getOrDefault(productId, 0) + delta);
        sellerToProductToDeltaMapper.put(sellerId, productToDeltaMapper);
    }

    //we can have other methods here not mention in problem statement but we could have here
    //public void updateQuantity(productId, delta)
    //public void addSeller(sellerId, productId)

}
