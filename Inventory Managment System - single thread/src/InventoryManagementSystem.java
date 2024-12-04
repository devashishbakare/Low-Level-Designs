import java.util.*;
public class InventoryManagementSystem {
    //check with public and private in method, what needed here
    private Map<String, Seller> sellerIdToSellerMapper;
    private Map<Integer, Product> productIdToProductMapper;

    public InventoryManagementSystem(){
        sellerIdToSellerMapper = new HashMap<>();
    }

    public void createSeller(String sellerId, List<String> pincodes, List<String> paymentMode){
        if(sellerIdToSellerMapper.containsKey(sellerId)) return;
        Seller seller = new Seller(sellerId, pincodes, paymentMode);
        sellerIdToSellerMapper.put(sellerId, seller);
    }

    public void addInventory(int productId, String sellerId, int delta){
        Inventory inventory = Inventory.createInventory();
        inventory.addInventory(productId, sellerId, delta);
        Product product = new Product(productId);
        productIdToProductMapper.put(productId, product);
    }

    private int getInventory(int productId, String sellerId){
        if(!sellerIdToSellerMapper.containsKey(sellerId)  || !productIdToProductMapper.containsKey(productId)) return 0;
        Seller seller = sellerIdToSellerMapper.get(sellerId);
        if(seller.history.containsKey(productId) == false) {
            return 0;
        }else{
            return seller.history.get(productId);
        }
    }

}
