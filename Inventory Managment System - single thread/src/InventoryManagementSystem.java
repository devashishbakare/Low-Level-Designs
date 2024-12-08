import java.util.*;
public class InventoryManagementSystem {
    //check with public and private in method, what needed here
    private Map<String, Seller> sellerIdToSellerMapper;
    private Map<Integer, Product> productIdToProductMapper;

    public InventoryManagementSystem(){
        sellerIdToSellerMapper = new HashMap<>();
        productIdToProductMapper = new HashMap<>();
    }

    public void createSeller(String sellerId, List<String> pincodes, List<String> paymentMode){
        if(sellerIdToSellerMapper.containsKey(sellerId)) return;
        Seller seller = new Seller(sellerId, pincodes, paymentMode);
        sellerIdToSellerMapper.put(sellerId, seller);
    }

    public String addInventory(int productId, String sellerId, int delta){
        Inventory inventory = Inventory.createInventory();
        inventory.addInventory(productId, sellerId, delta);
        Product product = new Product(productId);
        productIdToProductMapper.put(productId, product);
        return "Inventory Added!";
    }

    public int getInventory(int productId, String sellerId){
        if(!sellerIdToSellerMapper.containsKey(sellerId)  || !productIdToProductMapper.containsKey(productId)) return 0;
        Inventory inventory = Inventory.createInventory();
        if(inventory.sellerToProductToDeltaMapper.get(sellerId).containsKey(productId) == false) return 0;
        Map<Integer, Integer> productToDeltaMapper = inventory.sellerToProductToDeltaMapper.get(sellerId);
        return productToDeltaMapper.get(productId);
    }

    public String createOrder(String orderId, String destinationPincode, String sellerId, int productId, int productCount, String paymentMode){


            //we need to check pincode not serviceable
            Seller seller = sellerIdToSellerMapper.get(sellerId);
            if(!seller.pincodes.contains(destinationPincode)) return "pincode in not serviceable";

            // payment mode is not supported
            if(!seller.paymentMethodAvailable.contains(paymentMode)) return "payement mode not supported";

            // number of product is less in inventory
            Inventory inventory = Inventory.createInventory();
            Map<Integer, Integer> productToDeltaMapper = inventory.sellerToProductToDeltaMapper.get(sellerId);
            if(productToDeltaMapper.get(productId) < productCount) return "insufficient product in inventory";

            //we have to create order
            Order order = new Order(orderId, destinationPincode, sellerId, productId, productCount, paymentMode);

            //then we have to update the inventory quantity
            productToDeltaMapper = inventory.sellerToProductToDeltaMapper.get(sellerId);
            productToDeltaMapper.put(productId, productToDeltaMapper.get(productId)-productCount);
            inventory.sellerToProductToDeltaMapper.put(sellerId, productToDeltaMapper);
            //we have to update seller holding list of orders as well
            seller.orders.add(orderId);
            //we have to update the seller history
            seller.history.put(productId, seller.history.getOrDefault(productId, 0) + productCount);

        return "Order Placed!!";
    }

}
