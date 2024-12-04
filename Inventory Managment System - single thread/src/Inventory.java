import java.util.*;
public class Inventory {
    public static Inventory inventoryInstance = null;
    public Map<Integer, Integer> productToQuantityMapper;
    public Map<Integer, List<String>> productToSellerMapper;

    private Inventory(){
        productToQuantityMapper = new HashMap<>();
        productToSellerMapper = new HashMap<>();
    }

    public static Inventory createInventory(){
        if(inventoryInstance == null){
            inventoryInstance = new Inventory();
        }
        return inventoryInstance;
    }

    public void addInventory(int productId, String sellerId, int delta){
        productToQuantityMapper.put(productId, delta);
        productToSellerMapper.computeIfAbsent(productId, v -> new ArrayList<>()).add(sellerId);
    }

    //we can have other methods here not mention in problem statement but we could have here
    //public void updateQuantity(productId, delta)
    //public void addSeller(sellerId, productId)

}
